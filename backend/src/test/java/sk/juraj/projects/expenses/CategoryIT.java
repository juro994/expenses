package sk.juraj.projects.expenses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import sk.juraj.projects.expenses.controller.CategoryController;
import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.dto.CategoryListDTO;

class CategoryIT extends BaseIT {

	@Test
	public void addNewCategories() {
		var categoryA = new CategoryDTO("Health");
		var categoryB = new CategoryDTO("Groceries");
		var categoryC = new CategoryDTO("Home");
		
		var categories = List.of(categoryA, categoryB, categoryC);
		for(var category : categories) {
			this.restTemplate.postForObject(getUrlBase(), category, CategoryDTO.class);
		}
		
		var categoryNamesReturnedFromApi = this.restTemplate.exchange(getUrlBase(), HttpMethod.GET, null, new ParameterizedTypeReference<List<CategoryDTO>>() {}).getBody().stream().map(category -> category.getName()).collect(Collectors.toList());
		assertTrue(categoryNamesReturnedFromApi.containsAll(List.of("Health", "Groceries", "Home")));
	}
	
	@Test
	public void addCategoryWithEmptyName() {
		var category = new CategoryDTO("");
		
		var response = this.restTemplate.postForObject(getUrlBase(), category, Map.class);
		assertEquals("Category name is mandatory", response.get("name"));
	}

	@Override
	protected String getApiPostfix() {
		return CategoryController.API_PATH;
	}
	
	
}