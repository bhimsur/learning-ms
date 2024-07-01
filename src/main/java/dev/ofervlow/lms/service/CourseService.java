package dev.ofervlow.lms.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import dev.ofervlow.lms.entity.dao.Category;
import dev.ofervlow.lms.entity.dao.Course;
import dev.ofervlow.lms.entity.dto.CourseDto;
import dev.ofervlow.lms.entity.mapper.CourseMapper;
import dev.ofervlow.lms.exception.GeneralException;
import dev.ofervlow.lms.repository.CourseRepository;
import dev.ofervlow.lms.util.MapperUtil;
import dev.ofervlow.lms.util.SpecificationBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Service
public class CourseService {
	private final CourseRepository courseRepository;
	private final CategoryService categoryService;
	private final CourseMapper courseMapper;

	private CourseDto create(CourseDto dto) {
		Category category = categoryService.findById(dto.getCategory().getId());
		if (null == category) {
			throw new GeneralException("category not found");
		}

		Course entity = courseMapper.toEntity(dto);
		entity.setCategory(category);
		entity = courseRepository.saveAndFlush(entity);
		return courseMapper.toDto(entity);
	}

	private CourseDto update(Long id, CourseDto dto) {
		if (null == id) {
			throw new GeneralException("id must not be null");
		}
		Category category = categoryService.findById(dto.getCategory().getId());
		if (null == category) {
			throw new GeneralException("category not found");
		}

		Optional<Course> byId = courseRepository.findById(id);
		if (byId.isEmpty()) {
			throw new GeneralException("data not found");
		}

		Course entity = byId.get();
		MapperUtil.copyProperties(dto, entity);

		entity = courseRepository.saveAndFlush(entity);
		return courseMapper.toDto(entity);
	}

	public Page<CourseDto> searchOrFilter(CourseDto request, Pageable pageable) {
		log.info("start searchAndFilter, request : {}, pageable : {}", request, pageable);
		try {
			if (null != request.getId()) {
				throw new GeneralException("invalid input search");
			}

			SpecificationBuilder<Course> byCode = new SpecificationBuilder<>("code", "%%", request.getCode());
			SpecificationBuilder<Course> byTitle = new SpecificationBuilder<>("title", "%%", request.getTitle());
			SpecificationBuilder<Course> byDesc = new SpecificationBuilder<>("description", "%%", request.getDescription());
			SpecificationBuilder<Course> byCategoryCode = new SpecificationBuilder<>("category.code", "=", request.getCategory().getCode());

			return courseRepository.findAll(Specification.anyOf(byCode, byTitle, byDesc, byCategoryCode), pageable)
					.map(courseMapper::toDto);
		} catch (Exception e) {
			log.error("error searchAndFilter : {}", e.getMessage(), e);
			throw e;
		}
	}

	public void delete(Long id) {
		log.info("start delete, id : {}", id);
		try {
			courseRepository.deleteById(id);
		} catch (Exception e) {
			log.error("error delete : {}", e.getMessage(), e);
			throw e;
		}
	}
}