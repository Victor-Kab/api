package io.studerd.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlanningModel {
    private String PlanningTitle;
    private String PlanningDescription;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date PlanningStartDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date PlanningEndDate;
    private UUID Cursus_id;
}
