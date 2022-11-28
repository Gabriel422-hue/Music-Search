package com.music.demo.controllers;

import com.music.demo.model.Musica;
import com.music.demo.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/musicas")
public class PostMusicController {

    @Autowired
    private MusicaRepository musicaRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Musica salvarMusica(@Validated
                                             @RequestParam String nomeDaMusica,
                                             @RequestParam String versao,
                                             @RequestParam String quemCanta,
                                             @RequestParam String tom) {
        Musica musica = new Musica(nomeDaMusica, versao, quemCanta, tom);
        musicaRepository.save(musica);
        return musica;

    }






}
