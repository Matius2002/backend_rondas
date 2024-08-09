package com.example.backend_rondas.Entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Items {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemsEstados> itemsEstados;

    // Getters y setters

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

    public List<ItemsEstados> getItemsEstados() {
        return itemsEstados;
    }

    public void setItemsEstados(List<ItemsEstados> itemsEstados) {
        this.itemsEstados = itemsEstados;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", itemsEstados=" + itemsEstados +
                '}';
    }
}
