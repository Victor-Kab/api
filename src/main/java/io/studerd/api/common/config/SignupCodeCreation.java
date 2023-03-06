package io.studerd.api.common.config;

import java.util.UUID;

public enum SignupCodeCreation {
    USER(new Role(UUID.fromString("5a44a39e-6778-4d80-9c78-0b072a75d419"), "MURPH@2023", "user")),
    COACH(new Role(UUID.fromString("1be189f3-6479-49c3-bff5-69428286fd95"), "COACH@2023", "coach")),
    ADMIN(new Role(UUID.fromString("f47e76ce-a858-4dbb-9417-c695582e86b6"), "Admin@2023_STUD@io", "admin"));



    public final Role role;

    private SignupCodeCreation(Role role) {
        this.role = role;
    }
}

