package dev.ofervlow.lms.entity.dao;

import dev.ofervlow.lms.entity.dao.embeddable.ClassesLecturerId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
@IdClass(ClassesLecturerId.class)
public class ClassesLecturer implements Serializable {
	private static final long serialVersionUID = -9182851638898698037L;

	@Id
	@ManyToOne
	@JoinColumn(name = "lecturer_id", nullable = false)
	private Lecturer lecturer;

	@Id
	@ManyToOne
	@JoinColumn(name = "classes_id", nullable = false)
	private Classes classes;
}