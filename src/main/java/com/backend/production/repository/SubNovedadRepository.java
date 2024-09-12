package com.backend.production.repository;

import com.backend.production.models.SubNovedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface SubNovedadRepository extends JpaRepository<SubNovedad, Integer> {
    @Query(value = """
            SELECT ID, NAME_SUBNOVEDAD AS "nombreSubNovedad" from sub_novedades where NOVEDAD_ID = ?1;
            """, nativeQuery = true)
    List<Map<String , Object>> listarSubNovedadPorTipoNovedadId(Integer tipoNovedadId);
}