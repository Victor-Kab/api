package io.studerd.api.repository;

import io.studerd.api.entity.PlanningCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Transactional
@Repository

public interface PlanningCellRepository extends JpaRepository<PlanningCell, UUID> {
}
