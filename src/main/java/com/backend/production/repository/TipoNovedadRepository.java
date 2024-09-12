package com.backend.production.repository;

import com.backend.production.models.TipoNovedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoNovedadRepository extends JpaRepository<TipoNovedad, Integer> {
}
