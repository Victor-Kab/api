package io.studerd.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Planning {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "planning_id", updatable = false, nullable = false)
    private UUID planning_id;
    private String title;
    private  String description;
    @ManyToOne
   private Cursus cursus;
    @OneToMany(mappedBy = "planning")
    private List<PlanningCell> planningCellList;
    @JsonFormat(pattern = "dd/MM/yyyy")

    private Date startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private  Date endDate;

}
