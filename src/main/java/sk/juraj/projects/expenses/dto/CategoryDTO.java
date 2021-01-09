package sk.juraj.projects.expenses.dto;

import javax.validation.constraints.NotBlank;

public class CategoryDTO {
	
	@NotBlank(message = "Category name is mandatory")
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
