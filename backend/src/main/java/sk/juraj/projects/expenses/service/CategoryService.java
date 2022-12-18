package sk.juraj.projects.expenses.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.CategoryCreateDTO;
import sk.juraj.projects.expenses.dto.CategoryGetDTO;
import sk.juraj.projects.expenses.dto.ExpenseGetDTO;
import sk.juraj.projects.expenses.dto.ImmutableCategoryGetDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.CategoryRepository;

@Service
public class CategoryService {

	private static final String DEFAULT_CATEGORY_COLOR_CODE = "#ffffff";

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ExpenseRetrievalService expenseRetrievalService;
	
	@Autowired
	private UserService userService;
	
	@Transactional(readOnly = true)
	public List<CategoryGetDTO> getAllCategoriesWithExpensesForDate(final Integer year, final Integer month) {
		final User user = userService.getCurrentUser();
		
		final List<Category> allCategories = categoryRepository.findByUser(user);

		if(allCategories.isEmpty()) {
			return List.of();
		}

		final List<ExpenseGetDTO> allExpensesInYearAndMonth = expenseRetrievalService.getExpensesByYearAndMonth(year, month, user);

		return allCategories.stream().map(category -> {
			List<ExpenseGetDTO> allExpensesOfCategory = allExpensesInYearAndMonth.stream()
			.filter(e -> category.getId().equals(e.categoryId()))
			.collect(Collectors.toList());

			return this.mapCategoryToCategoryGetDTO(category, allExpensesOfCategory);
		}).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Category getCategoryEntityById(Long categoryId) {
		return this.categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException(String.format("Category with id %s doesn't exist", categoryId)));
	}

	@Transactional
	public CategoryGetDTO addNewCategory(CategoryCreateDTO categoryDTO) {
		final Category category = mapCategoryDTOtoCategory(categoryDTO);
		if(category == null) {
			throw new IllegalArgumentException("Cannot save null category");
		}
		var existingCategory = categoryRepository.findByName(category.getName());
		if(existingCategory.isPresent()) {
			throw new IllegalArgumentException("Category with name " + category.getName() + " already exists");
		}
		
		User user = userService.getCurrentUser();
		category.setUser(user);
		
		return mapCategoryToCategoryDTO(categoryRepository.save(category)) ;
	}

	private CategoryGetDTO mapCategoryToCategoryGetDTO(final Category category, final List<ExpenseGetDTO> expenses) {
		return ImmutableCategoryGetDTO.builder()
			.id(category.getId())
			.name(category.getName())
			.monthlyBudget(category.getMonthlyBudget())
			.colorCode(Optional.ofNullable(category.getColorCode()))
			.expenses(expenses)
			.build();
	}

	private Category mapCategoryDTOtoCategory(final CategoryCreateDTO categoryDTO) {
		Category category = new Category();
		var trimmedName = categoryDTO.getName().trim();
		category.setName(trimmedName);
		category.setMonthlyBudget(categoryDTO.getMonthlyBudget());
		category.setColorCode(categoryDTO.getColorCode().orElse(DEFAULT_CATEGORY_COLOR_CODE));
		return category;
	}

	private CategoryGetDTO mapCategoryToCategoryDTO(final Category category) {
		var categoryDTO = ImmutableCategoryGetDTO.builder()
		.id(category.getId())
		.name(category.getName())
		.monthlyBudget(category.getMonthlyBudget())
		.colorCode(category.getColorCode())
		.build();

		return categoryDTO;
	}
	
}
