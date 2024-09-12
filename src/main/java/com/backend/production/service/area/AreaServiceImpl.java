package com.backend.production.service.area;

import com.backend.production.dto.AreaRequest;
import com.backend.production.models.Area;
import com.backend.production.repository.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public List<Map<String, Object>> listarAreasPorPisoId(Integer pisoId){
        return areaRepository.listarAreasPorPisoId(pisoId);
    }

    @Override
    public String save(AreaRequest request) {
        Area area = new Area();
        area.setNombreArea(request.nombreArea());
        area.setPisoId(request.pisoId());
        areaRepository.save(area);
        return "Registro Creado";
    }
}
