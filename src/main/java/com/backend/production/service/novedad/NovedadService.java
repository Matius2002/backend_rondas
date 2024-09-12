package com.backend.production.service.novedad;

import com.backend.production.dto.NovedadRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface NovedadService {
    List<Map<String, Object>> buscarPorRondaId(Integer rondaId);

    List<Map<String, Object>> buscarRondaAbiertas();

    Integer save(NovedadRequest request) throws IOException;

    String update(NovedadRequest request, Integer novedadId);

    String delete(Integer novedadId);
}