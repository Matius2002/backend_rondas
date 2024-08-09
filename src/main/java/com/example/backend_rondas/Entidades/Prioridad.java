package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "prioridades")
public class Prioridad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    public Prioridad() {}

    public Prioridad(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters

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

    @Override
    public String toString() {
        return "Prioridad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
