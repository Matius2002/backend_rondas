package com.backend.production.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "sub_novedades")
public class SubNovedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_subnovedad")
    private String nombreSubNovedad;

    @Column(name = "novedad_id")
    private Integer novedadId;
}
