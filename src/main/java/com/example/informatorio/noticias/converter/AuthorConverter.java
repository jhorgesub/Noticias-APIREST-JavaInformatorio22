/*
package com.example.informatorio.noticias.converter;

import com.example.informatorio.noticias.domain.Article;
import com.example.informatorio.noticias.domain.Author;
import com.example.informatorio.noticias.dto.ArticleDTO;
import com.example.informatorio.noticias.dto.AuthorDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class AuthorConverter {

    public AuthorDTO toDTO(Author author) {
        return new AuthorDTO(author.getId(),
                author.getName(),
                author.getLastName(),
                author.getFullName(),
                author.getCreatedAt(),
                convertArticlesToDTO(author.getArticles()));
    }

    private List<ArticleDTO> convertArticlesToDTO(List<Article> articles) {
        return articles.stream()
                .map(article -> convertArticleToDTO(article))
                .collect(Collectors.toList());
    }

    private ArticleDTO convertArticleToDTO(Article article) {
        return new ArticleDTO(article.getId(),
                article.getTitle(),
                article.getDescription(),
                article.getUrl(),
                article.getUrlToImage(),
                article.getPublishedAt(),
                article.getContent(),
                article.getAuthor(),
                article.getSource());
    }
}
*/
