package com.example.backend_rondas.Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; // Asegúrate de importar esta clase
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria_novedad_tecnologica")
public class CategoriaNovedadTecnologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Boolean enabled;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "categoria_elemento",
        joinColumns = @JoinColumn(name = "categoria_id"), // Se usa @JoinColumn aquí
        inverseJoinColumns = @JoinColumn(name = "elemento_id") // Se usa @JoinColumn aquí
    )
    private Set<ElementosNovedadTecnologica> elementos = new HashSet<>();

    // Constructores, getters y setters

    public CategoriaNovedadTecnologica() {}

    public CategoriaNovedadTecnologica(String nombre, Boolean enabled) {
        this.nombre = nombre;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<ElementosNovedadTecnologica> getElementos() {
        return elementos;
    }

    public void setElementos(Set<ElementosNovedadTecnologica> elementos) {
        this.elementos = elementos;
    }

    public void addElemento(ElementosNovedadTecnologica elemento) {
        this.elementos.add(elemento);
        elemento.getCategorias().add(this);
    }

    public void removeElemento(ElementosNovedadTecnologica elemento) {
        this.elementos.remove(elemento);
        elemento.getCategorias().remove(this);
    }
}
