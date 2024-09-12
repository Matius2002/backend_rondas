package com.backend.production.repository;

import com.backend.production.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface AreaRepository extends JpaRepository<Area, Integer> {

    @Query(value = """
            SELECT ID, NAME AS "nombreArea" FROM AREAS WHERE PISO_ID = ?1
            """, nativeQuery = true)
    List<Map<String, Object>> listarAreasPorPisoId(Integer pisoId);
}
