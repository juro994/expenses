package sk.juraj.projects.expenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.ExpenseCreateRepresentation;
import sk.juraj.projects.expenses.dto.ExpenseGetRepresentation;
import sk.juraj.projects.expenses.dto.ImmutableExpenseGetRepresentation;
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
	public ExpenseGetRepresentation addExpense(final ExpenseCreateRepresentation expenseCreateRepresentation) {
		final Long categoryId = expenseCreateRepresentation.categoryId().orElseThrow(() -> new IllegalArgumentException("Cannot add expense to category with id null"));
		final Category category = categoryService.getCategoryById(categoryId);
		
		final User user = userService.getCurrentUser();

		final Expense expenseSaved = expenseRepository.save(mapExpenseCreateRepresentationToExpense(expenseCreateRepresentation, category, user));

		return mapExpenseToExpenseGetRepresentation(expenseSaved);
	}

	private Expense mapExpenseCreateRepresentationToExpense(final ExpenseCreateRepresentation expenseDTO, final Category category, final User user) {
		final Expense expense = new Expense();
		expense.setTitle(expenseDTO.getName());
		expense.setAmount(expenseDTO.getAmount());
		expense.setCategory(category);
		expense.setUser(user);
		return expense;
	}

	private ExpenseGetRepresentation mapExpenseToExpenseGetRepresentation(final Expense expense) {
		return ImmutableExpenseGetRepresentation.builder()
		.name(expense.getTitle())
		.amount(expense.getAmount())
		.modified(expense.getModified())
		.categoryId(expense.getCategory().getId())
		.build();
	}
	

}
