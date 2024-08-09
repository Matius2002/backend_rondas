package com.example.backend_rondas.Repositorios;

import com.example.backend_rondas.Entidades.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {
}
