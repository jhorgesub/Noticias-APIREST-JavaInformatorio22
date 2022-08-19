package com.example.informatorio.noticias.controller;

import com.example.informatorio.noticias.domain.Article;
import com.example.informatorio.noticias.domain.Author;
import com.example.informatorio.noticias.repository.ArticleRepository;
import com.example.informatorio.noticias.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, ArticleRepository articleRepository) {
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/author")
    public List<Author> getAll() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

    /*@GetMapping
    public List<Author> buscarPorPalabra(@RequestParam String word) {
        return authorRepository.findByNameContaining(word);
    }*/ //no me sale

    @PostMapping("/author")
    public Author createActor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PostMapping("/author/{idAuthor}/article")
    public Author addArticleToAuthor(@PathVariable Long idAuthor, @RequestBody List<Long> idArticles) {
        Author author = authorRepository.findById(idAuthor).orElse(null); //primero vemos si existe el author
        List<Article> articles = idArticles.stream() //recorro la lista de articles
                .map(id -> articleRepository.findById(id)) //para encontrar el article con id
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        for (Article article : articles ) {
            author.addArticle(article);
        }
        authorRepository.save(author);
        return author;
    }

    @DeleteMapping("/author/{idAuthor}")
    public void deleteAuthor(@PathVariable Long idAuthor) {
        authorRepository.deleteById(idAuthor);
    }

    @PutMapping("/author/{idAuthor}")
    public Author modifyAuthor(@PathVariable Long idAuthor, @RequestBody Author author) {
        Author authors = authorRepository.findById(idAuthor).get();
        authors.setName(author.getName());
        authors.setCreatedAt(author.getCreatedAt());
        return authorRepository.save(authors);
    }
}
