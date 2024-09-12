package com.backend.production.dto;

public record CategoriaNovedadRequest(
    Integer novedadId,
    Integer categoriaId,
    String subCategoriaId,
    String descripcion,
    String resuelta,
    String observacion
){
}
