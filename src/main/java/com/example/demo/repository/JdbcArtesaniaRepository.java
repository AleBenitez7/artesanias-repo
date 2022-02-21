package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.model.Artesania;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcArtesaniaRepository implements ArtesaniaRepository{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Artesania a) {
    return jdbcTemplate.update("INSERT INTO artesanias (tipo, nombre, color, precio) VALUES(?,?,?,?)",
        new Object[] { a.getTipo(), a.getNombre(), a.getColor(), a.getPrecio() });
    }
    @Override
    public int update(Artesania artesania) {
        return jdbcTemplate.update("UPDATE artesanias SET tipo=?, nombre=?, color=?, precio=? WHERE id=?", 
        new Object[] {artesania.getTipo(), artesania.getNombre(), artesania.getColor(), artesania.getPrecio(), artesania.getId() });
    }

    @Override
    public Artesania findById(Long id) {
        try{
            Artesania artesania = jdbcTemplate.queryForObject("SELECT * FROM artesanias WHERE id=?", 
            BeanPropertyRowMapper.newInstance(Artesania.class), id);
            return artesania;
        }catch(IncorrectResultSizeDataAccessException e){
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM artesanias WHERE id=?", id);
    }

    @Override
    public List<Artesania> findAll() {
        return jdbcTemplate.query("SELECT * from artesanias", BeanPropertyRowMapper.newInstance(Artesania.class));
    }

}
