package com.example.demo.DAO;

import java.util.List;

import com.example.demo.model.Artesania;

public interface ArtesaniaDao {
    int save(Artesania artesania);
    int update (Artesania artesania, Long id);
    int delete(Artesania artesania,Long id);
    Artesania getById(Long id);
    List<Artesania>getAll();
}
