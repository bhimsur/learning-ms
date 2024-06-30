package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import dev.ofervlow.lms.entity.enums.QuestionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class QuizQuestion extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String body;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private QuestionType questionType;

	@ToString.Exclude
	@OneToOne
	@JoinColumn(name = "correct_answer_id")
	private QuizAnswer correctAnswer;

	@ToString.Exclude
	@OneToMany(mappedBy = "quizQuestion")
	private Set<StudentQuizAnswer> studentQuizAnswers = new LinkedHashSet<>();

	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		QuizQuestion that = (QuizQuestion) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}