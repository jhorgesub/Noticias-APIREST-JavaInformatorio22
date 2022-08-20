package com.example.informatorio.noticias.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String fullName;
    private LocalDate createdAt;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    public Author() {
    }

    public Author(Long id,
                  String name,
                  String lastName,
                  String fullName,
                  LocalDate createdAt
                  ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.fullName = fullName;
        this.createdAt = createdAt;
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
        this.fullName = name + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.fullName = name + " " + lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<Article> getArticles() {
        return articles;
    }
    public void addArticle(Article article) {
        articles.add(article);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(lastName, author.lastName) && Objects.equals(fullName, author.fullName) && Objects.equals(createdAt, author.createdAt) && Objects.equals(articles, author.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, fullName, createdAt, articles);
    }

    @Override
    public String toString() {
        return "Author{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
