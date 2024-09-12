package com.backend.production.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "categoriaNovedad")
public class CategoriaNovedad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "novedad_id")
    private Integer novedadId;
    @Column(name = "categoria_id")
    private Integer categoriaId;
    @Column(name = "subCategoria_id")
    private String subCategoriaId;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "resuelta")
    private String resuelta;
    @Column(name = "observacion")
    private String observacion;
}
