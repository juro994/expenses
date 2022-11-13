package sk.juraj.projects.expenses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpensesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runnerBean() {
		return (args) -> {
			
		};
	}

}
