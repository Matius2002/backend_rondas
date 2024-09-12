package com.backend.production.security.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "nombre")
    String nombre;

    @Email
    @Column(name = "email")
    String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "clave")
    String password;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    Rol rol;

    @Column(name = "fecha_crea")
    LocalDateTime fechaCreacion;

}
