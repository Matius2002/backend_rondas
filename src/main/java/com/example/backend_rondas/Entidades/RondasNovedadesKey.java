package com.example.backend_rondas.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RondasNovedadesKey implements Serializable {

    @Column(name = "ronda_id")
    private Long rondaId;

    @Column(name = "novedad_id")
    private Long novedadId;

    // Constructores, getters y setters
    public RondasNovedadesKey() {}

    public RondasNovedadesKey(Long rondaId, Long novedadId) {
        this.rondaId = rondaId;
        this.novedadId = novedadId;
    }

    public Long getRondaId() {
        return rondaId;
    }

    public void setRondaId(Long rondaId) {
        this.rondaId = rondaId;
    }

    public Long getNovedadId() {
        return novedadId;
    }

    public void setNovedadId(Long novedadId) {
        this.novedadId = novedadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RondasNovedadesKey that = (RondasNovedadesKey) o;
        return Objects.equals(rondaId, that.rondaId) && Objects.equals(novedadId, that.novedadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rondaId, novedadId);
    }
}

