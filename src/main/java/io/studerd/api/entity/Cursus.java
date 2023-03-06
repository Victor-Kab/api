package io.studerd.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Cursus {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "cursus_id", updatable = false, nullable = false)
    private UUID cursus_id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "cursus")
   private Collection <Planning> planningList = new ArrayList<>();

}
