package com.backend.production.repository;

import com.backend.production.models.CategoriaNovedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CategoriaNovedadRepository extends JpaRepository<CategoriaNovedad, Integer> {
    @Query(value = """
            SELECT categoria_novedad.id, categoria_id, s.name_subnovedad as nombreCategoria, descripcion, categoria_novedad.novedad_id, observacion, resuelta, sub_categoria_id from categoria_novedad\s
                        join sub_novedades s on s.id = categoria_id where categoria_novedad.novedad_id = ?1
            """, nativeQuery = true)
    List<Map<String , Object>> ListarCategoriaNovedad(Integer novedadId);
}
