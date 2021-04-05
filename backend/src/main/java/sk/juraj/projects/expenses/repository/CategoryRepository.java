package sk.juraj.projects.expenses.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sk.juraj.projects.expenses.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Optional<Category> findByName(String name);
	
	@Query("select distinct c from Category c join fetch c.expenses as exp where year(exp.modified) = ?1 and month(exp.modified) = ?2")
	List<Category> findByExpensesModifiedInYearAndMonth(Integer year, Integer month);

	
}
