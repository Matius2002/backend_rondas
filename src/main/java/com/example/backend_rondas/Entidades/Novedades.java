package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "novedades")
public class Novedades {

    /* Campo Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Relación Muchos a uno de Novedades y CategoriaNovedad */
    @ManyToOne
    @JoinColumn(name = "categoria_novedad_id")
    private CategoriaNovedad categoriaNovedad;

    /* Relación Muchos a uno de Novedades y CategoriaNovedadTecnologica */
    @ManyToOne
    @JoinColumn(name = "categoria_novedad_tecnologica_id")
    private CategoriaNovedadTecnologica categoriaNovedadTecnologica;

    /*Relacion de Muchos a muchos de Novedades y ElementosNovedadTecnologica*/
    @ManyToMany
    @JoinTable(
        name = "novedad_elementos",
        joinColumns = @JoinColumn(name = "novedad_id"),
        inverseJoinColumns = @JoinColumn(name = "elemento_id")
    )
    private List<ElementosNovedadTecnologica> elementosNovedadTecnologica;

    /* Relación Muchos a uno de Novedades y Prioridad */
    @ManyToOne
    @JoinColumn(name = "prioridad_id")
    private Prioridad prioridad;

    /* Textarea */
    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    /* Botones Sí o No */
    @Column(name = "novedad_resuelta", nullable = false)
    private Boolean novedadResuelta;

    /* Imágenes */
    @ElementCollection
    @CollectionTable(name = "novedad_imagenes", joinColumns = @JoinColumn(name = "novedad_id"))
    @Column(name = "url")
    private List<String> imagenes;

    /* Creación de novedad */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /* Actualización de novedad */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaNovedad getCategoriaNovedad() {
        return categoriaNovedad;
    }

    public void setCategoriaNovedad(CategoriaNovedad categoriaNovedad) {
        this.categoriaNovedad = categoriaNovedad;
    }

    public CategoriaNovedadTecnologica getCategoriaNovedadTecnologica() {
        return categoriaNovedadTecnologica;
    }

    public void setCategoriaNovedadTecnologica(CategoriaNovedadTecnologica categoriaNovedadTecnologica) {
        this.categoriaNovedadTecnologica = categoriaNovedadTecnologica;
    }

    public List<ElementosNovedadTecnologica> getElementosNovedadTecnologica() {
        return elementosNovedadTecnologica;
    }

    public void setElementosNovedadTecnologica(List<ElementosNovedadTecnologica> elementosNovedadTecnologica) {
        this.elementosNovedadTecnologica = elementosNovedadTecnologica;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
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

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
