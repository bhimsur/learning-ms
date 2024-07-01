package dev.ofervlow.lms.entity.mapper;

import dev.ofervlow.lms.entity.dao.Attendance;
import dev.ofervlow.lms.entity.dto.AttendanceDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface AttendanceMapper extends BaseMapper<Attendance, AttendanceDto> {
	AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);
}