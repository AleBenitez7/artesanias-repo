package com.example.demo.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.demo.DAO.ArtesaniaDao;
import com.example.demo.exceptions.APIException;
import com.example.demo.exceptions.APIException.Code;
import com.example.demo.model.Artesania;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArtesaniasController {

    @Autowired
    private ArtesaniaDao aDAO;
    @GetMapping("/artesanias")
    public List <Artesania> getArtesanias(@RequestHeader HttpHeaders headers){
        return aDAO.getAll();
    }

    @GetMapping("/artesanias/{id}")
    public ResponseEntity<?> getArtesaniaById(@PathVariable Long id) {
      aDAO.getById(id);
      return ResponseEntity.ok(aDAO.getById(id));
    }
    @PostMapping("/artesanias")
    public String createArtesania(@RequestBody Artesania artesania) {
      return aDAO.save(artesania)+" No. of rows saved in the database";
    }

  @PutMapping("/artesanias/{id}")
  public String updateArtesania(@PathVariable long id, @RequestBody Artesania artesania) {
      return aDAO.update(artesania, id)+" No of rows updated in the databse";
  }

  @DeleteMapping("/artesanias/{id}")
  public String deleteArtesania(@PathVariable long id) {
    return aDAO.delete(null, id)+ " No. of rows deleted in the database";
  
  }
   
/*
  @GetMapping("/artesanias")
    public List <Artesania> getAllArtesanias(){
        return aDAO.getAll();
    }

    @GetMapping("/artesanias/{id}")
    public ResponseEntity<Artesania> getArtesaniaById(@PathVariable(value ="id")Long artesaniaId)
    throws APIException {
        Artesania artesania = aDAO.getById(artesaniaId)
        .orElseThrow(()-> new ResourceNotFoundException("Artesania not found for this id:: "+ artesaniaId));
        String valor ="art002";
        Code myCode= Code.fromString(valor);
        return ResponseEntity.ok().body(artesania);
    }

    @PostMapping("/artesanias")
    public  int crateArtesania(@Valid @RequestBody Artesania artesania) {
        return aDAO.save(artesania);
    }

    @PutMapping("/artesanias/{id}")
    public ResponseEntity<Integer> updateArtesania (@PathVariable(value = "id") Long artesaniaId,
         @Valid @RequestBody Artesania artesaniaDetails) throws  ArtesaniaNotfoundException {
        Artesania artesania = aDAO.getById(artesaniaId)
        .orElseThrow(() -> new ArtesaniaNotfoundException("Artesania not found for this id :: " + artesaniaId));

        artesania.setTipo(artesaniaDetails.getTipo());
        artesania.setNombre(artesaniaDetails.getNombre());
        artesania.setColor(artesaniaDetails.getColor());
        final int updatedArtesania = aDAO.save(artesania);
        return ResponseEntity.ok(updatedArtesania);
    }

    @DeleteMapping("/artesanias/{id}")
    public Map<String, Boolean> deleteArtesania(@PathVariable(value = "id") Long id)
         throws ResourceNotFoundException {
        Artesania artesania = aDAO.getById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Artesania not found for this id :: " + artesaniaId));

        aDAO.delete(artesania, id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }
        */
}


