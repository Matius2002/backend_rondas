package com.example.backend_rondas.Servicios;

import com.example.backend_rondas.Entidades.Prioridad;
import com.example.backend_rondas.Repositorios.PrioridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrioridadService {

    @Autowired
    private PrioridadRepository prioridadRepository;

    public List<Prioridad> findAll() {
        return prioridadRepository.findAll();
    }

    public Optional<Prioridad> findById(Long id) {
        return prioridadRepository.findById(id);
    }

    public Prioridad save(Prioridad prioridad) {
        return prioridadRepository.save(prioridad);
    }

    public void deleteById(Long id) {
        prioridadRepository.deleteById(id);
    }
}
