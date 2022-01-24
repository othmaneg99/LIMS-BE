package ma.mundiapolis.lims.service;

import ma.mundiapolis.lims.dao.ArticleRepository;
import ma.mundiapolis.lims.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class LimsServiceImpl implements LimsService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void initArticles() {
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
        articleRepository.save(article);
    }
}
