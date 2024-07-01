package dev.ofervlow.lms.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDto implements Serializable {
	private Long id;
	private String code;
	private String title;
	private String description;
	private CategoryDto category;
}