package io.studerd.api.web;

import io.studerd.api.entity.Planning;
import io.studerd.api.model.PlanningModel;
import io.studerd.api.service.PlanningCellService;
import io.studerd.api.service.PlanningService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
@Api(value = "/api/planning")

public class PlanningRestController {
    @Autowired
    PlanningService planningService;
    PlanningCellService planningCellService;
    @PostMapping("/planning/add")
    void createPlanning(@RequestBody PlanningModel model){
        Planning planning = new Planning();
        planning.setTitle(model.getPlanningTitle());
        planning.setDescription(model.getPlanningDescription());
        planning.setPlanningCellList(this.planningCellService.findPlanningCell());
        this.planningService.createPlanning(planning);

    }
    @GetMapping("/planning")
    List<Planning> Planning(){
        return this.planningService.findPlanning();

    }
    @GetMapping("/planning/{uuid}")
    Planning getOnePlanning(@PathVariable UUID uuid){
        return this.planningService.findOnePlanning(uuid);
    }

    @PutMapping("/planning/update")

    void updatePlanning(@RequestBody PlanningModel planningModel, @RequestBody UUID uuid){

        Planning planning = new Planning();
        planning.setTitle(planningModel.getPlanningTitle());
        planning.setDescription(planningModel.getPlanningDescription());
        planning.setStartDate(planningModel.getPlanningStartDate());
        planning.setEndDate(planningModel.getPlanningEndDate());
        //planning.setCursus(this.cursusService.findOneCursus(planningModel.getCursus_id()));

        this.planningService.updatePlanning(planning, uuid);

    }

    @DeleteMapping("planning/delete/{uuid}")
    void Delete(@PathVariable("uuid") UUID uuid) {
        this.planningService.delete(uuid);

    }
}
