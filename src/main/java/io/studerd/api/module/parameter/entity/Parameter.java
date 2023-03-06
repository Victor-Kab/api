package io.studerd.api.module.parameter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.studerd.api.module.parameter.entity.enums.ParameterType;
import io.studerd.api.module.profile.entity.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "parameter_id", updatable = false, nullable = false)
    private UUID parameter_id;
    private String name;
    private ParameterType type;
    private String value;
    private boolean editable;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="profile_id_fk",referencedColumnName = "profile_id")
    Profile profile;

    public Parameter(String name, ParameterType type, String value, boolean editable, Profile profile) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.editable = editable;
        this.profile = profile;
    }
}
