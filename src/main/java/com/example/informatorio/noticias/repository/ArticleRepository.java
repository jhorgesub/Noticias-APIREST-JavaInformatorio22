package com.example.informatorio.noticias.repository;

import com.example.informatorio.noticias.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByTitleAndDescriptionContaining(String title, String description);
}
