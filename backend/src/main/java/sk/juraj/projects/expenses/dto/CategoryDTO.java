package sk.juraj.projects.expenses.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CategoryDTO {
	
	@NotBlank(message = "Category name is mandatory")
	@Pattern(
		    regexp = "^[\\w\\d\\s]*$", 
		    message = "Only words and digits are accepted in Category's name"
		    ) 
	private String name;

	public CategoryDTO() {

	}

	public CategoryDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
