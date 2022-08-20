package com.example.informatorio.noticias.repository;

import com.example.informatorio.noticias.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findByFullNameContaining(String word);
    List<Author> findByCreatedAtAfter(LocalDate fecha);
}
