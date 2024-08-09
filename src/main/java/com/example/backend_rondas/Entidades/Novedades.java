package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "novedades")
public class Novedades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_novedad_id")
    private CategoriaNovedad categoriaNovedad;

    @Column(name = "tipo_novedad", nullable = false)
    private String tipoNovedad;

    @Column(name = "prioridad", nullable = false)
    private String prioridad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "novedad_resuelta", nullable = false)
    private Boolean novedadResuelta;

    @ElementCollection
    @CollectionTable(name = "novedad_imagenes", joinColumns = @JoinColumn(name = "novedad_id"))
    @Column(name = "url")
    private List<String> imagenes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(String tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
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

    public Boolean getNovedadResuelta() {
        return novedadResuelta;
    }

    public void setNovedadResuelta(Boolean novedadResuelta) {
        this.novedadResuelta = novedadResuelta;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
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
}
