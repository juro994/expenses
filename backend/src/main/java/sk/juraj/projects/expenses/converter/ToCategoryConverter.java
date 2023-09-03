package sk.juraj.projects.expenses.converter;

import org.modelmapper.AbstractConverter;

import sk.juraj.projects.expenses.dto.CategoryCreateDTO;
import sk.juraj.projects.expenses.entity.Category;

public class ToCategoryConverter extends AbstractConverter<CategoryCreateDTO, Category> {

	private static final String DEFAULT_CATEGORY_COLOR_CODE = "#ffffff";

	@Override
	protected Category convert(CategoryCreateDTO source) {
		final Category category = new Category();
		var trimmedName = source.getName().trim();
		category.setName(trimmedName);
		category.setMonthlyBudget(source.getMonthlyBudget());
		category.setColorCode(source.getColorCode().orElse(DEFAULT_CATEGORY_COLOR_CODE));
		return category;
	}
    
}
