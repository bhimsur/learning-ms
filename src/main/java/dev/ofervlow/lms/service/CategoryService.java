package dev.ofervlow.lms.service;

import dev.ofervlow.lms.entity.dao.Category;
import dev.ofervlow.lms.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public Category create(Category category) {
		return categoryRepository.saveAndFlush(category);
	}
}