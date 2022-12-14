package com.example.informatorio.noticias.controller;

//import com.example.informatorio.noticias.converter.AuthorConverter;
import com.example.informatorio.noticias.domain.Article;
import com.example.informatorio.noticias.domain.Author;
import com.example.informatorio.noticias.dto.AuthorDTO;
import com.example.informatorio.noticias.repository.ArticleRepository;
import com.example.informatorio.noticias.repository.AuthorRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;
    //private final AuthorConverter authorConverter;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, ArticleRepository articleRepository/*, AuthorConverter authorConverter*/) {
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
        //this.authorConverter = authorConverter;
    }

    @GetMapping("/author")
    public List<Author> getAll() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

    @GetMapping("/author/{fullname}")
    public List<Author> buscarPorPalabra(@PathVariable String fullname) {
        return authorRepository.findByFullNameContaining(fullname);
    }

    /*@GetMapping("/author") //funciona sólo con @RequestParam
    public List<Author> buscarPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return authorRepository.findByCreatedAtAfter(fecha);
    }*/

    @PostMapping("/author")
    public ResponseEntity<?> createActor(@RequestBody Author author) {
        return new ResponseEntity<>(authorRepository.save(author), HttpStatus.CREATED);
    }

    @PostMapping("/author/{idAuthor}/article") //no agrega authors a articles(no funciona con bidireccionalidad, sí con unidireccional)
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
    public Author modifyAuthor(@PathVariable("idAuthor") Long idAuthor, @RequestBody Author author) {
        Author authors = authorRepository.findById(idAuthor).get();
        authors.setName(author.getName());
        /*authors.setLastName(author.getLastName());
        authors.setCreatedAt(author.getCreatedAt());*/
        return authorRepository.save(authors);
    }
}
