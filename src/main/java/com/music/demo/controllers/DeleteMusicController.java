package com.music.demo.controllers;

import com.music.demo.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeleteMusicController {

    @Autowired
    private MusicaRepository musicaRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deletarMusicaPorID(@PathVariable int id) {
        musicaRepository.deleteById(id);
    }
}
