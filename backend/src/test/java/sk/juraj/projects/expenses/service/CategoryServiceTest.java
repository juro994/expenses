package sk.juraj.projects.expenses.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.CategoryRepository;
import sk.juraj.projects.expenses.repository.ExpenseRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
	
	@Mock
	private CategoryRepository categoryRepository;

	@Mock
	private ExpenseRepository expenseRepository;

	@Mock
	private UserService userService;
	
	@InjectMocks
	private CategoryService categoryService;

	@Test
	void testGetAllCategoriesWithExpenses_whenUserHasNoCategories() {
		// given
		final User user = mock(User.class);
		when(this.userService.getCurrentUser())
		.thenReturn(user);

		final List<Category> categories = List.of();
		when(this.categoryRepository.findByUser(user))
		.thenReturn(categories);

		// when
		var categoriesWithExpenses = this.categoryService.getAllCategoriesWithExpensesForDate(2022, 12);
		
		// then
		assertEquals(0, categoriesWithExpenses.size());
		verify(this.expenseRepository, never()).findByModifiedInYearAndMonth(any(), any(), any());
	}

	// @Test
	// void testGetAllCategoriesWithExpenses_whenUserHasCategoriesButNoExpenses() {
	// 	// given
	// 	final Authentication auth = mock(Authentication.class);
	// 	when(auth.getName()).thenReturn("test-user");
	// 	SecurityContextHolder.getContext().setAuthentication(auth);

	// 	final User user = mock(User.class);
	// 	when(this.userRepository.findByUsername(auth.getName()))
	// 	.thenReturn(user);

	// 	final Category category1 = mock(Category.class);
	// 	final Category category2 = mock(Category.class);

	// 	final List<Category> categories = List.of(category1, category2);
	// 	when(this.categoryRepository.findByUser(user))
	// 	.thenReturn(categories);

	// 	// when
	// 	var categoriesWithExpenses = this.categoryService.getAllCategoriesWithExpensesForDate(2022, 12);
		
	// 	// then
	// 	assertEquals(2, categoriesWithExpenses.size());
	// 	verify(this.expenseRepository, times(2)).findByModifiedInYearAndMonth(eq(2022), eq(12), eq("test-user"));
	// }
	
	// @Test
	// void testGetAllCategoriesIfCategoryPresent() {
	// 	when(categoryRepository.findAll()).thenReturn(List.of(new Category(CATEGORY_NAME, "#ffffff")));
		
	// 	var categories = this.categoryService.getAllCategoriesWithExpensesForDate(2022, 12);
		
	// 	assertEquals(1, categories.size());
	// 	verify(categoryRepository).findAll();
	// }

	// @Test
	// void testAddNewCategory() {
	// 	var category = new Category(CATEGORY_NAME);
		
	// 	this.categoryService.addNewCategory(category);
		
	// 	verify(categoryRepository).save(category);
	// }
	
	// @Test
	// void testAddNewCategoryIfNull() {
	// 	assertThrows(IllegalArgumentException.class, () -> {
	// 		var category = (Category) null;
			
	// 		this.categoryService.addNewCategory(category);
	// 	});
	// }
	
	// @Test
	// void testAddNewCategoryIfCategoryWithSameNameAlreadyExists() {
	// 	assertThrows(IllegalArgumentException.class, () -> {
	// 		var category = new Category(CATEGORY_NAME);
	// 		when(categoryRepository.findByName(CATEGORY_NAME)).thenReturn(Optional.of(category));
			
	// 		this.categoryService.addNewCategory(category);
	// 	});
	// }

}
