package com.example.backend_rondas.Controlador;

import com.example.backend_rondas.Entidades.Novedades;
import com.example.backend_rondas.Servicios.NovedadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/novedades")
public class NovedadesController {

    @Autowired
    private NovedadesService novedadesService;

    @GetMapping
    public List<Novedades> getAllNovedades() {
        return novedadesService.getAllNovedades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Novedades> getNovedadById(@PathVariable Long id) {
        Optional<Novedades> novedad = novedadesService.getNovedadById(id);
        return novedad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Novedades createNovedad(@RequestBody Novedades novedad) {
        return novedadesService.createNovedad(novedad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Novedades> updateNovedad(@PathVariable Long id, @RequestBody Novedades novedad) {
        Novedades updatedNovedad = novedadesService.updateNovedad(id, novedad);
        return updatedNovedad != null ? ResponseEntity.ok(updatedNovedad) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNovedad(@PathVariable Long id) {
        return novedadesService.deleteNovedad(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
