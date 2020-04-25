package sk.juraj.projects.expenses.converter;

import org.modelmapper.AbstractConverter;

import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.entity.Category;

public class ToCategoryConverter extends AbstractConverter<CategoryDTO, Category>{

	@Override
	protected Category convert(CategoryDTO source) {
		Category category = new Category();
		category.setName(source.getName());
		return category;
	}

}
