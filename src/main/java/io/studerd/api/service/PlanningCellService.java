package io.studerd.api.service;

import io.studerd.api.entity.Cursus;
import io.studerd.api.entity.Planning;
import io.studerd.api.entity.PlanningCell;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlanningCellService {
    void createPlanningCell(PlanningCell planningCell);
    List<PlanningCell> findPlanningCell();
    Optional<PlanningCell> findOnePlanningCell(UUID uuid);
    PlanningCell updatePlanningCell(PlanningCell planningCell, UUID uuid);
    void delete(UUID uuid);
}
