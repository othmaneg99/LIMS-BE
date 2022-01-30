package ma.mundiapolis.lims.service;

import ma.mundiapolis.lims.dao.ArticleRepository;
import ma.mundiapolis.lims.dao.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LimsServiceImpl implements LimsService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    LaboratoryRepository laboratoryRepository;

    @Override
    public void initLaboratories() {

    }

    @Override
    public void initArticles() {

    }

}
