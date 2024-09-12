package com.backend.production.repository;

import com.backend.production.models.SubNovedadCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface SubNovedadCategoriaRepository extends JpaRepository<SubNovedadCategoria, Integer> {

    @Query(value = """
            SELECT ID, NAME AS "nombreCategoria" FROM subnovedades_categorias WHERE SUBNOVEDAD_ID = ?1
            """, nativeQuery = true)
    List<Map<String, Object>> listarSubNovedadCategoriaPorSubNovedadId(Integer subNovedadId);
}
