package com.example.backend_rondas.Controlador;

import com.example.backend_rondas.Entidades.Prioridad;
import com.example.backend_rondas.Servicios.PrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prioridades")
public class PrioridadController {

    @Autowired
    private PrioridadService prioridadService;

    @GetMapping
    public List<Prioridad> getAllPrioridades() {
        return prioridadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prioridad> getPrioridadById(@PathVariable Long id) {
        Optional<Prioridad> prioridad = prioridadService.findById(id);
        if (prioridad.isPresent()) {
            return ResponseEntity.ok(prioridad.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Prioridad createPrioridad(@RequestBody Prioridad prioridad) {
        return prioridadService.save(prioridad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prioridad> updatePrioridad(@PathVariable Long id, @RequestBody Prioridad prioridadDetails) {
        Optional<Prioridad> prioridad = prioridadService.findById(id);
        if (prioridad.isPresent()) {
            Prioridad updatedPrioridad = prioridad.get();
            updatedPrioridad.setNombre(prioridadDetails.getNombre());
            return ResponseEntity.ok(prioridadService.save(updatedPrioridad));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrioridad(@PathVariable Long id) {
        if (prioridadService.findById(id).isPresent()) {
            prioridadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
