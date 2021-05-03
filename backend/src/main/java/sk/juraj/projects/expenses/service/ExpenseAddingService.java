package sk.juraj.projects.expenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.CategoryRepository;
import sk.juraj.projects.expenses.repository.ExpenseRepository;
import sk.juraj.projects.expenses.repository.UserRepository;

@Service
public class ExpenseAddingService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Expense addExpense(Long categoryId, Expense expense) {
		if(categoryId == null) {
			throw new IllegalArgumentException("Cannot add expense to category with id null");
		}
		var category = categoryRepository.findById(categoryId);
		if(category.isEmpty()) {
			throw new IllegalArgumentException("Category with id " + categoryId + " doesn't exist");
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());
		
		var existingCategory = category.get();
		expense.setCategory(existingCategory);
		expense.setUser(user);
		return expenseRepository.save(expense);
	}
	

}
