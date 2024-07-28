package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "novedades")
public class Novedades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoria_novedad", nullable = false)
    private String categoriaNovedad;

    @Column(name = "novedad", nullable = false)
    private String novedad;

    @Column(name = "otro")
    private String otro;

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

    // Relación con la entidad Rondas
    @ManyToOne
    @JoinColumn(name = "ronda_id")
    private Rondas ronda;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoriaNovedad() {
        return categoriaNovedad;
    }

    public void setCategoriaNovedad(String categoriaNovedad) {
        this.categoriaNovedad = categoriaNovedad;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
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

    public Rondas getRonda() {
        return ronda;
    }

    public void setRonda(Rondas ronda) {
        this.ronda = ronda;
    }

    @Override
    public String toString() {
        return "Novedades{" +
                "id=" + id +
                ", categoria_novedad='" + categoriaNovedad + '\'' +
                ", novedad='" + novedad + '\'' +
                ", otro='" + otro + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", created_at='" + createdAt + '\'' +
                ", updated_at='" + updatedAt + '\'' +
                ", ronda=" + ronda +
                '}';
    }
}
