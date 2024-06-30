package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class QuizAnswer extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String value;

	private String description;

	@OneToMany(mappedBy = "quizAnswer")
	@ToString.Exclude
	private Set<StudentQuizAnswer> studentQuizAnswers = new LinkedHashSet<>();

}