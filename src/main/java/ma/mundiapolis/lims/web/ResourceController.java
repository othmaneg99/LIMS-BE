package ma.mundiapolis.lims.web;

import ma.mundiapolis.lims.dao.ArticleRepository;
import ma.mundiapolis.lims.dao.CategoryRepository;
import ma.mundiapolis.lims.entities.Article;
import ma.mundiapolis.lims.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class ResourceController {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path = "/getarticles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @RequestMapping(value = "/addArticle")
    public Article addArticle(Article a) {
        return articleRepository.save(a);
    }

    @GetMapping(path = "/photoArticle/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
        Article a = articleRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/lims/articles/" + a.getPhotoName()));
    }

    @PostMapping("/admin/createCategory")
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping("/admin/categories/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryId)
            throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

        categoryRepository.delete(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
