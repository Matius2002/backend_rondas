package com.backend.production.service.piso;

import com.backend.production.dto.PisoRequest;
import com.backend.production.models.Piso;
import com.backend.production.repository.PisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PisoServiceImpl implements PisoService {

    private final PisoRepository pisoRepository;

    public PisoServiceImpl(PisoRepository pisoRepository) {
        this.pisoRepository = pisoRepository;
    }

    @Override
    public List<Map<String, Object>> listarPisosPorTorreId(Integer torreId){
        return pisoRepository.listarPisosPorTorreId(torreId);
    }

    @Override
    public String save(PisoRequest request) {
        Piso piso = new Piso();
        piso.setNombrePiso(request.nombrePiso());
        piso.setTorreId(request.torreId());
        pisoRepository.save(piso);
        return "Registro Creado";
    }
}
