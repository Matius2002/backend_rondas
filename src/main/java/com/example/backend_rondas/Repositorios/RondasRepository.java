package com.example.backend_rondas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend_rondas.Entidades.Rondas;

public interface RondasRepository extends JpaRepository<Rondas, Long> {
}

