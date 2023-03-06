package io.studerd.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlanningCellModel {
    private String PlanningCellLesson;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date PlanningCellTarget;
}
