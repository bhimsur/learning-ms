package dev.ofervlow.lms.util;

import jakarta.persistence.criteria.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationBuilder<T> implements Specification<T> {
	private String key;
	private String operation;
	private Object value;
	private String join;

	public SpecificationBuilder(String key, String operation, Object value) {
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public static <T> Specification<T> init(SpecificationBuilder<T> criteria) {
		if (null != criteria.getValue()) {
			return Specification.where(criteria);
		} else {
			return null;
		}
	}

	public static <T> Specification<T> and(Specification<T> group, SpecificationBuilder<T> criteria) {
		if (null != criteria.getValue()) {
			if (null != group) {
				return group.and(criteria);
			} else {
				return Specification.where(criteria);
			}
		} else {
			return group;
		}
	}

	public static <T> Specification<T> or(Specification<T> group, SpecificationBuilder<T> criteria) {
		if (null != criteria.getValue()) {
			if (null != group) {
				return group.or(criteria);
			} else {
				return Specification.where(criteria);
			}
		} else {
			return group;
		}
	}

	@Override
	public Predicate toPredicate(@NotNull Root<T> root, @NotNull CriteriaQuery<?> query, @NotNull CriteriaBuilder builder) {
		if (operation.equalsIgnoreCase("=")) {
			Expression<String> expression;
			if (this.key.contains(".")) {
				String[] keys = this.key.split("\\.");
				Join<?, ?> join = root.join(keys[0], JoinType.LEFT);
				query.distinct(true);
				expression = join.get(keys[1]);
			} else {
				expression = root.get(this.key);
			}
			return builder.equal(expression, this.value);
		} else if (operation.equalsIgnoreCase("in")) {
			return builder.in(root.get(this.key)).value(this.value);
		} else if (operation.equalsIgnoreCase("%%")) {
			String val = "%" + this.value.toString().toLowerCase() + "%";
			Expression<String> expression;
			if (this.key.contains(".")) {
				String[] keys = this.key.split("\\.");
				Join<?, ?> join = root.join(keys[0], JoinType.LEFT);
				query.distinct(true);
				expression = builder.lower(join.get(keys[1]));
			} else {
				expression = builder.lower(root.get(this.key));
			}
			return builder.like(expression, val);
		} else if (operation.equalsIgnoreCase("isNull")) {
			Expression<String> expression;
			if (this.key.contains(".")) {
				String[] keys = this.key.split("\\.");
				Join<?, ?> join = root.join(keys[0], JoinType.LEFT);
				expression = join.get(keys[1]);
			} else {
				expression = root.get(this.key);
			}
			return builder.isNull(expression);
		} else if (operation.equalsIgnoreCase(">=")) {
			return builder.greaterThanOrEqualTo(root.get(this.key), LocalDateTime.parse(this.value.toString()));
		} else if (operation.equalsIgnoreCase("<=")) {
			return builder.lessThanOrEqualTo(root.get(this.key), LocalDateTime.parse(this.value.toString()));
		}
		return null;
	}
}