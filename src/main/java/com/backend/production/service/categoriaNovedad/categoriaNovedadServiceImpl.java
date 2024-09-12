package com.backend.production.service.categoriaNovedad;

import com.backend.production.dto.CategoriaNovedadRequest;
import com.backend.production.models.CategoriaNovedad;
import com.backend.production.models.Novedad;
import com.backend.production.repository.CategoriaNovedadRepository;
import io.jsonwebtoken.io.IOException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class categoriaNovedadServiceImpl implements categoriaNovedadService {
    private final CategoriaNovedadRepository categoriaNovedadRepository;

    public categoriaNovedadServiceImpl(CategoriaNovedadRepository categoriaNovedadRepository) {
        this.categoriaNovedadRepository = categoriaNovedadRepository;
    }

    @Override
    public List<Map<String, Object>> ListarCategoriaNovedad(Integer novedadId){
        return categoriaNovedadRepository.ListarCategoriaNovedad(novedadId);
    }

    @Override
    public Integer save(CategoriaNovedadRequest request) throws IOException {
        CategoriaNovedad categoria = new CategoriaNovedad();
        categoria.setNovedadId(request.novedadId());
        categoria.setCategoriaId(request.categoriaId());
        categoria.setSubCategoriaId(request.subCategoriaId());
        categoria.setResuelta(request.resuelta());
        categoria.setDescripcion(request.descripcion());
        categoria.setObservacion(request.observacion());
        categoriaNovedadRepository.save(categoria);
        return categoria.getId();
    }

    @Override
    public String update(CategoriaNovedadRequest request, Integer CNId) {
        Optional<CategoriaNovedad> categoria = categoriaNovedadRepository.findById(CNId);
        if (categoria.isPresent()) {
            categoria.get().setNovedadId(request.novedadId());
            categoria.get().setCategoriaId(request.categoriaId());
            categoria.get().setSubCategoriaId(request.subCategoriaId());
            categoria.get().setResuelta(request.resuelta());
            categoria.get().setDescripcion(request.descripcion());
            categoria.get().setObservacion(request.observacion());
            categoriaNovedadRepository.save(categoria.get());
            return "Registro Actualizado";
        }
        return null;
    }
}
