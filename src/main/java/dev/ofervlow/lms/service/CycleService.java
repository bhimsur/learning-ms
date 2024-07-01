package dev.ofervlow.lms.service;

import dev.ofervlow.lms.entity.dao.Cycle;
import dev.ofervlow.lms.entity.dto.CycleDto;
import dev.ofervlow.lms.entity.mapper.CycleMapper;
import dev.ofervlow.lms.exception.GeneralException;
import dev.ofervlow.lms.repository.CycleRepository;
import dev.ofervlow.lms.util.SpecificationBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class CycleService {
	private final CycleRepository cycleRepository;
	private final CycleMapper cycleMapper;

	public CycleDto save(CycleDto dto) {
		log.info("start save, request : {}", dto);
		try {
			if (null != dto.getId()) throw new GeneralException("id must be null");
			Cycle entity = cycleMapper.toEntity(dto);

			entity = cycleRepository.saveAndFlush(entity);
			return cycleMapper.toDto(entity);
		} catch (Exception e) {
			log.error("error save : {}", e.getMessage(), e);
			throw e;
		}
	}

	public Page<CycleDto> get(CycleDto dto, Pageable pageable) {
		log.info("start get, request : {}, pageable : {}", dto, pageable);
		try {
			SpecificationBuilder<Cycle> description = new SpecificationBuilder<>("description", "%%", dto.getDescription());
			SpecificationBuilder<Cycle> startDate = new SpecificationBuilder<>("startDate", ">=", dto.getStartDate());
			SpecificationBuilder<Cycle> endDate = new SpecificationBuilder<>("endDate", "<=", dto.getEndDate());

			return cycleRepository.findAll(Specification.allOf(description, startDate, endDate), pageable)
					.map(cycleMapper::toDto);
		} catch (Exception e) {
			log.error("error get : {}", e.getMessage(), e);
			throw e;
		}
	}
}