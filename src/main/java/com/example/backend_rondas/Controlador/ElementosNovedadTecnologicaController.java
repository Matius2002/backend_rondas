package com.example.backend_rondas.Controlador;

import com.example.backend_rondas.Entidades.ElementosNovedadTecnologica;
import com.example.backend_rondas.Servicios.ElementosNovedadTecnologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elementos-novedad-tecnologica")
public class ElementosNovedadTecnologicaController {

    @Autowired
    private ElementosNovedadTecnologicaService service;

    @GetMapping
    public List<ElementosNovedadTecnologica> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ElementosNovedadTecnologica create(@RequestBody ElementosNovedadTecnologica elemento) {
        return service.save(elemento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
