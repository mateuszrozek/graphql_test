package com.test.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.test.model.Article;
import com.test.repo.ArticleRepository;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private ArticleRepository articleRepository;

    public Mutation(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article newArticle(String title, String text){
        Article article = new Article();
        article.setTitle(title);
        article.setText(text);
        articleRepository.save(article);
        return article;
    }
}
