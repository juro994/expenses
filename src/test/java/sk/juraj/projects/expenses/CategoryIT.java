package sk.juraj.projects.expenses;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import sk.juraj.projects.expenses.controller.CategoryController;
import sk.juraj.projects.expenses.dto.CategoryDTO;
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
		
		assertThat(this.restTemplate.getForObject(getUrlBase(),
				String.class)).contains("[]");
	}

	@Override
	protected String getApiPostfix() {
		return CategoryController.API_PATH;
	}
	
	
}
