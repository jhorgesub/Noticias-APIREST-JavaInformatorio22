package com.example.informatorio.noticias.controller;

import com.example.informatorio.noticias.domain.Author;
import com.example.informatorio.noticias.domain.Source;
import com.example.informatorio.noticias.repository.SourceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SourceController {

    private final SourceRepository sourceRepository;

    public SourceController(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @PostMapping("/source")
    public Source createSource(@RequestBody Source source) {
        return sourceRepository.save(source);
    }

    @DeleteMapping("/source")
    public void deleteSource(@RequestParam Long id) {
        sourceRepository.deleteById(id);
    }

    /*@GetMapping("/source")
    public List<Source> getAll() {
        List<Source> sources = sourceRepository.findAll();
        return sources;
    }*/

    @GetMapping("/source")
    public List<Source> buscarPorPalabra(@RequestParam String sourcename) {
        return sourceRepository.findBySourceNameContaining(sourcename);
    }

    @PutMapping("/source/{idSource}")
    public Source modifySource(@PathVariable Long idSource, @RequestBody Source source) {
        Source sources = sourceRepository.findById(idSource).get();
        sources.setSourceName(source.getSourceName());
        sources.setCode(source.getCode());
        sources.setCreatedAt(source.getCreatedAt());
        return sourceRepository.save(sources);
    }
}
