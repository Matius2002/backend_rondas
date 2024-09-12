package com.backend.production.service.novedad;

import com.backend.production.dto.NovedadRequest;
import com.backend.production.models.Novedad;
import com.backend.production.repository.NovedadRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NovedadServiceImpl implements NovedadService{

    private final NovedadRepository novedadRepository;

    public NovedadServiceImpl(NovedadRepository novedadRepository) {
        this.novedadRepository = novedadRepository;
    }

    @Override
    public List<Map<String, Object>> buscarPorRondaId(Integer rondaId){
        return novedadRepository.buscarPorRondaId(rondaId);
    }

    @Override
    public List<Map<String, Object>> buscarRondaAbiertas(){
        return novedadRepository.buscarRondaAbiertas();
    }

    @Override
    public Integer save(NovedadRequest request) throws IOException {
        Novedad novedad = new Novedad();
        novedad.setTipoNovedadId(request.tipoNovedadId());
        novedad.setRondaId(request.rondaId());
        novedad.setPrioridad(request.prioridad());
        novedad.setObservacion(request.observacion());
        //novedad.setImg(request.img().getBytes());
        novedad.setImg(request.img());
        novedad.setResuelto(request.resuelto());
        novedadRepository.save(novedad);
        return novedad.getId();
    }

    @Override
    public String update(NovedadRequest request, Integer novedadId){

        Optional<Novedad> novedad = novedadRepository.findById(novedadId);
        if (novedad.isPresent()) {
            novedad.get().setTipoNovedadId(request.tipoNovedadId());
            novedad.get().setRondaId(request.rondaId());
            novedad.get().setPrioridad(request.prioridad());
            novedad.get().setObservacion(request.observacion());
            //novedad.setImg(request.img().getBytes());
            novedad.get().setImg(request.img());
            novedad.get().setResuelto(request.resuelto());
            novedadRepository.save(novedad.get());
        }
        return "Registro Actualizado";
    }

    @Override
    public String delete(Integer novedadId) {
        Optional<Novedad> novedad = novedadRepository.findById(novedadId);
        String mensaje = "";
        if (novedad.isPresent()){
            novedadRepository.delete(novedad.get());
            mensaje = "Registro Eliminado";
        }else {mensaje = "Registro No Existe";}

        return mensaje;
    }
}
