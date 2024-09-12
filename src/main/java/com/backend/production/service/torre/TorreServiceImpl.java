package com.backend.production.service.torre;

import com.backend.production.dto.TorreRequest;
import com.backend.production.models.Torre;
import com.backend.production.repository.TorreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorreServiceImpl implements TorreService {

   private final TorreRepository torreRepository;

    public TorreServiceImpl(TorreRepository torreRepository) {
        this.torreRepository = torreRepository;
    }

    @Override
    public List<Torre> listarTorres(){
        return torreRepository.findAll();
    }

    @Override
    public String save(TorreRequest request) {
        Torre torre = new Torre();
        torre.setNombreTorre(request.nombreTorre());
        torreRepository.save(torre);
        return "Registro Creado";
    }
}
