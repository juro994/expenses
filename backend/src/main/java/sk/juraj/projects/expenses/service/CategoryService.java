package sk.juraj.projects.expenses.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.dto.ExpenseDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.repository.CategoryRepository;
import sk.juraj.projects.expenses.repository.ExpenseRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<CategoryDTO> getAllCategories() {
		return categoryRepository.findAll().stream().map(c -> modelMapper.map(c, CategoryDTO.class)).collect(Collectors.toList());
	}
	
	public List<CategoryDTO> getAllCategoriesWithExpensesForDate(Integer year, Integer month) {
		final var allCategories = categoryRepository.findAll();
		final var allExpensesInYearAndMonth = expenseRepository.findByModifiedInYearAndMonth(year, month);
		
		
		final Map<Category, List<Expense>> expensesByCategory = allExpensesInYearAndMonth.stream().collect(Collectors.groupingBy(Expense::getCategory));
		
		final List<CategoryDTO> allCategoryDTOs = allCategories.stream().map(c -> {
			return modelMapper.map(c, CategoryDTO.class);
		}).collect(Collectors.toList());
		
		expensesByCategory.entrySet().stream().forEach(entry -> {
			var matchedCategoryDTO = allCategoryDTOs.stream().filter(c -> c.getId() == entry.getKey().getId()).findFirst();
			var expenseDTOs = entry.getValue().stream().map(e -> modelMapper.map(e, ExpenseDTO.class)).collect(Collectors.toList());
			matchedCategoryDTO.get().setExpenses(expenseDTOs);
		});
		
		return allCategoryDTOs;
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
//		existingCategory.getExpenses().add(expense);
		return categoryRepository.save(existingCategory);
	}
	
}
