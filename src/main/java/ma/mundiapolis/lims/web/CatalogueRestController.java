package ma.mundiapolis.lims.web;

import ma.mundiapolis.lims.dao.ArticleRepository;
import ma.mundiapolis.lims.entities.Article;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class CatalogueRestController {
    private ArticleRepository articleRepository;

    public CatalogueRestController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(path = "/photoArticle/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
        Article a = articleRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/lims/articles/" + a.getPhotoName()));
    }
}
