package sk.juraj.projects.expenses;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

import sk.juraj.projects.expenses.controller.CategoryController;
import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.dto.CategoryListDTO;
import sk.juraj.projects.expenses.entity.Category;

class CategoryIT extends BaseIT {

	@Test
	public void checkEmptyCategories() throws Exception {
		var categoryA = new CategoryDTO("Health");
		var categoryB = new CategoryDTO("Groceries");
		var categoryC = new CategoryDTO("Home");
		
		var categories = List.of(categoryA, categoryB, categoryC);
		for(var category : categories) {
			this.restTemplate.postForEntity(getUrlBase(), category, Category.class);
		}
		
		var categoryNamesReturnedFromApi = this.restTemplate.getForObject(getUrlBase(), CategoryListDTO.class).getEntityListHolder().stream().map(category -> category.getName()).collect(Collectors.toList());
		System.out.println(categoryNamesReturnedFromApi);
		assertTrue(categoryNamesReturnedFromApi.containsAll(List.of("Health", "Groceries", "Home")));
	}

	@Override
	protected String getApiPostfix() {
		return CategoryController.API_PATH;
	}
	
	
}
