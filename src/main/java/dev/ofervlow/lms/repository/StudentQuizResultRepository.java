package dev.ofervlow.lms.repository;

import dev.ofervlow.lms.entity.dao.StudentQuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentQuizResultRepository extends JpaRepository<StudentQuizResult, Long>, JpaSpecificationExecutor<StudentQuizResult> {
}