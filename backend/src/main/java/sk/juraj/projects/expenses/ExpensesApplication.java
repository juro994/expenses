package sk.juraj.projects.expenses;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.service.CategoryService;

@SpringBootApplication
public class ExpensesApplication {
	
	@Autowired
	private CategoryService service;
	
	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runnerBean() {
		return (args) -> {
			var category = new Category("Health");
			
			var expense1 = new Expense(BigDecimal.valueOf(10_000), "lieky", category);
			var expense2 = new Expense(BigDecimal.valueOf(5_000), "protein", category);
			var expense3 = new Expense(BigDecimal.valueOf(7_000), "zranenie", category);
			var expenses = Set.of(expense1, expense2, expense3);
			
			category.setExpenses(expenses);
			
			service.addNewCategory(category);
		};
	}

}
