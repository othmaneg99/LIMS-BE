package ma.mundiapolis.lims.service;

import ma.mundiapolis.lims.dao.CategoryRepository;
import ma.mundiapolis.lims.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryRestService {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping ("/admin/createCategory")
    public Category createCategory( @RequestBody Category category) {
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
