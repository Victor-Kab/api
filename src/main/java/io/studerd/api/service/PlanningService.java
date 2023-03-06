package io.studerd.api.service;

import io.studerd.api.entity.Planning;

import java.util.List;
import java.util.UUID;

public interface PlanningService {
    void createPlanning(Planning planning);
    List<Planning>findPlanning();
    Planning findOnePlanning(UUID uuid);
    //Planning updatePlanning(Planning planning);

    Planning updatePlanning(Planning planning, UUID uuid);

    void delete(UUID uuid);
}
