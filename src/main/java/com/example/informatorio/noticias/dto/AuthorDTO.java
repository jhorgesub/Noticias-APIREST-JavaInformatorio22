package com.example.informatorio.noticias.dto;

import com.example.informatorio.noticias.domain.Article;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorDTO {
    private Long id;
    private String name;
    private String lastName;
    private String fullName;
    private LocalDate createdAt;
    private List<ArticleDTO> articles = new ArrayList<>();

    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String name, String lastName, String fullName, LocalDate createdAt, List<ArticleDTO> articles) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.fullName = fullName;
        this.createdAt = createdAt;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return Objects.equals(id, authorDTO.id) && Objects.equals(name, authorDTO.name) && Objects.equals(lastName, authorDTO.lastName) && Objects.equals(fullName, authorDTO.fullName) && Objects.equals(createdAt, authorDTO.createdAt) && Objects.equals(articles, authorDTO.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, fullName, createdAt, articles);
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createdAt=" + createdAt +
                ", articles=" + articles +
                '}';
    }
}
