package com.backend.production.controller;

import com.backend.production.dto.NovedadRequest;
import com.backend.production.service.novedad.NovedadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "Controlador Novedades", description = "Controlador expone endpoint para la gestión de novedades")
@RestController
@RequestMapping("/api/v1/novedades")
public class NovedadController {
    private final NovedadService novedadService;

    public NovedadController(NovedadService novedadService) {
        this.novedadService = novedadService;
    }

    @GetMapping("/{rondaId}")
    public ResponseEntity<?> buscarPorRondaId(@PathVariable Integer rondaId){
        return ResponseEntity.ok(novedadService.buscarPorRondaId(rondaId));
    }

    @GetMapping
    public ResponseEntity<?> buscarRondaAbiertas(){
        return ResponseEntity.ok(novedadService.buscarRondaAbiertas());
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody NovedadRequest request) throws IOException {
        return ResponseEntity.ok(novedadService.save(request));
    }

    @PutMapping("/{novedadId}")
    public ResponseEntity<String> update(@RequestBody NovedadRequest request, @PathVariable Integer novedadId){
        return ResponseEntity.ok(novedadService.update(request, novedadId));
    }

    @DeleteMapping("/{novedadId}")
    public ResponseEntity<String> save(@PathVariable Integer novedadId){
        return ResponseEntity.ok(novedadService.delete(novedadId));
    }
}