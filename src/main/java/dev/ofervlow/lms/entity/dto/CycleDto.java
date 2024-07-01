package dev.ofervlow.lms.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CycleDto implements Serializable {
	private Long id;
	private String description;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}