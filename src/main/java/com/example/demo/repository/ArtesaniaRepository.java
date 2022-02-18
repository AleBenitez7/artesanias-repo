package com.example.demo.repository;
import com.example.demo.model.Artesania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtesaniaRepository extends JpaRepository<Artesania, Long>{
    
}
