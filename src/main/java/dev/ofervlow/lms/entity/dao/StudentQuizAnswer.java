package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class StudentQuizAnswer extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "quiz_answer_id")
	private QuizAnswer quizAnswer;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "quiz_question_id")
	private QuizQuestion quizQuestion;

}