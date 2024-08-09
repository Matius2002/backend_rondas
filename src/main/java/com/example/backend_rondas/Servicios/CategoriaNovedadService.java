package com.example.backend_rondas.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend_rondas.Entidades.CategoriaNovedad;
import com.example.backend_rondas.Repositorios.CategoriaNovedadRepository;
import java.util.List;

@Service
public class CategoriaNovedadService {

    @Autowired
    private CategoriaNovedadRepository categoriaNovedadRepository;

    public List<CategoriaNovedad> findAll() {
        return categoriaNovedadRepository.findAll();
    }
    
}
