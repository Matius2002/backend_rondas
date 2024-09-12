package com.backend.production.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "novedades")
public class Novedad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ronda_id")
    private Integer rondaId;
    @Column(name = "tipo_novedad_id")
    private Integer tipoNovedadId;
    private String prioridad;
    private String observacion;
    //private byte[] img;
    private String img;
    private boolean resuelto;

}