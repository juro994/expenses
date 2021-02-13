package sk.juraj.projects.expenses.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.juraj.projects.expenses.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Optional<Category> findByName(String name);
	
	List<Category> findByExpensesModifiedBetween(LocalDateTime start, LocalDateTime end);

	
}
