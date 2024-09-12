package com.backend.production.service.categoriaNovedad;

import com.backend.production.dto.CategoriaNovedadRequest;

import java.util.List;
import java.util.Map;

public interface categoriaNovedadService {
    List<Map<String, Object>> ListarCategoriaNovedad(Integer novedadId);

    Integer save(CategoriaNovedadRequest request);
    String update(CategoriaNovedadRequest request, Integer CNId);
}