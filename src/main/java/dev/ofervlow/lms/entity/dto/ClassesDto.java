package dev.ofervlow.lms.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassesDto implements Serializable {
	private Long id;
	private String title;
	private LocalDateTime date;
	private LocalTime startTime;
	private LocalTime endTime;
}