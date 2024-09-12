package com.backend.production.service.subnovedadcategoria;

import com.backend.production.dto.SubNovedadCategoriaRequest;
import com.backend.production.models.SubNovedadCategoria;
import com.backend.production.repository.SubNovedadCategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubNovedadCategoriaServiceImpl implements SubNovedadCategoriaService {

    private final SubNovedadCategoriaRepository subNovedadCategoriaRepository;

    public SubNovedadCategoriaServiceImpl(SubNovedadCategoriaRepository subNovedadCategoriaRepository) {
        this.subNovedadCategoriaRepository = subNovedadCategoriaRepository;
    }
    @Override
    public List<Map<String, Object>> listarSubNovedadCategoriaPorSubNovedadId(Integer subNovedadId){
        return subNovedadCategoriaRepository.listarSubNovedadCategoriaPorSubNovedadId(subNovedadId);
    }

    @Override
    public String save(SubNovedadCategoriaRequest request){
        SubNovedadCategoria subNovedadCategoria = new SubNovedadCategoria();
        subNovedadCategoria.setSubNovedadId(request.subNovedadId());
        subNovedadCategoria.setNombreCategoria(request.nombreCategoria());
        subNovedadCategoriaRepository.save(subNovedadCategoria);
        return "Registro Creado";
    }
}
