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
public class Course extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ToString.Exclude
	@OneToMany(mappedBy = "course")
	private Set<CourseCycle> courseCycles = new LinkedHashSet<>();

}