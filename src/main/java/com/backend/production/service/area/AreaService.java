package com.backend.production.service.area;

import com.backend.production.dto.AreaRequest;

import java.util.List;
import java.util.Map;

public interface AreaService {

    List<Map<String, Object>> listarAreasPorPisoId(Integer pisoId);

    String save(AreaRequest request);
}
