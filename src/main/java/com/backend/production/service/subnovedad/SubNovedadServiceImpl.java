package com.backend.production.service.subnovedad;

import com.backend.production.dto.SubNovedadRequest;
import com.backend.production.models.SubNovedad;
import com.backend.production.repository.SubNovedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubNovedadServiceImpl implements SubNovedadService{

    private final SubNovedadRepository subNovedadRepository;

    public SubNovedadServiceImpl(SubNovedadRepository subNovedadRepository) {
        this.subNovedadRepository = subNovedadRepository;
    }

    @Override
    public List<Map<String , Object>> listarSubNovedadPorTipoNovedadId(Integer tipoNovedadId){
        return subNovedadRepository.listarSubNovedadPorTipoNovedadId(tipoNovedadId);
    }

    @Override
    public String save(SubNovedadRequest request){
        SubNovedad subNovedad = new SubNovedad();
        subNovedad.setNovedadId(request.novedadId());
        subNovedad.setNombreSubNovedad(request.nombreSubNovedad());
        subNovedadRepository.save(subNovedad);
        return "Registro Creado";
    }
}
