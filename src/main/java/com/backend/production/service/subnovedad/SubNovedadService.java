package com.backend.production.service.subnovedad;

import com.backend.production.dto.SubNovedadRequest;

import java.util.List;
import java.util.Map;

public interface SubNovedadService {
    List<Map<String , Object>> listarSubNovedadPorTipoNovedadId(Integer tipoNovedadId);

    String save(SubNovedadRequest request);
}
