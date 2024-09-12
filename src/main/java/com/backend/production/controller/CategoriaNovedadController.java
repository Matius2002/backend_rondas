package com.backend.production.controller;

import com.backend.production.dto.CategoriaNovedadRequest;
import com.backend.production.dto.NovedadRequest;
import com.backend.production.service.categoriaNovedad.categoriaNovedadService;
import io.jsonwebtoken.io.IOException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Controlador Categoria Novedades", description = "Controlador expone las categorais que estan en las Novedades")
@RestController
@RequestMapping("api/v1/categorianovedades")
public class CategoriaNovedadController {
    private final categoriaNovedadService categoriaNovedadService;

    public CategoriaNovedadController(categoriaNovedadService categoriaNovedadSerivce) {
        this.categoriaNovedadService = categoriaNovedadSerivce;
    }


    @GetMapping("/{novedadId}")
    public ResponseEntity<?> ListarCategoriaNovedad(@PathVariable Integer novedadId){
        return ResponseEntity.ok(categoriaNovedadService.ListarCategoriaNovedad(novedadId));
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody CategoriaNovedadRequest request) throws IOException{
        return ResponseEntity.ok(categoriaNovedadService.save(request));
    }

    @PutMapping("/{CNId}")
    public ResponseEntity<String> update(@RequestBody CategoriaNovedadRequest request, @PathVariable Integer CNId){
        return ResponseEntity.ok(categoriaNovedadService.update(request, CNId));
    }
}
