package sk.juraj.projects.expenses.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PreUpdate;

@Entity
public class Income {

	@Id
	@GeneratedValue
	private Long id;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime modified = LocalDateTime.now();

	@Column(nullable = false, unique = false)
	private BigDecimal amount;

	@Column(length = 128, nullable = false, unique = false)
	private String title;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public Income() {

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

	@PreUpdate
	public void setLastUpdate() {
		this.modified = LocalDateTime.now();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
