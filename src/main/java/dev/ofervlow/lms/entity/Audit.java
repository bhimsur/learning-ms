package dev.ofervlow.lms.entity;

import jakarta.persistence.*;
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

	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
		this.createdBy = "admin";
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedAt = LocalDateTime.now();
		this.updatedBy = "admin";
	}

	@PreRemove
	public void preRemove() {
		this.deletedAt = LocalDateTime.now();
		this.deletedBy = "admin";
		this.isDeleted = true;
	}
}