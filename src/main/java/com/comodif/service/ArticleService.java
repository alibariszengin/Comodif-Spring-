package com.comodif.service;

import com.comodif.domain.Article;
import com.comodif.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Page<Article> getAllArticles(Integer pageNo, Integer pageSize) {
        Pageable pagination = PageRequest.of(pageNo, pageSize);
        return articleRepository.findAll(pagination);
    }

    public Article createArticle(String title, String author, String content, Date publishDate) {
        Article article = new Article(title, author, content, publishDate);
        articleRepository.save(article);
        return article;
    }
}
