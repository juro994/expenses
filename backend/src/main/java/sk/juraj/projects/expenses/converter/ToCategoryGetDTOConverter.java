package sk.juraj.projects.expenses.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import sk.juraj.projects.expenses.dto.CategoryGetDTO;
import sk.juraj.projects.expenses.dto.ExpenseGetDTO;
import sk.juraj.projects.expenses.dto.ImmutableCategoryGetDTO;
import sk.juraj.projects.expenses.dto.ImmutableExpenseGetDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;

public class ToCategoryGetDTOConverter extends AbstractConverter<Category, CategoryGetDTO> {

    @Override
    protected CategoryGetDTO convert(Category source) {
        return ImmutableCategoryGetDTO.builder()
			.id(source.getId())
			.name(source.getName())
			.monthlyBudget(source.getMonthlyBudget())
			.colorCode(Optional.ofNullable(source.getColorCode()))
			.expenses(mapExpensesToExpenseGetDTOs(source.getExpenses()))
			.build();
    }
    
    private List<ExpenseGetDTO> mapExpensesToExpenseGetDTOs(final List<Expense> expenses) {
		return expenses.stream().map( expense -> {
			return ImmutableExpenseGetDTO.builder()
			.amount(expense.getAmount())
			.name(expense.getTitle())
			.modified(expense.getModified())
			.categoryId(expense.getCategory().getId())
			.build();
		}).collect(Collectors.toList());
	}
    
}
