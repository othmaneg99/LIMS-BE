package ma.mundiapolis.lims;

import ma.mundiapolis.lims.dao.ArticleRepository;
import ma.mundiapolis.lims.dao.LaboratoryRepository;
import ma.mundiapolis.lims.entities.Article;
import ma.mundiapolis.lims.entities.Laboratory;
import ma.mundiapolis.lims.service.LimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LimsApplication implements CommandLineRunner {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    LaboratoryRepository laboratoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(LimsApplication.class, args);
    }
    @Autowired
    private LimsService limsService;
    @Override
    public void run(String... args) throws Exception {
        limsService.initArticles();
        limsService.initLaboratories();
        laboratoryRepository.save(new Laboratory(null,"robotique",true,null));
        laboratoryRepository.save(new Laboratory(null,"optique",true,null));
        laboratoryRepository.save(new Laboratory(null,"électricité",true,null));
        laboratoryRepository.save(new Laboratory(null,"chimie",true,null));
        laboratoryRepository.save(new Laboratory(null,"électronique",true,null));
        laboratoryRepository.save(new Laboratory(null,"génie industriel",true,null));
        laboratoryRepository.save(new Laboratory(null,"génie civil",true,null));

        Article article = new Article();
        article.setRef("dxs-25166");
        article.setName("Arduino");
        article.setDescription("Arduino est une carte programmable sur laquelle on peut connecter des capteurs (de pression, de " +
                "luminosité, de mouvement, etc.) pour déclencher des actions sur des moteurs, des diodes, des écans d’affichage, " +
                "etc. Les activités d’algorithmique et de programmation peuvent trouver des applications concrètes en robotique, " +
                "pour des expériences scientifiques ou des réalisations artistiques.");
        article.setConsumable(true);
        article.setCurrentStock(10);
        article.setActive(true);
        article.setMinStock(2);
        article.setLaboratory(laboratoryRepository.findAllById(new Long(5)));
        articleRepository.save(article);
    }
}
