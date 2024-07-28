package com.example.backend_rondas.Servicios;

import com.example.backend_rondas.Entidades.Rondas;
import com.example.backend_rondas.Repositorios.RondasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RondasService {

    @Autowired
    private RondasRepository rondasRepository;

    public List<Rondas> getAllRondas() {
        return rondasRepository.findAll();
    }

    public Optional<Rondas> getRondaById(Long id) {
        return rondasRepository.findById(id);
    }

    public Rondas createRonda(Rondas ronda) {
        return rondasRepository.save(ronda);
    }

    public Rondas updateRonda(Long id, Rondas ronda) {
        if (rondasRepository.existsById(id)) {
            ronda.setId(id);
            return rondasRepository.save(ronda);
        } else {
            return null;
        }
    }

    public boolean deleteRonda(Long id) {
        if (rondasRepository.existsById(id)) {
            rondasRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
