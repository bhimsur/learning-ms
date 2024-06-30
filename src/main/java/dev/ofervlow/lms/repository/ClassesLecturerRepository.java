package dev.ofervlow.lms.repository;

import dev.ofervlow.lms.entity.dao.ClassesLecturer;
import dev.ofervlow.lms.entity.dao.embeddable.ClassesLecturerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesLecturerRepository extends JpaRepository<ClassesLecturer, ClassesLecturerId>, JpaSpecificationExecutor<ClassesLecturer> {
}