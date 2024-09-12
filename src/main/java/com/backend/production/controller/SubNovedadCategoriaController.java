package com.backend.production.controller;

import com.backend.production.dto.SubNovedadCategoriaRequest;
import com.backend.production.service.subnovedadcategoria.SubNovedadCategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Controlador Sub Novedad Categorias", description = "API para la gestión de Sub Novedad Categorias")
@RestController
@RequestMapping("/api/v1/sub-novedad-categoria")
public class SubNovedadCategoriaController {

    private final SubNovedadCategoriaService subNovedadCategoriaService;

    public SubNovedadCategoriaController(SubNovedadCategoriaService subNovedadCategoriaService) {
        this.subNovedadCategoriaService = subNovedadCategoriaService;
    }

    @GetMapping("/{subNovedadId}")
    public ResponseEntity<?> listarAreasPorPisoId(@PathVariable Integer subNovedadId){
        return ResponseEntity.ok(subNovedadCategoriaService.listarSubNovedadCategoriaPorSubNovedadId(subNovedadId));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SubNovedadCategoriaRequest request){
        return ResponseEntity.ok(subNovedadCategoriaService.save(request));
    }

}