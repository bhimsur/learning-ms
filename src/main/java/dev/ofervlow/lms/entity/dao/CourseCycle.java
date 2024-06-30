package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import dev.ofervlow.lms.entity.dao.embeddable.CourseCycleId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table
@IdClass(CourseCycleId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class CourseCycle extends Audit {

	@Id
	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
	private Course course;

	@Id
	@ManyToOne
	@JoinColumn(name = "cycle_id", referencedColumnName = "id", nullable = false)
	private Cycle cycle;

	@Column(nullable = false)
	private LocalDateTime startDate;

	@Column(nullable = false)
	private LocalDateTime endDate;

	@OneToMany(mappedBy = "courseCycle")
	@ToString.Exclude
	private Set<Classes> classes = new LinkedHashSet<>();

	@OneToMany(mappedBy = "courseCycle")
	@ToString.Exclude
	private Set<Enrollment> enrollments = new LinkedHashSet<>();

}