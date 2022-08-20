package com.example.informatorio.noticias.controller;

import com.example.informatorio.noticias.domain.Article;
import com.example.informatorio.noticias.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private ArticleRepository articleRepository;
    //private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @PostMapping("/article")
    public Article createArticle(@RequestBody Article articles) {
        return articleRepository.save(articles);
    }

    @GetMapping("/article")
    public List<Article> getAll() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    @GetMapping("/article/{valor}")
    public List<Article> findByWord(@PathVariable("valor") Integer valor) {
        return articleRepository.findByTitleGreaterThan(valor);
    }

    @DeleteMapping("/article/{idArticle}")
    public void deleteArticle(@PathVariable Long idArticle) {
        articleRepository.deleteById(idArticle);
    }

    @PutMapping("/article/{idArticle}")
    public Article modifyAuthor(@PathVariable Long idArticle, @RequestBody Article article) {
        Article articles = articleRepository.findById(idArticle).get();
        articles.setTitle(article.getTitle());
        articles.setDescription(article.getDescription());
        articles.setUrl(article.getUrl());
        articles.setUrlToImage(article.getUrlToImage());
        articles.setPublishedAt(article.getPublishedAt());
        articles.setContent(article.getContent());
        articles.setAuthor(article.getAuthor());
        articles.setSource(article.getSource());
        return articleRepository.save(articles);
    }

}
