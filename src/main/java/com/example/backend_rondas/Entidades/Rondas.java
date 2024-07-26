package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Rondas")
public class Rondas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "tecnico_responsable", nullable = false)
    private String tecnico_responsable;

    @Column(name = "created_at", nullable = false)
    private String created_at;

    @Column(name = "updated_at", nullable = false)
    private String updated_at;

    @OneToMany(mappedBy = "ronda", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RondasNovedades> rondasNovedades = new HashSet<>();

    public Rondas() {}

    public Rondas(String fecha, String tecnico_responsable, String created_at, String updated_at) {
        this.fecha = fecha;
        this.tecnico_responsable = tecnico_responsable;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTecnico_responsable() {
        return tecnico_responsable;
    }

    public void setTecnico_responsable(String tecnico_responsable) {
        this.tecnico_responsable = tecnico_responsable;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Set<RondasNovedades> getRondasNovedades() {
        return rondasNovedades;
    }

    public void setRondasNovedades(Set<RondasNovedades> rondasNovedades) {
        this.rondasNovedades = rondasNovedades;
    }

    @Override
    public String toString() {
        return "Rondas{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", tecnico_responsable='" + tecnico_responsable + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
