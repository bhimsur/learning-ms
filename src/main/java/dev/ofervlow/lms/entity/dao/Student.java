package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(indexes = {
		@Index(name = "idx_student_idnumber_unq", columnList = "idNumber", unique = true)
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Student extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false, unique = true)
	private String idNumber;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Email
	private String email;

	@Column(nullable = false)
	private LocalDate birthDate;

	@Column(nullable = false)
	private String phoneNumber;

	@ToString.Exclude
	@OneToMany(mappedBy = "student")
	private Set<StudentQuizResult> studentQuizResults = new LinkedHashSet<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "student")
	private Set<Attendance> attendances = new LinkedHashSet<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "student")
	private Set<Enrollment> enrollments = new LinkedHashSet<>();

	@OneToMany(mappedBy = "student")
	@ToString.Exclude
	private Set<StudentQuizAnswer> studentQuizAnswers = new LinkedHashSet<>();

}