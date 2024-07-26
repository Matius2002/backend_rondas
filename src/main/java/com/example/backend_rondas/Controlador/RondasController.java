package com.example.backend_rondas.Controlador;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_rondas.Entidades.Novedades;
import com.example.backend_rondas.Entidades.Rondas;
import com.example.backend_rondas.Entidades.RondasNovedades;
import com.example.backend_rondas.Entidades.RondasNovedadesKey;
import com.example.backend_rondas.Repositorios.NovedadesRepository;
import com.example.backend_rondas.Repositorios.RondasNovedadesRepository;
import com.example.backend_rondas.Repositorios.RondasRepository;

@RestController
@RequestMapping("/rondas")
public class RondasController {

    @Autowired
    private RondasRepository rondasRepository;

    @Autowired
    private NovedadesRepository novedadesRepository;

    @Autowired
    private RondasNovedadesRepository rondasNovedadesRepository;

    // Otros métodos

    @PostMapping("/{rondaId}/novedades/{novedadId}")
    public ResponseEntity<RondasNovedades> addNovedadToRonda(@PathVariable Long rondaId, @PathVariable Long novedadId) {
        Optional<Rondas> ronda = rondasRepository.findById(rondaId);
        Optional<Novedades> novedad = novedadesRepository.findById(novedadId);

        if (ronda.isPresent() && novedad.isPresent()) {
            RondasNovedades rondasNovedades = new RondasNovedades(ronda.get(), novedad.get());
            rondasNovedadesRepository.save(rondasNovedades);
            return ResponseEntity.ok(rondasNovedades);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{rondaId}/novedades/{novedadId}")
    public ResponseEntity<Void> removeNovedadFromRonda(@PathVariable Long rondaId, @PathVariable Long novedadId) {
        RondasNovedadesKey key = new RondasNovedadesKey(rondaId, novedadId);
        if (rondasNovedadesRepository.existsById(key)) {
            rondasNovedadesRepository.deleteById(key);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

