package com.example.backend_rondas.Repositorios;

import com.example.backend_rondas.Entidades.RondasNovedades;
import com.example.backend_rondas.Entidades.RondasNovedadesKey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RondasNovedadesRepository extends JpaRepository<RondasNovedades, RondasNovedadesKey> {
}

