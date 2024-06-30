package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.Audit;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.EntityGraph;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Attendance extends Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(updatable = false)
	private LocalDateTime checkIn;

	@Column(updatable = false)
	private LocalDateTime checkOut;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "classes_id")
	private Classes classes;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

}