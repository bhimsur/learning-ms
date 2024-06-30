package dev.ofervlow.lms.repository;

import dev.ofervlow.lms.entity.dao.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long>, JpaSpecificationExecutor<Cycle> {
}