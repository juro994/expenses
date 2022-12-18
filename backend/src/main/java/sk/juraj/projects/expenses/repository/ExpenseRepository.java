package sk.juraj.projects.expenses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sk.juraj.projects.expenses.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	@Query("select e from Expense e where year(e.modified) = ?1 and month(e.modified) = ?2 and e.user.username = ?3")
	List<Expense> getByModifiedInYearAndMonth(Integer year, Integer month, String username);

}
