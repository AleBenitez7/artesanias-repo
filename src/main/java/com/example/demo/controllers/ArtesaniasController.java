package com.example.demo.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.demo.model.Artesania;
import com.example.demo.repository.ArtesaniaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
public class ArtesaniasController {

    @Autowired
    private ArtesaniaRepository artesaniaRepository;
     @GetMapping("/artesanias")
    public List <Artesania> getAllArtesanias(){
        return artesaniaRepository.findAll();
    }

    @GetMapping("/artesanias/{id}")
    public ResponseEntity<Artesania> getArtesaniaById(@PathVariable("id") Long id) {
      Artesania artesania = artesaniaRepository.findById(id);
  
      if (artesania != null) {
        return new ResponseEntity<>(artesania, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
  
    @PostMapping("/artesanias")
    public ResponseEntity<String> createArtesania(@RequestBody Artesania artesania) {
      try {
        artesaniaRepository.save(new Artesania(artesania.getTipo(), artesania.getNombre(), artesania.getColor(), artesania.getPrecio()));
        return new ResponseEntity<>("Artesania was created successfully.", HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

  @PutMapping("/artesanias/{id}")
  public ResponseEntity<String> updateArtesania(@PathVariable("id") long id, @RequestBody Artesania artesania) {
    Artesania _artesania = artesaniaRepository.findById(id);

    if (_artesania != null) {
        _artesania.setId(id);
        _artesania.setTipo(artesania.getTipo());
        _artesania.setNombre(artesania.getNombre());
        _artesania.setColor(artesania.getColor());
        _artesania.setPrecio(artesania.getPrecio());

      artesaniaRepository.update(_artesania);
      return new ResponseEntity<>("Artesania was updated successfully.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Cannot find Artesania with id=" + id, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/artesanias/{id}")
  public ResponseEntity<String> deleteArtesania(@PathVariable("id") long id) {
    try {
      int result = artesaniaRepository.deleteById(id);
      if (result == 0) {
        return new ResponseEntity<>("Cannot find Artesania with id=" + id, HttpStatus.OK);
      }
      return new ResponseEntity<>("Artesania was deleted successfully.", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Cannot delete Artesania.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
    /*@GetMapping("/artesanias")
    public List <Artesania> getAllArtesanias(){
        return artesaniaRepository.findAll();
    }

    @GetMapping("/artesanias/{id}")
    public ResponseEntity<Artesania> getArtesaniaById(@PathVariable(value ="id")Long artesaniaId)
    throws ResourceNotFoundException {
        Artesania artesania = artesaniaRepository.findById(artesaniaId)
        .orElseThrow(()-> new ResourceNotFoundException("Artesania not found for this id:: "+ artesaniaId));
        return ResponseEntity.ok().body(artesania);
    }

    @PostMapping("/artesanias")
    public  Artesania crateArtesania(@Valid @RequestBody Artesania artesania) {
        return artesaniaRepository.save(artesania);
    }

    @PutMapping("/artesanias/{id}")
    public ResponseEntity<Artesania> updateArtesania (@PathVariable(value = "id") Long artesaniaId,
         @Valid @RequestBody Artesania artesaniaDetails) throws ResourceNotFoundException {
        Artesania artesania = artesaniaRepository.findById(artesaniaId)
        .orElseThrow(() -> new ResourceNotFoundException("Artesania not found for this id :: " + artesaniaId));

        artesania.setTipo(artesaniaDetails.getTipo());
        artesania.setNombre(artesaniaDetails.getNombre());
        artesania.setColor(artesaniaDetails.getColor());
        final Artesania updatedArtesania = artesaniaRepository.save(artesania);
        return ResponseEntity.ok(updatedArtesania);
    }

    @DeleteMapping("/artesanias/{id}")
    public Map<String, Boolean> deleteArtesania(@PathVariable(value = "id") Long artesaniaId)
         throws ResourceNotFoundException {
        Artesania artesania = artesaniaRepository.findById(artesaniaId)
       .orElseThrow(() -> new ResourceNotFoundException("Artesania not found for this id :: " + artesaniaId));

        artesaniaRepository.delete(artesania);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }*/
}


