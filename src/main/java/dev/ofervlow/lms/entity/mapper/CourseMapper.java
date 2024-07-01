package dev.ofervlow.lms.entity.mapper;

import dev.ofervlow.lms.entity.dao.Course;
import dev.ofervlow.lms.entity.dto.CourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface CourseMapper extends BaseMapper<Course, CourseDto> {
	CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
}