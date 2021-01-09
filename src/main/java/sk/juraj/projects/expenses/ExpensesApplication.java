package sk.juraj.projects.expenses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpensesApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
