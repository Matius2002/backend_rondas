package com.example.backend_rondas.Controlador;

import com.example.backend_rondas.Entidades.CategoriaNovedadTecnologica;
import com.example.backend_rondas.Servicios.CategoriaNovedadTecnologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias-novedad-tecnologica")
public class CategoriaNovedadTecnologicaController {

    @Autowired
    private CategoriaNovedadTecnologicaService service;

    @GetMapping
    public List<CategoriaNovedadTecnologica> getAll() {
        return service.findAll();
    }

    @PostMapping
    public CategoriaNovedadTecnologica create(@RequestBody CategoriaNovedadTecnologica categoria) {
        return service.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
