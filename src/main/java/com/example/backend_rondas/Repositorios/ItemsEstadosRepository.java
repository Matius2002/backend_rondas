package com.example.backend_rondas.Repositorios;

import com.example.backend_rondas.Entidades.ItemsEstados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsEstadosRepository extends JpaRepository<ItemsEstados, Long> {
}
