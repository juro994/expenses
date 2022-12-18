package sk.juraj.projects.expenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.ExpenseCreateDTO;
import sk.juraj.projects.expenses.dto.ExpenseGetDTO;
import sk.juraj.projects.expenses.dto.ImmutableExpenseGetDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.ExpenseRepository;

@Service
public class ExpenseAddingService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserService userService;;
	
	@Autowired
	private CategoryService categoryService;
	
	@Transactional
	public ExpenseGetDTO addExpense(final ExpenseCreateDTO expenseCreateRepresentation) {
		final Long categoryId = expenseCreateRepresentation.categoryId().orElseThrow(() -> new IllegalArgumentException("Cannot add expense to category with id null"));
		final Category category = categoryService.getCategoryEntityById(categoryId);
		
		final User user = userService.getCurrentUser();

		final Expense expenseSaved = expenseRepository.save(mapExpenseCreateRepresentationToExpense(expenseCreateRepresentation, category, user));

		return mapExpenseToExpenseGetRepresentation(expenseSaved);
	}

	private Expense mapExpenseCreateRepresentationToExpense(final ExpenseCreateDTO expenseDTO, final Category category, final User user) {
		final Expense expense = new Expense();
		expense.setTitle(expenseDTO.getName());
		expense.setAmount(expenseDTO.getAmount());
		expense.setCategory(category);
		expense.setUser(user);
		return expense;
	}

	private ExpenseGetDTO mapExpenseToExpenseGetRepresentation(final Expense expense) {
		return ImmutableExpenseGetDTO.builder()
		.name(expense.getTitle())
		.amount(expense.getAmount())
		.modified(expense.getModified())
		.categoryId(expense.getCategory().getId())
		.build();
	}
	

}
