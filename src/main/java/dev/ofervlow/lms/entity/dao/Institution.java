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
public class Institution extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@ToString.Exclude
	@OneToMany(mappedBy = "institution", orphanRemoval = true)
	private Set<Lecturer> lecturers = new LinkedHashSet<>();

}