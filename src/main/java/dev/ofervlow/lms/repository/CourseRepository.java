package dev.ofervlow.lms.repository;

import dev.ofervlow.lms.entity.dao.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {
	@EntityGraph(attributePaths = {"category", "courseCycles"})
	Optional<Course> findByCode(String code);
}