package sk.juraj.projects.expenses.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length=30, nullable=false, unique=true)
	private String name;

	private String colorCode;
	
	private BigDecimal monthlyBudget;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

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

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	

	public BigDecimal getMonthlyBudget() {
		return monthlyBudget;
	}

	public void setMonthlyBudget(BigDecimal monthlyBudget) {
		this.monthlyBudget = monthlyBudget;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", colorCode=" + colorCode
				+ ", monthlyBudget=" + monthlyBudget + "]";
	}

	

}
