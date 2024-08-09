/*Repositorio de Tipo de ronda*/
package com.example.backend_rondas.Repositorios;

import com.example.backend_rondas.Entidades.CategoriaNovedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaNovedadRepository extends JpaRepository<CategoriaNovedad, Long> {
    
}
