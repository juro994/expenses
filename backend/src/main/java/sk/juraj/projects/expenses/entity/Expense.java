package sk.juraj.projects.expenses.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense {

	@Id
	@GeneratedValue
	private Long id;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime modified = LocalDateTime.now();

	@Column(nullable = false, unique = false)
	private BigDecimal amount;

	@Column(length = 128, nullable = false, unique = false)
	private String title;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	public Expense() {

	}

	public Expense(BigDecimal amount, String title, Category category) {
		super();
		this.amount = amount;
		this.title = title;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@PreUpdate
	public void setLastUpdate() {
		this.modified = LocalDateTime.now();
	}

}
