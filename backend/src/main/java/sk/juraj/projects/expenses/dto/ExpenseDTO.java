package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseDTO {
	
	
	private String name;
	
	private BigDecimal amount;
	
	private LocalDateTime modified;
	
	private Long categoryId;
	
	public ExpenseDTO() {
		
	}

	public ExpenseDTO(String name, BigDecimal amount) {
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	

}
