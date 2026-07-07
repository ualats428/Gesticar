package com.gesticar.backend.repository;

import com.gesticar.backend.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing {@link Engine} entities.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {

    boolean existsByModelIdAndName(Long modelId, String name);
}