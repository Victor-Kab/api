package io.studerd.api.web;


import io.studerd.api.entity.PlanningCell;
import io.studerd.api.model.PlanningCellModel;
import io.studerd.api.service.PlanningCellService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
@Api(value = "/api/planningCell")

public class PlanningCellRestController {
    @Autowired
   private  PlanningCellService planningCellService;


    @PostMapping("/planningCell/add")
    void createPlanningCell(@RequestBody PlanningCellModel cellModel){
        PlanningCell planningCell = new PlanningCell();
        planningCell.setLesson(cellModel.getPlanningCellLesson());
        planningCell.setTargetDate(cellModel.getPlanningCellTarget());

        this.planningCellService.createPlanningCell(planningCell);
    }
    @GetMapping("/planningCell")

    List<PlanningCell> findPlanningCell(){
        return this.planningCellService.findPlanningCell();

    }
    @GetMapping("/planningCell/{uuid}")
    Optional<PlanningCell> findOnePlanningCell(@PathVariable UUID uuid){
        return this.planningCellService.findOnePlanningCell(uuid);

    }
    @PutMapping("/planningCell/update")

    void updatePlanningCell(@RequestBody PlanningCellModel planningCellModel, @RequestBody UUID uuid){

        PlanningCell planningCell1 = new PlanningCell();
        planningCell1.setLesson(planningCellModel.getPlanningCellLesson());
        planningCell1.setTargetDate(planningCellModel.getPlanningCellTarget());

        this.planningCellService.updatePlanningCell(planningCell1, uuid);

    }
    @DeleteMapping("planningCell/delete/{uuid}")
    void Delete(@PathVariable("uuid") UUID uuid) {
        this.planningCellService.delete(uuid);

    }

}
