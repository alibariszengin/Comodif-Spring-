package com.comodif.controller;

import com.comodif.domain.Article;
import com.comodif.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Page<Article>> getAllArticles(@RequestParam(value="pageNo", defaultValue="0") Integer pageNo,
                                                        @RequestParam(value="pageSize", defaultValue="100") Integer pageSize) {

        return ResponseEntity.status(HttpStatus.OK).body(articleService.getAllArticles(pageNo, pageSize));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Article> createArticle(@RequestParam String title,
                                                 @RequestParam String author,
                                                 @RequestParam String content,
                                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date publishDate) {

        return ResponseEntity.status(HttpStatus.OK).body(articleService.createArticle(title, author, content, publishDate));
    }
}
