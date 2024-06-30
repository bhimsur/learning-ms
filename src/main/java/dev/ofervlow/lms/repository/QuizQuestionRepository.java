package dev.ofervlow.lms.repository;

import dev.ofervlow.lms.entity.dao.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long>, JpaSpecificationExecutor<QuizQuestion> {
}