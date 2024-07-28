package com.example.backend_rondas.Servicios;

import com.example.backend_rondas.Entidades.Novedades;
import com.example.backend_rondas.Repositorios.NovedadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovedadesService {

    @Autowired
    private NovedadesRepository novedadesRepository;

    public List<Novedades> getAllNovedades() {
        return novedadesRepository.findAll();
    }

    public Optional<Novedades> getNovedadById(Long id) {
        return novedadesRepository.findById(id);
    }

    public Novedades createNovedad(Novedades novedad) {
        return novedadesRepository.save(novedad);
    }

    public Novedades updateNovedad(Long id, Novedades novedad) {
        if (novedadesRepository.existsById(id)) {
            novedad.setId(id);
            return novedadesRepository.save(novedad);
        } else {
            return null;
        }
    }

    public boolean deleteNovedad(Long id) {
        if (novedadesRepository.existsById(id)) {
            novedadesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
