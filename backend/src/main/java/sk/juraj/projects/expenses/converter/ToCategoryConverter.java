package sk.juraj.projects.expenses.converter;

import org.modelmapper.AbstractConverter;

import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.entity.Category;

public class ToCategoryConverter extends AbstractConverter<CategoryDTO, Category>{

	@Override
	protected Category convert(CategoryDTO source) {
		Category category = new Category();
		var trimmedName = source.getName().trim();
		category.setName(trimmedName);
		final String colorCode = source.getColorCode();
		if(colorCode != null && !colorCode.isEmpty()) {
			category.setColorCode(colorCode);
		}
		category.setColorCode(source.getColorCode());
		return category;
	}

}
