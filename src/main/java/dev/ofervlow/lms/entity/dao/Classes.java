package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Classes extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private LocalDateTime date;

	@Column(nullable = false)
	private LocalTime startTime;

	@Column(nullable = false)
	private LocalTime endTime;

	@OneToMany(mappedBy = "classes")
	@ToString.Exclude
	private Set<Attendance> attendances = new LinkedHashSet<>();

	@OneToMany(mappedBy = "classes")
	@ToString.Exclude
	private Set<Quiz> quizzes = new LinkedHashSet<>();

	@ToString.Exclude
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "cycle_id"),
			@JoinColumn(name = "course_id")
	})
	private CourseCycle courseCycle;

	@ToString.Exclude
	@OneToMany(mappedBy = "classes")
	private Set<ClassesLecturer> classesLecturers = new LinkedHashSet<>();
}