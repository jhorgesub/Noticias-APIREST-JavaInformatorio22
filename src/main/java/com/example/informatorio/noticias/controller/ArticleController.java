package com.example.informatorio.noticias.controller;

import com.example.informatorio.noticias.domain.Article;
import com.example.informatorio.noticias.domain.Author;
import com.example.informatorio.noticias.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
@Validated
@RestController
public class ArticleController {

    private ArticleRepository articleRepository;
    //private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @PostMapping("/article")
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        return new ResponseEntity<>(articleRepository.save(article), HttpStatus.CREATED);
    }

    /*@GetMapping("/article")
    public List<Article> getAll() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }*/

    @GetMapping("/article/{title}/{description}") //funciona con una palabra, no con dos
    public List<Article> buscarPorPalabra(@PathVariable @Valid @Size(min=4) String title,@PathVariable @Valid @Size(min=4)  String description) {
        return articleRepository.findByTitleAndDescriptionContaining(title, description);
    }

    @DeleteMapping("/article")
    public void deleteArticle(@RequestParam Long id) {
        articleRepository.deleteById(id);
    }

    @PutMapping("/article/{idArticle}")
    public Article modifyAuthor(@PathVariable Long idArticle, @RequestBody Article article) {
        Article articles = articleRepository.findById(idArticle).get();
        articles.setTitle(article.getTitle());
        /*articles.setDescription(article.getDescription());
        articles.setUrl(article.getUrl());
        articles.setUrlToImage(article.getUrlToImage());
        articles.setPublishedAt(article.getPublishedAt());
        articles.setContent(article.getContent());
        articles.setAuthor(article.getAuthor());
        articles.setSource(article.getSource());*/
        return articleRepository.save(articles);
    }

}
