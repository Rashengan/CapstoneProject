package Capstone.Project.service;

import Capstone.Project.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Capstone.Project.repository.ArticleRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public void CreateArticle(Article art){ articleRepository.createArticle(art);}

    public List<Article> Similarity(){return articleRepository.similarity();}
}
