package com.backend.production.repository;

import com.backend.production.models.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PisoRepository extends JpaRepository<Piso, Integer> {

    @Query(value = """
            SELECT ID, NAME AS "nombrePiso" FROM PISOS WHERE TORRE_ID = ?1
            """, nativeQuery = true)
    List<Map<String, Object>> listarPisosPorTorreId(Integer torreId);
}
