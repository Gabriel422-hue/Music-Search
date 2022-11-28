package com.music.demo.controllers;

import com.music.demo.model.Musica;
import com.music.demo.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.Optional;


@RestController
@RequestMapping("/api/musicas")
@PreAuthorize("hasRole('ADMIN')")
public class GetMusicController {

    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
    public Iterable<Musica> obterMusicaPorPagina
            (@PathVariable int numeroPagina,
             @PathVariable int qtdePagina) {
        if (qtdePagina >= 5) qtdePagina = 5;
        Pageable page = (Pageable) PageRequest.of(numeroPagina, qtdePagina);
        return musicaRepository.findAll((Sort) page);
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public Iterable<Musica> obterMusica() {
        return musicaRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Musica> obterMusicasPorNome(@PathVariable String parteNome) {
        return musicaRepository.findByNomeDaMusicaContainingIgnoreCase(parteNome);
    }

    @GetMapping(path = "/tom/{parteTom}")
    public Iterable<Musica> obterMusicaPorTom(@PathVariable String parteTom) {
        return musicaRepository.findBytomContainingIgnoreCase(parteTom);
    }

    @GetMapping(path = "/quemCanta/{parteQuemCanta}")
    public Iterable<Musica> obterMuscisaPorQuemCanta(@PathVariable String parteQuemCanta) {
        return musicaRepository.findByquemCantaIgnoreCase(parteQuemCanta);
    }


    @GetMapping(path = "/{id}")
    public Optional<Musica> obterMusicaPorID(@PathVariable int id) {
        return musicaRepository.findById(id);
    }
}
