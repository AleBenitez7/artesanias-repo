package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.demo.model.Artesania;
import com.example.demo.repository.ArtesaniaRepository;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/artesanias")
public class ArtesaniasController {
    @Autowired
    private ArtesaniaRepository artesaniaRepository;
    
    @GetMapping("/artesanias")
    public List <Artesania> getAllArtesanias(){
        return artesaniaRepository.findAll();
    }

    @GetMapping("artesanias/{id}")
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
        }
}

