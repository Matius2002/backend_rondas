/*package com.example.backend_rondas.Controlador;

import com.example.backend_rondas.Entidades.Rondas;
import com.example.backend_rondas.Servicios.RondasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rondas")
public class RondasController {

    @Autowired
    private RondasService rondasService;

    @GetMapping
    public List<Rondas> getAllRondas() {
        return rondasService.getAllRondas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rondas> getRondaById(@PathVariable Long id) {
        Optional<Rondas> ronda = rondasService.getRondaById(id);
        return ronda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rondas createRonda(@RequestBody Rondas ronda) {
        return rondasService.createRonda(ronda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rondas> updateRonda(@PathVariable Long id, @RequestBody Rondas ronda) {
        Rondas updatedRonda = rondasService.updateRonda(id, ronda);
        return updatedRonda != null ? ResponseEntity.ok(updatedRonda) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRonda(@PathVariable Long id) {
        return rondasService.deleteRonda(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}*/
package com.example.backend_rondas.Controlador;

import com.example.backend_rondas.Entidades.Rondas;
import com.example.backend_rondas.Repositorios.RondasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rondas")
public class RondasController {

    @Autowired
    private RondasRepository rondasRepository;

    @GetMapping
    public List<Rondas> getAllRondas() {
        return rondasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rondas> getRondaById(@PathVariable Long id) {
        Optional<Rondas> ronda = rondasRepository.findById(id);
        if (ronda.isPresent()) {
            return ResponseEntity.ok(ronda.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Rondas createRonda(@RequestBody Rondas ronda) {
        ronda.setCreatedAt(LocalDateTime.now());
        return rondasRepository.save(ronda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rondas> updateRonda(@PathVariable Long id, @RequestBody Rondas rondaDetails) {
        Optional<Rondas> rondaOptional = rondasRepository.findById(id);
        if (rondaOptional.isPresent()) {
            Rondas ronda = rondaOptional.get();
            ronda.setTorre(rondaDetails.getTorre());
            ronda.setPiso(rondaDetails.getPiso());
            ronda.setArea(rondaDetails.getArea());
            ronda.setTecnicoResponsable(rondaDetails.getTecnicoResponsable());
            ronda.setUpdatedAt(LocalDateTime.now());
            return ResponseEntity.ok(rondasRepository.save(ronda));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRonda(@PathVariable Long id) {
        Optional<Rondas> rondaOptional = rondasRepository.findById(id);
        if (rondaOptional.isPresent()) {
            rondasRepository.delete(rondaOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

