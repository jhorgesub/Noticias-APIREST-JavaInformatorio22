package com.example.informatorio.noticias.repository;

import com.example.informatorio.noticias.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findByNameContaining(String word);
}
