package io.studerd.api.repository;

import io.studerd.api.entity.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Transactional
@Repository

public interface PlanningRepository extends JpaRepository<Planning, UUID> {

}
