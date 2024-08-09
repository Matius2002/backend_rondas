package com.example.backend_rondas.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "elementos_novedad_tecnologica")
public class ElementosNovedadTecnologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Boolean enabled;

    @ManyToMany(mappedBy = "elementos")
    private Set<CategoriaNovedadTecnologica> categorias = new HashSet<>();

    // Constructores, getters y setters

    public ElementosNovedadTecnologica() {}

    public ElementosNovedadTecnologica(String nombre, String estado, Boolean enabled) {
        this.nombre = nombre;
        this.estado = estado;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<CategoriaNovedadTecnologica> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<CategoriaNovedadTecnologica> categorias) {
        this.categorias = categorias;
    }
}
