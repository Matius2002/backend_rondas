package com.backend.production.controller;

import com.backend.production.dto.PisoRequest;
import com.backend.production.service.piso.PisoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Controlador Pisos", description = "API para la gestión de pisos")
@RestController
@RequestMapping("/api/v1/pisos")
public class PisoController {

    private final PisoService pisoService;

    public PisoController(PisoService pisoService) {
        this.pisoService = pisoService;
    }

    @GetMapping("/{torreId}")
    public ResponseEntity<?> listarPisosPorTorreId(@PathVariable Integer torreId){
        return ResponseEntity.ok(pisoService.listarPisosPorTorreId(torreId));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PisoRequest request){
        return ResponseEntity.ok(pisoService.save(request));
    }

}