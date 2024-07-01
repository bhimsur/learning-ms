package dev.ofervlow.lms.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtil {

	public static <S, T> void copyProperties(S source, T target, String... ignoreProperties) {
		BeanUtils.copyProperties(source, target, Objects.requireNonNullElseGet(ignoreProperties, () -> getNullOrEmptyPropertyNames(source)));
	}

	private static <S> String[] getNullOrEmptyPropertyNames(S source) {
		final BeanWrapper wrapper = new BeanWrapperImpl(source);

		PropertyDescriptor[] propertyDescriptors = wrapper.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<>();

		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			Object srcValue = wrapper.getPropertyValue(propertyDescriptor.getName());
			if (null == srcValue) emptyNames.add(propertyDescriptor.getName());
		}

		String[] result = new String[emptyNames.size()];

		return emptyNames.toArray(result);
	}
}