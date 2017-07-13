package com.example.repository.autore;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.autore.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Integer> {
}
