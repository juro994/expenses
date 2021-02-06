package sk.juraj.projects.expenses.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CategoryDTO {
	
	private Long id;
	
	@NotBlank(message = "Category name is mandatory")
	@Pattern(
		    regexp = "^[\\w\\d\\s]*$", 
		    message = "Only words and digits are accepted in Category's name"
		    ) 
	private String name;
	
	private List<ExpenseDTO> expenses;

	public CategoryDTO() {

	}

	public CategoryDTO(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExpenseDTO> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpenseDTO> expenses) {
		this.expenses = expenses;
	}

}
