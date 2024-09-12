package com.backend.production.controller;

import com.backend.production.dto.SubNovedadRequest;
import com.backend.production.service.subnovedad.SubNovedadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Controlador Sub Novedades", description = "API para la gestión de Sub Novedades")
@RestController
@RequestMapping("/api/v1/sub-novedades")
public class SubNovedadController {

    private final SubNovedadService subNovedadService;

    public SubNovedadController(SubNovedadService subNovedadService) {
        this.subNovedadService = subNovedadService;
    }

    @GetMapping("/{subTipoNovedad}")
    public ResponseEntity<?> listarSubNovedadPorTipoNovedadId(@PathVariable Integer subTipoNovedad){
        return ResponseEntity.ok(subNovedadService.listarSubNovedadPorTipoNovedadId(subTipoNovedad));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SubNovedadRequest request){
        return ResponseEntity.ok(subNovedadService.save(request));
    }

}