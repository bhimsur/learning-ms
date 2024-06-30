package dev.ofervlow.lms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class Audit implements Serializable {
	@Column(updatable = false, nullable = false)
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private LocalDateTime deletedAt;

	@Column(updatable = false, nullable = false)
	private String createdBy;

	private String updatedBy;

	private String deletedBy;

	@Column(nullable = false)
	private boolean isDeleted = false;
}