package com.backend.production.dto;

public record RondaRequest(
        Integer torre,
        Integer piso,
        Integer area,
        String tecnicoResponsable
) {
}