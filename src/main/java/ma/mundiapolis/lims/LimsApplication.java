package ma.mundiapolis.lims;

import ma.mundiapolis.lims.dao.ArticleRepository;
import ma.mundiapolis.lims.dao.CategoryRepository;
import ma.mundiapolis.lims.dao.LaboratoryRepository;
import ma.mundiapolis.lims.entities.Article;
import ma.mundiapolis.lims.entities.Category;
import ma.mundiapolis.lims.entities.Laboratory;
import ma.mundiapolis.lims.service.LimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class LimsApplication implements CommandLineRunner {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    LaboratoryRepository laboratoryRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LimsApplication.class, args);
    }
    @Autowired
    private LimsService limsService;
    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Article.class,Laboratory.class, Category.class);
        limsService.initArticles();
        limsService.initLaboratories();


/*
        Article article = new Article();
        article.setRef("dxs-25166");
        article.setName("Arduino");
        article.setDescription("Arduino est une carte programmable sur laquelle on peut connecter des capteurs (de pression, de " +
                "luminosité, de mouvement, etc.) pour déclencher des actions sur des moteurs, des diodes, des écans d’affichage, " +
                "etc. Les activités d’algorithmique et de programmation peuvent trouver des applications concrètes en robotique, " +
                "pour des expériences scientifiques ou des réalisations artistiques.");
        article.setConsumable(false);
        article.setCurrentStock(10);
        article.setActive(true);
        article.setPhotoName("arduino.jpg");
        article.setMinStock(2);
        article.setLaboratory(laboratoryRepository.findAllById(new Long(5)));
        article.setCategory(categoryRepository.findAllById(new Long(1)));
        articleRepository.save(article);

        Article article2 = new Article();
        article2.setRef("vfx-788153");
        article2.setName("multimètre");
        article2.setDescription("Un multimètre (parfois appelé contrôleur universel) est un ensemble d'appareils de mesures électriques regroupés en un seul boîtier1, " +
                "généralement constitué d'un voltmètre, d'un ampèremètre et d'un ohmmètre. Les fonctions voltmètre et ampèremètre sont disponibles en continu et" +
                " en alternatif.");
        article2.setConsumable(false);
        article2.setCurrentStock(7);
        article2.setActive(true);
        article2.setPhotoName("multimetre.jpg");
        article2.setMinStock(2);
        article2.setLaboratory(laboratoryRepository.findAllById(new Long(5)));
        article.setCategory(categoryRepository.findAllById(new Long(2)));
        articleRepository.save(article2);

*/

    }
}
