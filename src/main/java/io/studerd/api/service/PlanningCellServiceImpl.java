package io.studerd.api.service;

import io.studerd.api.entity.PlanningCell;
import io.studerd.api.repository.PlanningCellRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@Slf4j
public class PlanningCellServiceImpl implements PlanningCellService{

    private  final PlanningCellRepository planningCellRepository;
    public PlanningCellServiceImpl(PlanningCellRepository planningCellRepository){

        this.planningCellRepository = planningCellRepository;
    }
    @Override
    public void createPlanningCell(PlanningCell planningCell) {
        this.planningCellRepository.save(planningCell);

    }

    @Override
    public List<PlanningCell> findPlanningCell() {
        return this.planningCellRepository.findAll();
    }

    @Override
    public Optional<PlanningCell> findOnePlanningCell(UUID uuid) {
        return this.planningCellRepository.findById(uuid);
    }

    @Override
    public PlanningCell updatePlanningCell(PlanningCell planningCell, UUID uuid) {

        PlanningCell planningCell1 = planningCellRepository.findById(uuid).get();
        planningCell1.setLesson(planningCell.getLesson());
        planningCell1.setTargetDate(planningCell.getTargetDate());
        return planningCellRepository.saveAndFlush(planningCell);
    }

    @Override
    public void delete(UUID uuid) {
        if (uuid==null){
            log.error("l'Id de la cellule est null");
            return;
        }
        planningCellRepository.deleteById(uuid);

    }
}
