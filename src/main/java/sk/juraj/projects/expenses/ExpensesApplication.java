package sk.juraj.projects.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.repository.CategoryRepository;

@SpringBootApplication
public class ExpensesApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		var category1 = new Category("Entertainment");
//		var category2 = new Category("Health");
//		var category3 = new Category("Going out");
//		
//		categoryRepository.save(category1);
//		categoryRepository.save(category2);
//		categoryRepository.save(category3);
//		
//		System.out.println(categoryRepository.findAll());
	}

}
