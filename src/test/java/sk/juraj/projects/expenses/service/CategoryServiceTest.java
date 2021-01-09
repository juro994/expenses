package sk.juraj.projects.expenses.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@InjectMocks
	private CategoryService categoryService;
	
	private static final String CATEGORY_NAME = "Test Category";

	@Test
	void testGetAllCategoriesWhenEmpty() {
		var categories = this.categoryService.getAllCategories();
		
		assertEquals(0, categories.size());
		verify(categoryRepository).findAll();
	}
	
	@Test
	void testGetAllCategoriesIfCategoryPresent() {
		when(categoryRepository.findAll()).thenReturn(List.of(new Category(CATEGORY_NAME)));
		
		var categories = this.categoryService.getAllCategories();
		
		assertEquals(1, categories.size());
		verify(categoryRepository).findAll();
	}

	@Test
	void testAddNewCategory() {
		var category = new Category(CATEGORY_NAME);
		
		this.categoryService.addNewCategory(category);
		
		verify(categoryRepository).save(category);
	}
	
	@Test
	void testAddNewCategoryIfNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			var category = (Category) null;
			
			this.categoryService.addNewCategory(category);
		});
	}
	
	@Test
	void testAddNewCategoryIfCategoryWithSameNameAlreadyExists() {
		assertThrows(IllegalArgumentException.class, () -> {
			var category = new Category(CATEGORY_NAME);
			when(categoryRepository.findByName(CATEGORY_NAME)).thenReturn(Optional.of(category));
			
			this.categoryService.addNewCategory(category);
		});
	}

}
