package com.example.backend_rondas.Servicios;

import com.example.backend_rondas.Entidades.CategoriaNovedadTecnologica;
import com.example.backend_rondas.Repositorios.CategoriaNovedadTecnologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaNovedadTecnologicaService {

    @Autowired
    private CategoriaNovedadTecnologicaRepository repository;

    public List<CategoriaNovedadTecnologica> findAll() {
        return repository.findAll();
    }

    public CategoriaNovedadTecnologica save(CategoriaNovedadTecnologica categoria) {
        return repository.save(categoria);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

