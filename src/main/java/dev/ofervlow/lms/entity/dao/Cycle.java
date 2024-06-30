package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Cycle extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime startDate;

	@Column(nullable = false)
	private LocalDateTime endDate;

	@ToString.Exclude
	@OneToMany(mappedBy = "cycle")
	private Set<CourseCycle> courseCycles = new LinkedHashSet<>();


}