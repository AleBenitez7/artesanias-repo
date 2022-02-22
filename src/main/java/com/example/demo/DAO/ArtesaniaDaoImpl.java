package com.example.demo.DAO;

import java.util.List;

import com.example.demo.model.Artesania;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArtesaniaDaoImpl implements ArtesaniaDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Artesania> getAll() {
        return jdbcTemplate.query("SELECT * FROM artesanias",new BeanPropertyRowMapper<Artesania>(Artesania.class));
    }

    @Override
    public int save(Artesania artesania) {
    return jdbcTemplate.update("INSERT INTO artesanias (tipo, nombre, color, precio) VALUES (?,?,?,?)",
        new Object[] {artesania.getTipo(), artesania.getNombre(), artesania.getColor(), artesania.getPrecio()});
    }

    @Override
    public int update(Artesania artesania, Long id) {
        return jdbcTemplate.update("UPDATE artesanias SET tipo=?, nombre=?, color=?, precio=? WHERE id=?",
        new Object[] {artesania.getTipo(), artesania.getNombre(), artesania.getColor(), artesania.getPrecio(), id});
    }

    @Override
    public Artesania getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM artesanias WHERE id=?", new BeanPropertyRowMapper<Artesania>(Artesania.class), id);
    }

    @Override
    public int delete( Artesania artesania, Long id) {
        return jdbcTemplate.update("DELETE FROM artesanias WHERE id=?", id);
    }
    
}
