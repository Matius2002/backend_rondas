package com.backend.production.service.ronda;

import com.backend.production.dto.RondaRequest;
import com.backend.production.models.Ronda;

import java.util.List;
import java.util.Map;

public interface RondaService {
    Integer save(RondaRequest request);
    List<Map<String, Object>> listarRondas();
    String update(RondaRequest request, Integer rondaId);
    String delete(Integer rondaId);
}