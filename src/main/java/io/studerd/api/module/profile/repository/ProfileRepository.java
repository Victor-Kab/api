package io.studerd.api.module.profile.repository;

import io.studerd.api.module.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    @Query("SELECT p from Profile p WHERE p.creatorCode=:code AND p.creatorCodeIsUsed = false")
    Optional<Profile> findForCode(String code);
}
