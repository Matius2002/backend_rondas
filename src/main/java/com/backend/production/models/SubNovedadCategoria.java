package com.backend.production.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "subnovedades_categorias")
public class SubNovedadCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String nombreCategoria;
    @Column(name = "subnovedad_id")
    private Integer subNovedadId;
}