package dev.ofervlow.lms.entity.dao.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ClassesLecturerId implements Serializable {
	private Long classes;
	private Long lecturer;
}