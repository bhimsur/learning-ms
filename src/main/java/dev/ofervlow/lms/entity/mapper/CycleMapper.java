package dev.ofervlow.lms.entity.mapper;

import dev.ofervlow.lms.entity.dao.Cycle;
import dev.ofervlow.lms.entity.dto.CycleDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface CycleMapper extends BaseMapper<Cycle, CycleDto> {
	CycleMapper INSTANCE = Mappers.getMapper(CycleMapper.class);
}