package com.test.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.test.model.Article;
import com.test.repo.ArticleRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLResolver {

    private ArticleRepository articleRepository;

    public Query(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Optional<Article> article(Long id){
        return articleRepository.findById(id);
    }
    public Iterable<Article> findAllArticles(){
        return articleRepository.findAll();
    }
}
