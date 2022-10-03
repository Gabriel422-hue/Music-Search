package com.music.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeDaMusica;

    private String versao;

    private String quemCanta;

    private String tom;

    public Musica() {

    }

    public Musica(String nomeDaMusica, String versao, String quemCanta, String tom) {
        super();
        this.nomeDaMusica = nomeDaMusica;
        this.versao = versao;
        this.quemCanta = quemCanta;
        this.tom = tom;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDaMusica() {
        return nomeDaMusica;
    }

    public void setNomeDaMusica(String nomeDaMusica) {
        this.nomeDaMusica = nomeDaMusica;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getQuemCanta() {
        return quemCanta;
    }

    public void setQuemCanta(String quemCanta) {
        this.quemCanta = quemCanta;
    }

    public String getTom() {
        return tom;
    }

    public void setTom(String tom) {
        this.tom = tom;
    }
}
