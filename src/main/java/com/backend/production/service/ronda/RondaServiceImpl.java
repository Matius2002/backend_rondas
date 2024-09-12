package com.backend.production.service.ronda;

import com.backend.production.dto.RondaRequest;
import com.backend.production.models.Ronda;
import com.backend.production.repository.RondaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RondaServiceImpl implements RondaService{

    private final RondaRepository rondaRepository;

    public RondaServiceImpl(RondaRepository rondaRepository) {
        this.rondaRepository = rondaRepository;
    }

    @Override
    public List<Map<String, Object>> listarRondas(){
        return rondaRepository.findRondasWithDetails();
    }

    @Override
    public Integer save(RondaRequest request){
        Ronda ronda = new Ronda();
        ronda.setTorre(request.torre());
        ronda.setPiso(request.piso());
        ronda.setTecnicoResponsable(request.tecnicoResponsable());
        ronda.setArea(request.area());
        ronda.setCreatedAt(LocalDateTime.now());
        ronda.setUpdatedAt(LocalDateTime.now());
        rondaRepository.save(ronda);
        return ronda.getId();
    }

    @Override
    public String update(RondaRequest request, Integer rondaId){
        Optional<Ronda> ronda = rondaRepository.findById(rondaId);
        if (ronda.isPresent()) {
            ronda.get().setTorre(request.torre());
            ronda.get().setPiso(request.piso());
            ronda.get().setTecnicoResponsable(request.tecnicoResponsable());
            ronda.get().setArea(request.area());
            ronda.get().setUpdatedAt(LocalDateTime.now());
            rondaRepository.save(ronda.get());
        }
        return "Registro Actualizado";
    }

    @Override
    public String delete(Integer rondaId){
        Optional<Ronda> ronda = rondaRepository.findById(rondaId);
        String mensaje = "";
        if (ronda.isPresent()) {
            rondaRepository.delete(ronda.get());
            mensaje = "Registro Eliminado";
        }else {mensaje = "Registro No Existe";}

        return mensaje;
    }
}