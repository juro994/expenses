package sk.juraj.projects.expenses.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length=30, nullable=false, unique=true)
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Expense> expenses;
	
	private String colorCode;

	public Category() {

	}
	
	public Category(String name) {
		this.name = name;
	}

	public Category(String name, String colorCode) {
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

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", expenses=" + expenses + ", colorCode=" + colorCode + "]";
	}

	
	

}
