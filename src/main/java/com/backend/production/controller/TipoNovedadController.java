package com.backend.production.controller;

import com.backend.production.service.tiponovedad.TipoNovedadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Controlador Tipos Novedades", description = "API para la gestión de Tipos Novedades")
@RestController
@RequestMapping("/api/v1/tipo-novedades")
public class TipoNovedadController {

    private final TipoNovedadService tipoNovedadService;

    public TipoNovedadController(TipoNovedadService tipoNovedadService) {
        this.tipoNovedadService = tipoNovedadService;
    }

    @GetMapping()
    public ResponseEntity<?> listarTipoNovedad(){
        return ResponseEntity.ok(tipoNovedadService.listarTipoNovedades());
    }

}