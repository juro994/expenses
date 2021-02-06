package sk.juraj.projects.expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category addNewCategory(Category category) {
		if(category == null) {
			throw new IllegalArgumentException("Cannot save null category");
		}
		var existingCategory = categoryRepository.findByName(category.getName());
		if(existingCategory.isPresent()) {
			throw new IllegalArgumentException("Category with name " + category.getName() + " already exists");
		}
		return categoryRepository.save(category);
	}

	public Category addExpenseToCategory(Long categoryId, Expense expense) {
		if(categoryId == null) {
			throw new IllegalArgumentException("Cannot add expense to category with id null");
		}
		var category = categoryRepository.findById(categoryId);
		if(category.isEmpty()) {
			throw new IllegalArgumentException("Category with id " + categoryId + " doesn't exist");
		}
		var existingCategory = category.get();
		expense.setCategory(existingCategory);
		existingCategory.getExpenses().add(expense);
		return categoryRepository.save(existingCategory);
	}
	
}
