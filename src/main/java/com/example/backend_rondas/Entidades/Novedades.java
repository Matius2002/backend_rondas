package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Novedades")
public class Novedades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "categoria_novedad", nullable = false)
    private String categoria_novedad;

    @Column(name = "novedad", nullable = false)
    private String novedad;

    @Column(name = "otro", nullable = false)
    private String otro;

    @Column(name = "prioridad", nullable = false)
    private String prioridad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "created_at", nullable = false)
    private String created_at;

    @Column(name = "updated_at", nullable = false)
    private String updated_at;

    public Novedades() {}

    public Novedades(String categoria_novedad, String novedad, String otro, String prioridad, String descripcion, String estado, String created_at, String updated_at) {
        this.categoria_novedad = categoria_novedad;
        this.novedad = novedad;
        this.otro = otro;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria_novedad() {
        return categoria_novedad;
    }

    public void setCategoria_novedad(String categoria_novedad) {
        this.categoria_novedad = categoria_novedad;
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

    @Override
    public String toString() {
        return "Novedades{" +
                "id=" + id +
                ", categoria_novedad='" + categoria_novedad + '\'' +
                ", novedad='" + novedad + '\'' +
                ", otro='" + otro + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}

