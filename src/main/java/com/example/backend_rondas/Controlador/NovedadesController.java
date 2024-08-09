package com.example.backend_rondas.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_rondas.Entidades.Novedades;
import com.example.backend_rondas.Repositorios.NovedadesRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/novedades")
public class NovedadesController {

    @Autowired
    private NovedadesRepository novedadesRepository;

    // Obtener todas las novedades
    @GetMapping
    public List<Novedades> getAllNovedades() {
        return novedadesRepository.findAll();
    }

    // Obtener una novedad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Novedades> getNovedadById(@PathVariable Long id) {
        Optional<Novedades> novedad = novedadesRepository.findById(id);
        if (novedad.isPresent()) {
            return ResponseEntity.ok(novedad.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva novedad
    @PostMapping
    public Novedades createNovedad(@RequestBody Novedades novedad) {
        novedad.setCreatedAt(LocalDateTime.now());
        return novedadesRepository.save(novedad);
    }

    // Actualizar una novedad existente
    @PutMapping("/{id}")
    public ResponseEntity<Novedades> updateNovedad(@PathVariable Long id, @RequestBody Novedades novedadDetails) {
        Optional<Novedades> novedadOptional = novedadesRepository.findById(id);
        if (novedadOptional.isPresent()) {
            Novedades novedad = novedadOptional.get();
            
            // Actualiza los campos necesarios
            novedad.setCategoriaNovedad(novedadDetails.getCategoriaNovedad()); // Aquí se actualiza la categoría de la novedad
            novedad.setPrioridad(novedadDetails.getPrioridad());
            novedad.setDescripcion(novedadDetails.getDescripcion());
            novedad.setNovedadResuelta(novedadDetails.getNovedadResuelta());
            novedad.setImagenes(novedadDetails.getImagenes());
            novedad.setUpdatedAt(LocalDateTime.now());

            // Guarda los cambios
            return ResponseEntity.ok(novedadesRepository.save(novedad));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una novedad por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNovedad(@PathVariable Long id) {
        Optional<Novedades> novedadOptional = novedadesRepository.findById(id);
        if (novedadOptional.isPresent()) {
            novedadesRepository.delete(novedadOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}