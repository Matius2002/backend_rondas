package com.example.backend_rondas.Servicios;

import com.example.backend_rondas.Entidades.ElementosNovedadTecnologica;
import com.example.backend_rondas.Repositorios.ElementosNovedadTecnologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementosNovedadTecnologicaService {

    @Autowired
    private ElementosNovedadTecnologicaRepository repository;

    public List<ElementosNovedadTecnologica> findAll() {
        return repository.findAll();
    }

    public ElementosNovedadTecnologica save(ElementosNovedadTecnologica elemento) {
        return repository.save(elemento);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
