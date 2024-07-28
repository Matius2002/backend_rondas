package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rondas")
public class Rondas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoria_ronda", nullable = false)
    private String categoriaRonda;

    @Column(name = "detalle", nullable = false)
    private String detalle;

    @Column(name = "prioridad", nullable = false)
    private String prioridad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relación con la entidad Novedades
    @OneToMany(mappedBy = "ronda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Novedades> novedades;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoriaRonda() {
        return categoriaRonda;
    }

    public void setCategoriaRonda(String categoriaRonda) {
        this.categoriaRonda = categoriaRonda;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Novedades> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedades> novedades) {
        this.novedades = novedades;
    }

    @Override
    public String toString() {
        return "Rondas{" +
                "id=" + id +
                ", categoria_ronda='" + categoriaRonda + '\'' +
                ", detalle='" + detalle + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", created_at='" + createdAt + '\'' +
                ", updated_at='" + updatedAt + '\'' +
                ", novedades=" + novedades +
                '}';
    }
}
