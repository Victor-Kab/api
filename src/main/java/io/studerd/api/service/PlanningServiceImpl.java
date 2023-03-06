package io.studerd.api.service;

import io.studerd.api.entity.Planning;
import io.studerd.api.repository.PlanningRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
@Service
@Slf4j

public class PlanningServiceImpl implements PlanningService{
    private final PlanningRepository planningRepository;

    public PlanningServiceImpl( PlanningRepository planningRepository){

        this.planningRepository = planningRepository;
    }
    @Override
    public void createPlanning(Planning planning) {
        this.planningRepository.save(planning);

    }

    @Override
    public List<Planning> findPlanning() {
        return this.planningRepository.findAll();
    }

    @Override
    public Planning findOnePlanning(UUID uuid) {
        return (Planning) this.planningRepository.findAllById(Collections.singleton(uuid));
    }

    /*@Override
    public Planning updatePlanning(Planning planning) {
        return null;
    }*/

    @Override
    public Planning updatePlanning(Planning planning, UUID uuid){

            Planning planning1 = planningRepository.findById(uuid).get();
            planning1.setTitle(planning.getTitle());
            planning1.setDescription(planning.getDescription());
            return planningRepository.saveAndFlush(planning);
        }



    @Override
    public void delete(UUID uuid) {
        if (uuid==null){
            log.error("l'Id de planning est null");
            return;
        }
        planningRepository.deleteById(uuid);

    }
}
