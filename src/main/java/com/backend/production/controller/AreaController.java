package com.backend.production.controller;

import com.backend.production.dto.AreaRequest;
import com.backend.production.service.area.AreaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Controlador Areas", description = "API para la gestión de areas")
@RestController
@RequestMapping("/api/v1/areas")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }


    @GetMapping("/{pisoId}")
    public ResponseEntity<?> listarAreasPorPisoId(@PathVariable Integer pisoId){
        return ResponseEntity.ok(areaService.listarAreasPorPisoId(pisoId));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AreaRequest request){
        return ResponseEntity.ok(areaService.save(request));
    }

}