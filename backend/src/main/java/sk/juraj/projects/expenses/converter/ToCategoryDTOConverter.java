package sk.juraj.projects.expenses.converter;

import org.modelmapper.AbstractConverter;

import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.entity.Category;

public class ToCategoryDTOConverter extends AbstractConverter<Category, CategoryDTO>{

	@Override
	protected CategoryDTO convert(Category source) {
		var categoryDTO = new CategoryDTO();
		categoryDTO.setName(source.getName());
		return categoryDTO;
	}

}
