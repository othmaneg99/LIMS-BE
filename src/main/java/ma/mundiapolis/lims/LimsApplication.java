package ma.mundiapolis.lims;

import ma.mundiapolis.lims.entities.Article;
import ma.mundiapolis.lims.entities.Category;
import ma.mundiapolis.lims.entities.Laboratory;
import ma.mundiapolis.lims.service.IResourceInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class LimsApplication implements CommandLineRunner {

    @Autowired
    private IResourceInitService resourceInitService;

    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LimsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Article.class, Laboratory.class, Category.class);
        resourceInitService.initArticles();
        resourceInitService.initLaboratories();
    }
}
