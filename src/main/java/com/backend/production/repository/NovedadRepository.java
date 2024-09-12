package com.backend.production.repository;

import com.backend.production.models.Novedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface NovedadRepository extends JpaRepository<Novedad, Integer> {

    @Query(value = """
            SELECT nov.id, nov.ronda_id as "rondaId",
                                    prioridad, resuelto
                                    FROM  NOVEDADES nov
                                    WHERE ronda_id = ?1
            """, nativeQuery = true)
    List<Map<String, Object>> buscarPorRondaId(Integer rondaId);

    @Query(value = """
            SELECT r.id, n.id as novedad_id, s.name_subnovedad, c.resuelta, r.created_at  FROM rondas r
                        JOIN novedades n ON n.ronda_id = r.id
                        JOIN categoria_novedad c ON c.novedad_id = n.id
                        JOIN sub_novedades s ON s.id = c.categoria_id
                        WHERE (c.resuelta = '' or c.resuelta = 'No')
            """, nativeQuery = true)
    List<Map<String, Object>> buscarRondaAbiertas();
}