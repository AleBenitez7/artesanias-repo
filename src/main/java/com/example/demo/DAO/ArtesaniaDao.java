package com.example.demo.DAO;

import java.util.List;

import com.example.demo.model.Artesania;

public interface ArtesaniaDao {
    Artesania findByName(String nombre);
    List<Artesania>findAll();
}
