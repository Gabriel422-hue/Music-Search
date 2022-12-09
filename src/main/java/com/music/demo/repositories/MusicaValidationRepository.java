package com.music.demo.repositories;


import com.music.demo.model.Musica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public interface MusicaValidationRepository extends JpaRepository<Musica, UUID> {
    boolean existsMusic(String Music);
}
