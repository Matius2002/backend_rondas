package com.backend.production.repository;

import com.backend.production.models.Ronda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RondaRepository extends JpaRepository<Ronda, Integer> {
    @Query(value = "SELECT rondas.id, torres.name as torre, pisos.name as piso, areas.name as area, rondas.tecnico_responsable, rondas.created_at, rondas.updated_at " +
            "FROM rondas " +
            "JOIN torres ON torres.id = rondas.torre " +
            "JOIN pisos ON pisos.id = rondas.piso " +
            "JOIN areas ON areas.id = rondas.area " +
            "ORDER BY rondas.id DESC", nativeQuery = true)
    List<Map<String , Object>> findRondasWithDetails();
}