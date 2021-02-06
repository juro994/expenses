package sk.juraj.projects.expenses.converter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.dto.ExpenseDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;

public class ToCategoryDTOConverter extends AbstractConverter<Category, CategoryDTO>{

	@Override
	protected CategoryDTO convert(Category source) {
		var categoryDTO = new CategoryDTO();
		categoryDTO.setId(source.getId());
		categoryDTO.setName(source.getName());
		convertExpenses(categoryDTO, source);
		return categoryDTO;
	}
	
	private void convertExpenses(CategoryDTO target, Category source) {
		var expenseDTOs = Optional.ofNullable(source.getExpenses()).orElseGet(Collections::emptySet).stream().map(expense -> convertExpense(expense)).collect(Collectors.toList());
		target.setExpenses(expenseDTOs);
	}
	
	private ExpenseDTO convertExpense(Expense source) {
		var target = new ExpenseDTO();
		target.setName(source.getTitle());
		target.setAmount(source.getAmount());
		target.setModified(source.getModified());
		return target;
	}

}
