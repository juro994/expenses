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
			
		};
	}

}
