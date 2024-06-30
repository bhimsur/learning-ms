package dev.ofervlow.lms.repository;

import dev.ofervlow.lms.entity.dao.CourseCycle;
import dev.ofervlow.lms.entity.dao.embeddable.CourseCycleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCycleRepository extends JpaRepository<CourseCycle, CourseCycleId>, JpaSpecificationExecutor<CourseCycle> {
}