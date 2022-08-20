package com.example.informatorio.noticias.repository;

import com.example.informatorio.noticias.domain.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Source,Long> {
    List<Source> findBySourceNameContaining(String sourcename);
}
