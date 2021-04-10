package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
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
	
	@Pattern(
		    regexp = "^#[0-9A-F]{6}$", 
		    message = "Wrong color code format provided. Use hexadecimal color code with preceeding # sign"
		    ) 
	private String colorCode;
	
	private BigDecimal monthlyBudget;
	
	private List<ExpenseDTO> expenses;

	public CategoryDTO() {

	}

	public CategoryDTO(String name) {
		this.name = name;
	}
	
	public CategoryDTO(String name, String colorCode) {
		this.name = name;
		this.colorCode = colorCode;
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

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public List<ExpenseDTO> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpenseDTO> expenses) {
		this.expenses = expenses;
	}

	public BigDecimal getMonthlyBudget() {
		return monthlyBudget;
	}

	public void setMonthlyBudget(BigDecimal monthlyBudget) {
		this.monthlyBudget = monthlyBudget;
	}
	

}
