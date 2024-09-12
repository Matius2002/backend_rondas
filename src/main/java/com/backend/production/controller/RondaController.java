package com.backend.production.controller;

import com.backend.production.dto.RondaRequest;
import com.backend.production.service.ronda.RondaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Controlador Rondas", description = "API para la gestión de rondas")
@RestController
@RequestMapping("/api/v1/rondas")
public class RondaController {

    private final RondaService rondaService;

    public RondaController(RondaService rondaService) {
        this.rondaService = rondaService;
    }

    @GetMapping
    public ResponseEntity<?> listarRondas(){
        return ResponseEntity.ok(rondaService.listarRondas());
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody RondaRequest request){
        return ResponseEntity.ok(rondaService.save(request));
    }

    @PutMapping("/{rondadId}")
    public ResponseEntity<String> update(@RequestBody RondaRequest request, @PathVariable Integer rondadId){
        return ResponseEntity.ok(rondaService.update(request, rondadId));
    }

    @DeleteMapping("/{rondaId}")
    public ResponseEntity<String> save(@PathVariable Integer rondaId){
        return ResponseEntity.ok(rondaService.delete(rondaId));
    }

}