package ma.mundiapolis.lims.dao;

import ma.mundiapolis.lims.entities.Category;
import ma.mundiapolis.lims.entities.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findAllById(Long id);
}
