package ma.mundiapolis.lims.dao;

import ma.mundiapolis.lims.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ArticleRepository extends JpaRepository<Article, Long> {

@RestResource(path = "/articlesByKeyword")
    public List<Article> findByNameContains(@Param("mc") String mc);

}
