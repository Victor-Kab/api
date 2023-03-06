package io.studerd.api.module.profile.entity.builder;

import io.studerd.api.common.contract.Builder;
import io.studerd.api.common.entity.enums.Gender;
import io.studerd.api.module.address.entity.Address;
import io.studerd.api.module.profile.entity.Profile;

public class ProfileBuilder implements Builder<Profile> {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Gender gender;
    Address address;

    public ProfileBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ProfileBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ProfileBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ProfileBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public ProfileBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public ProfileBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public Profile build() {
        return new Profile(firstname, lastname, phone, gender, address,email);
    }
}
