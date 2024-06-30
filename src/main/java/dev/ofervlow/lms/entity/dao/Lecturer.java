package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Lecturer extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Email
	private String email;

	@Column(nullable = false)
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "institution_id")
	private Institution institution;

	@ToString.Exclude
	@OneToMany(mappedBy = "lecturer")
	private Set<ClassesLecturer> classesLecturers = new LinkedHashSet<>();

}