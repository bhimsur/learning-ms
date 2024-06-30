package dev.ofervlow.lms.repository;

import dev.ofervlow.lms.entity.dao.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long>, JpaSpecificationExecutor<Classes> {
}