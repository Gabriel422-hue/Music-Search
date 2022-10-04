package com.music.demo.model.repositories;

import com.music.demo.model.Musica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface MusicaRepository extends PagingAndSortingRepository<Musica, Integer> {

    public Iterable<Musica> findByNomeDaMusicaContainingIgnoreCase(String parteNome);

    public Iterable<Musica> findBytomContainingIgnoreCase(String parteTom);

    public Iterable<Musica> findByquemCantaIgnoreCase(String parteQuemCanta);

}


