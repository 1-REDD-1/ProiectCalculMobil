package com.proiectserver.serverrest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proiectserver.serverrest.entities.Notita;

@Repository
public interface NotiteRepository extends JpaRepository<Notita, Long>{
    List<Notita> findByAutor (String autor);
}