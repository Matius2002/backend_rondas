package com.backend.production.service.piso;


import com.backend.production.dto.PisoRequest;

import java.util.List;
import java.util.Map;

public interface PisoService {

    List<Map<String, Object>> listarPisosPorTorreId(Integer torreId);

    String save(PisoRequest request);
}