package com.example.backend_rondas.Entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rondas") //Tabla rondas
public class Rondas {

    /*Estas anotaciones ayudan a definir cómo se deben mapear los atributos de una clase a columnas en una tabla de base de datos */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "torre", nullable = false)
    private String torre;

    @Column(name = "piso", nullable = false)
    private String piso;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "tecnico_responsable", nullable = false)
    private String tecnicoResponsable;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTecnicoResponsable() {
        return tecnicoResponsable;
    }

    public void setTecnicoResponsable(String tecnicoResponsable) {
        this.tecnicoResponsable = tecnicoResponsable;
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

    /*Cuando sobrescribes este método en una clase, permites que se devuelva una descripción legible y útil del estado del objeto cuando se imprima
     o se convierta a una cadena.*/
    @Override
    public String toString() {
        return "Rondas{" +
                "id=" + id +
                ", torre='" + torre + '\'' +
                ", piso='" + piso + '\'' +
                ", area='" + area + '\'' +
                ", tecnicoResponsable='" + tecnicoResponsable + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
