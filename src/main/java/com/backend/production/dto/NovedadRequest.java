package com.backend.production.dto;

import org.springframework.web.multipart.MultipartFile;

public record NovedadRequest(
        Integer rondaId,
        Integer tipoNovedadId,
        String prioridad,
        String observacion,
        //MultipartFile img
        String img,
        boolean resuelto
) {
}