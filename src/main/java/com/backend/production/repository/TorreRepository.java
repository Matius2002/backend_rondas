package com.backend.production.repository;

import com.backend.production.models.Torre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorreRepository extends JpaRepository<Torre, Integer> {
}
