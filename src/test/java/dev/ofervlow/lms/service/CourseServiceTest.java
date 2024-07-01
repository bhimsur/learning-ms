package dev.ofervlow.lms.service;

import dev.ofervlow.lms.entity.dao.Category;
import dev.ofervlow.lms.entity.dao.Course;
import dev.ofervlow.lms.entity.dto.CourseDto;
import dev.ofervlow.lms.entity.mapper.CourseMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseServiceTest {

	@Test
	void toDto() {
		CourseMapper courseMapper = CourseMapper.INSTANCE;
		Course course = new Course();

		Category category = new Category();
		category.setCode("ABC");
		category.setName("ABC");
		category.setDescription("aBc");
		category.setId(1L);

		course.setCategory(category);
		course.setCode("AN");
		course.setId(1L);
		course.setTitle("AB");
		course.setDescription("ABC");

		CourseDto dto = courseMapper.toDto(course);
		assertEquals(course.getId(), dto.getId());
		assertEquals(course.getCategory().getCode(), category.getCode());
	}
}