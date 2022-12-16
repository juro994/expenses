package sk.juraj.projects.expenses.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.CategoryCreateRepresentation;
import sk.juraj.projects.expenses.dto.CategoryGetRepresentation;
import sk.juraj.projects.expenses.dto.ExpenseGetRepresentation;
import sk.juraj.projects.expenses.dto.ImmutableCategoryGetRepresentation;
import sk.juraj.projects.expenses.dto.ImmutableExpenseGetRepresentation;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.CategoryRepository;
import sk.juraj.projects.expenses.repository.ExpenseRepository;
import sk.juraj.projects.expenses.repository.UserRepository;

@Service
public class CategoryService {

	private static final String DEFAULT_CATEGORY_COLOR_CODE = "#ffffff";

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<CategoryGetRepresentation> getAllCategoriesWithExpensesForDate(Integer year, Integer month) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		final User user = userRepository.findByUsername(authentication.getName());
		
		final List<Category> allCategories = categoryRepository.findByUser(user);
		final List<Expense> allExpensesInYearAndMonth = expenseRepository.findByModifiedInYearAndMonth(year, month, user.getUsername());

		return allCategories.stream().map(category -> {
			List<ExpenseGetRepresentation> allExpensesOfCategory = allExpensesInYearAndMonth.stream()
			.filter(e -> category.getId().equals(e.getCategory().getId()))
			.map(this::mapExpenseToExpenseDTO)
			.collect(Collectors.toList());

			return this.mapCategoryToCategoryGetDTO(category, allExpensesOfCategory);
		}).collect(Collectors.toList());
	}

	private ExpenseGetRepresentation mapExpenseToExpenseDTO(final Expense expense) {
		return ImmutableExpenseGetRepresentation.builder()
			.amount(expense.getAmount())
			.modified(expense.getModified())
			.name(expense.getTitle())
			.build();
	}

	private CategoryGetRepresentation mapCategoryToCategoryGetDTO(final Category category, final List<ExpenseGetRepresentation> expenses) {
		return ImmutableCategoryGetRepresentation.builder()
			.id(category.getId())
			.name(category.getName())
			.monthlyBudget(category.getMonthlyBudget())
			.colorCode(Optional.ofNullable(category.getColorCode()))
			.expenses(expenses)
			.build();
	}

	@Transactional
	public CategoryGetRepresentation addNewCategory(CategoryCreateRepresentation categoryDTO) {
		final Category category = mapCategoryDTOtoCategory(categoryDTO);
		if(category == null) {
			throw new IllegalArgumentException("Cannot save null category");
		}
		var existingCategory = categoryRepository.findByName(category.getName());
		if(existingCategory.isPresent()) {
			throw new IllegalArgumentException("Category with name " + category.getName() + " already exists");
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());
		category.setUser(user);
		
		return mapCategoryToCategoryDTO(categoryRepository.save(category)) ;
	}

	private Category mapCategoryDTOtoCategory(final CategoryCreateRepresentation categoryDTO) {
		Category category = new Category();
		var trimmedName = categoryDTO.getName().trim();
		category.setName(trimmedName);
		category.setMonthlyBudget(categoryDTO.getMonthlyBudget());
		category.setColorCode(categoryDTO.getColorCode().orElse(DEFAULT_CATEGORY_COLOR_CODE));
		return category;
	}

	private CategoryGetRepresentation mapCategoryToCategoryDTO(final Category category) {
		var categoryDTO = ImmutableCategoryGetRepresentation.builder()
		.id(category.getId())
		.name(category.getName())
		.monthlyBudget(category.getMonthlyBudget())
		.colorCode(category.getColorCode())
		.build();

		return categoryDTO;
	}
	
}
