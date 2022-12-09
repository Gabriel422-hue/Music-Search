package com.music.demo.service;

import com.music.demo.model.Musica;
import com.music.demo.repositories.MusicaValidationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class MusicService {

    static MusicaValidationRepository musicaValidationRepository


    public MusicService(MusicaValidationRepository musicaValidationRepository){
        this.
    }

    @Transactional
    public Musica save(Musica musica){
        return
    }

    public boolean existsMusic (String Music){
        return
    }

}
