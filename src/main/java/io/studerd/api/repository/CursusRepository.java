package io.studerd.api.repository;

import io.studerd.api.entity.Cursus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Transactional
@Repository

public interface CursusRepository extends JpaRepository<Cursus, UUID> {


}
