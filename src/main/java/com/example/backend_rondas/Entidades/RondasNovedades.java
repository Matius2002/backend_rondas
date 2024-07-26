package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RondasNovedades")
public class RondasNovedades implements Serializable {

    @EmbeddedId
    private RondasNovedadesKey id;

    @ManyToOne
    @MapsId("rondaId")
    @JoinColumn(name = "ronda_id")
    private Rondas ronda;

    @ManyToOne
    @MapsId("novedadId")
    @JoinColumn(name = "novedad_id")
    private Novedades novedad;

    // Constructores, getters y setters
    public RondasNovedades() {}

    public RondasNovedades(Rondas ronda, Novedades novedad) {
        this.ronda = ronda;
        this.novedad = novedad;
        this.id = new RondasNovedadesKey(ronda.getId(), novedad.getId());
    }

    public RondasNovedadesKey getId() {
        return id;
    }

    public void setId(RondasNovedadesKey id) {
        this.id = id;
    }

    public Rondas getRonda() {
        return ronda;
    }

    public void setRonda(Rondas ronda) {
        this.ronda = ronda;
    }

    public Novedades getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedades novedad) {
        this.novedad = novedad;
    }
}
