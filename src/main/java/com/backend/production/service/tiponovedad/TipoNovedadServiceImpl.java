package com.backend.production.service.tiponovedad;

import com.backend.production.models.TipoNovedad;
import com.backend.production.repository.TipoNovedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoNovedadServiceImpl implements TipoNovedadService{

    private  final TipoNovedadRepository tipoNovedadRepository;

    public TipoNovedadServiceImpl(TipoNovedadRepository tipoNovedadRepository) {
        this.tipoNovedadRepository = tipoNovedadRepository;
    }

    @Override
    public List<TipoNovedad> listarTipoNovedades(){
        return tipoNovedadRepository.findAll();
    }
}
