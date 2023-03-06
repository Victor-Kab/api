package io.studerd.api.module.profile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.studerd.api.common.entity.enums.Gender;
import io.studerd.api.module.address.entity.Address;
import io.studerd.api.module.parameter.entity.Parameter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "profile_id", updatable = false, nullable = false)
    private UUID profile_id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id_fk",referencedColumnName = "address_id")
    Address address;
    @ManyToMany
    @JoinTable(
            name = "coaching",
            joinColumns = @JoinColumn(name = "coach_id", referencedColumnName = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "mine_id", referencedColumnName = "profile_id"))
    Set<Profile> coachs;

    @OneToMany
    @JoinColumn(name="profile_id_fk", referencedColumnName = "profile_id")
    List<Parameter> parameters;
    // this is handled by the system not by the client
    @JsonIgnore
    private String creatorCode;
    @JsonIgnore
    private boolean creatorCodeIsUsed;

    // This controller is called by and only by ProfileBuilder

    public Profile(String firstname, String lastname, String phone, Gender gender, Address address,String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.email = email;
        // this is handled by the system not by the client
        this.creatorCode = RandomStringUtils.random(10, true, true);
        this.creatorCodeIsUsed =false;
    }
}
