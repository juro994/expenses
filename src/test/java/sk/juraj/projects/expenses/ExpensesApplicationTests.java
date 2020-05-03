package sk.juraj.projects.expenses;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sk.juraj.projects.expenses.controller.CategoryController;

@SpringBootTest
class ExpensesApplicationTests {
	
	@Autowired
	private CategoryController categoryController;

	@Test
	void contextLoads() {
		assertNotNull(categoryController);
	}

}
