package dev.ofervlow.lms.entity.dao.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CourseCycleId implements Serializable {
	private Long courseId;
	private Long cycleId;
}