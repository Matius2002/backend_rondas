package com.backend.production.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "rondas")
public class Ronda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "torre", nullable = false)
    private Integer torre;

    @Column(name = "piso", nullable = false)
    private Integer piso;

    @Column(name = "area", nullable = false)
    private Integer area;

    @Column(name = "tecnico_responsable", nullable = false)
    private String tecnicoResponsable;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}