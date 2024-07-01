package dev.ofervlow.lms.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDto implements Serializable {
	private Long id;
	private String code;
	private String name;
	private String description;
}