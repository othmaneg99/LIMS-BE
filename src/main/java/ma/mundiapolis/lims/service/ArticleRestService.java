package ma.mundiapolis.lims.service;

import ma.mundiapolis.lims.dao.ArticleRepository;
import ma.mundiapolis.lims.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleRestService {
    @Autowired
    private ArticleRepository articleRepository;
@RequestMapping(value="/addArticle")
    public Article addArticle(Article a) {
        return articleRepository.save(a);
    }
}
