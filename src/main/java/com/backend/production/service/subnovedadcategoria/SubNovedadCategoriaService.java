package com.backend.production.service.subnovedadcategoria;


import com.backend.production.dto.SubNovedadCategoriaRequest;

import java.util.List;
import java.util.Map;

public interface SubNovedadCategoriaService {

    List<Map<String, Object>> listarSubNovedadCategoriaPorSubNovedadId(Integer subNovedadId);

    String save(SubNovedadCategoriaRequest request);
}