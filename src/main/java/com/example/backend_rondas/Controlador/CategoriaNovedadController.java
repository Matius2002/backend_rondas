package com.example.backend_rondas.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend_rondas.Entidades.CategoriaNovedad;
import com.example.backend_rondas.Repositorios.CategoriaNovedadRepository;
import com.example.backend_rondas.Servicios.CategoriaNovedadService;
import java.util.List;

@RestController
@RequestMapping("/api/categorias-novedad")
public class CategoriaNovedadController {

    private final CategoriaNovedadRepository categoriaNovedadRepository;

    public CategoriaNovedadController(CategoriaNovedadRepository categoriaNovedadRepository) {
        this.categoriaNovedadRepository = categoriaNovedadRepository;
    }

    @GetMapping
    public List<CategoriaNovedad> getAllCategorias() {
        return categoriaNovedadRepository.findAll();
    }
}
