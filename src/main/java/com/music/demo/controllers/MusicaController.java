package com.music.demo.controllers;

import com.music.demo.model.Musica;
import com.music.demo.model.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Musica salvarMusica (@Validated
                                            @RequestParam String nomeDaMusica,
                                            @RequestParam String versao,
                                            @RequestParam String quemCanta,
                                            @RequestParam String tom){
        Musica musica = new Musica(nomeDaMusica, versao, quemCanta, tom);
        musicaRepository.save(musica);
        return musica;

    }

    @GetMapping
    public Iterable<Musica> obterMusica(){
        return musicaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Musica> obterMusicaPorID(@PathVariable int id){
        return musicaRepository.findById(id);
    }

    @DeleteMapping(path= "/{id}")
    public void deletarMusicaPorID (@PathVariable int id){
        musicaRepository.deleteById(id);
    }







}
