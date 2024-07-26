package com.example.backend_rondas.Servicios;

import org.springframework.stereotype.Service;

@Service
public class RondasServicio {
    /*@Autowired
    private AlojamientoRepositorio alojamientoRepositorio;

    public AlojamientoServicio(AlojamientoRepositorio alojamientoRepositorio) {
        this.alojamientoRepositorio = alojamientoRepositorio;
    }
    //CRUD
    //Obtener todos los alojamientos turisticos
    public List<Alojamiento> obtenerTodosLosAlojamientos () {
        return alojamientoRepositorio.findAll();
    }
    //guardar alojamiento turistico
    public Alojamiento guardarAlojamiento(Alojamiento alojamiento) {
        return alojamientoRepositorio.save(alojamiento);
    }
    //Obtener alojamientos por id
    public Alojamiento obtenerAlojamientoPorId(Long id) {
        return alojamientoRepositorio.findById(id).orElseThrow(()-> new AlojamientoNotFoundException(id));
    }
    //actulizar alojamiento turistico
    public Alojamiento actulizarAlojamientos(Alojamiento alojamiento) {
        return alojamientoRepositorio.save(alojamiento);
    }
    //Eliminar alojamiento
    public void eliminarAlojamiento(Long id) {
        alojamientoRepositorio.deleteById(id);
    }
    //Verificar si existe en la base. por nombre
    public boolean verificarAlojamientoExistente(String nombre) {
        return alojamientoRepositorio.existsByNombre(nombre);
    }*/
}
