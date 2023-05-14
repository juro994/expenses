package sk.juraj.projects.expenses.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import sk.juraj.projects.expenses.converter.ToCategoryConverter;
import sk.juraj.projects.expenses.converter.ToCategoryGetDTOConverter;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
	
	@Mock
	private CategoryRepository categoryRepository;

	@Mock
	private UserService userService;

	@Spy
	private ModelMapper modelMapper = getModelMapper();
	
	@InjectMocks
	private CategoryService categoryService;

	private ModelMapper getModelMapper() {
 		var modelMapper = new ModelMapper();
 		addConverters(modelMapper);
 		return modelMapper;
 	}

 	private void addConverters(ModelMapper modelMapper) {
 		modelMapper.addConverter(new ToCategoryGetDTOConverter());
		modelMapper.addConverter(new ToCategoryConverter());
 	}

	@Test
	void getAllCategoriesWithExpensesForDate() {
		// given
		final int year = 2022;
		final int month = 12;
		final String username = "adminowski";

		final User user = mock(User.class);
		when(user.getUsername())
		.thenReturn(username);

		when(this.userService.getCurrentUser())
		.thenReturn(user);

		final Category foodCategory = new Category();
		foodCategory.setName("food");
		foodCategory.setId(1L);
		foodCategory.setMonthlyBudget(BigDecimal.valueOf(1000));
		foodCategory.setColorCode("ffffff");
		foodCategory.setUser(user);
		foodCategory.setExpenses(List.of());

		final List<Category> categories = List.of(
			foodCategory
		);
		when(this.categoryRepository.getByModifiedInYearAndMonth(year, month, username))
		.thenReturn(categories);

		// when
		var categoriesWithExpenses = this.categoryService.getAllCategoriesWithExpensesForDate(year, month);
		
		// then
		assertEquals(1, categoriesWithExpenses.size());
		assertEquals("food", categories.get(0).getName());
	}

	@Test
	void getAllCategoriesWithExpensesForDate_whenUserHasNoCategories() {
		// given
		final int year = 2022;
		final int month = 12;
		final String username = "adminowski";

		final User user = mock(User.class);
		when(user.getUsername())
		.thenReturn(username);

		when(this.userService.getCurrentUser())
		.thenReturn(user);

		final List<Category> categories = List.of();
		when(this.categoryRepository.getByModifiedInYearAndMonth(year, month, username))
		.thenReturn(categories);

		// when
		var categoriesWithExpenses = this.categoryService.getAllCategoriesWithExpensesForDate(year, month);
		
		// then
		assertEquals(0, categoriesWithExpenses.size());
	}

}
