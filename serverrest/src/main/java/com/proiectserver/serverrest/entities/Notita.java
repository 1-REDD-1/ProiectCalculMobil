package com.proiectserver.serverrest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notite")
public class Notita {
    private long id;
    private String continut;
    private String titlu;
    private String autor;

    public Notita () {

    }

    public Notita (String titlu, String continut, String autor) {
        this.titlu = titlu;
        this.continut = continut;
        this.autor = autor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId () {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "continut", nullable = false)
    public String getContinut () {
        return this.continut;
    }

    public void setContinut (String continut) {
        this.continut = continut;
    }

    @Column(name = "titlu", nullable = false)
    public String getTitlu () {
        return this.titlu;
    }

    public void setTitlu (String titlu) {
        this.titlu = titlu;
    }

    @Column(name = "autor", nullable = false)
    public String getAutor () {
        return this.autor;
    }
    public void setAutor (String autor) {
        this.autor = autor;
    }
}
