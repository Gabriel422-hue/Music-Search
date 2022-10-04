package com.music.demo.controllers;

import com.music.demo.model.Musica;
import com.music.demo.model.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @GetMapping(path ="/pagina/{numeroPagina}/{qtdePagina}")
    public Iterable<Musica> obterMusicaPorPagina
            (@PathVariable int numeroPagina,
             @PathVariable int qtdePagina){
        if (qtdePagina >=5 ) qtdePagina = 5;
        Pageable page = PageRequest.of(numeroPagina, qtdePagina);
        return musicaRepository.findAll(page);
    }
    @GetMapping
    public Iterable<Musica> obterMusica(){
        return musicaRepository.findAll();
    }
    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Musica> obterMusicasPorNome(@PathVariable String parteNome){
        return musicaRepository.findByNomeDaMusicaContainingIgnoreCase(parteNome);
    }

    @GetMapping(path = "/tom/{parteTom}")
    public Iterable<Musica> obterMusicaPorTom(@PathVariable String parteTom){
        return musicaRepository.findBytomContainingIgnoreCase(parteTom);
    }

    @GetMapping(path = "/quemCanta/{parteQuemCanta}")
    public Iterable<Musica> obterMuscisaPorQuemCanta(@PathVariable String parteQuemCanta){
        return musicaRepository.findByquemCantaIgnoreCase(parteQuemCanta);
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
