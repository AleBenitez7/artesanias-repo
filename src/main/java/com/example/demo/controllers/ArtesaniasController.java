package com.example.demo.controllers;

import java.util.List;


import com.example.demo.DAO.ArtesaniaDao;
import com.example.demo.exception.ArtesaniaNotfoundException;
import com.example.demo.model.Artesania;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")


@RestController
public class ArtesaniasController {

    @Autowired
    private ArtesaniaDao aDAO;
    @GetMapping("/artesanias")
    public ResponseEntity<List <Artesania>> getArtesanias(@RequestHeader HttpHeaders headers){
      List<Artesania> getAll = aDAO.getAll();
      if(getAll==null| getAll.isEmpty()) throw new ArtesaniaNotfoundException();
      return new ResponseEntity<>(getAll, HttpStatus.OK);
    }
    /*@GetMapping("/artesanias/{id}")
    public ResponseEntity<Object> getArtesaniaById(@PathVariable Long id) {
      Artesania artesania = aDAO.getById(id);
      if(artesania==null)throw new ArtesaniaNotfoundException();
      aDAO.getById(id);
      return new ResponseEntity<>("FOUND", HttpStatus.OK);
    }*/
    @GetMapping("/artesanias/{id}")
    public ResponseEntity<Artesania> getArtesaniaById(@PathVariable Long id) {
      Artesania artesania = aDAO.getById(id);
      if(artesania==null)throw new ArtesaniaNotfoundException();
      return new ResponseEntity<>(artesania, HttpStatus.OK);
    }

    @PostMapping("/artesanias")
    public ResponseEntity<Artesania> createArtesania(@RequestBody Artesania artesania) {

      if(artesania.getNombre()=="") throw new ArtesaniaNotfoundException();
        aDAO.save(artesania);
        return new ResponseEntity<>(artesania, HttpStatus.CREATED);
      //return aDAO.save(artesania)+" No. of rows saved in the database";
      
    }

    @PutMapping("/artesanias/{id}")
    public ResponseEntity<Object> updateArtesania(@PathVariable long id, @RequestBody Artesania artesania) {
      if(id<=0 )throw new ArtesaniaNotfoundException();
      aDAO.update(artesania, id);
      return new ResponseEntity<>("Artesania is updated succesfully", HttpStatus.OK);
  }
  /*@PutMapping("/artesanias/{id}")
  public ResponseEntity<Artesania> updateArtesania(@PathVariable long id, @RequestBody Artesania artesania) {
    try {
      this.aDAO.update(artesania, id);
      return ResponseEntity.ok().body(artesania);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }*/
  
  @DeleteMapping("/artesanias/{id}")
  public ResponseEntity<Object> deleteArtesania(@PathVariable Long id) {
    Artesania artesania = aDAO.getById(id);
    if(artesania==null) throw new ArtesaniaNotfoundException();
    aDAO.delete(id); 
    return new ResponseEntity<>("Artesania is deleted succesfully", HttpStatus.OK);
  }
}


