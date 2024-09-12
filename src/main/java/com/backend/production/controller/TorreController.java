package com.backend.production.controller;

import com.backend.production.dto.TorreRequest;
import com.backend.production.service.torre.TorreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Controlador Torres", description = "API para la gestión de torres")
@RestController
@RequestMapping("/api/v1/torres")
public class TorreController {

    private final TorreService torreService;

    public TorreController(TorreService torreService) {
        this.torreService = torreService;
    }


    @GetMapping()
    public ResponseEntity<?> listarTorres(){
        return ResponseEntity.ok(torreService.listarTorres());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TorreRequest request){
        return ResponseEntity.ok(torreService.save(request));
    }
}