package sk.juraj.projects.expenses.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.User;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select DISTINCT(c) from Category c LEFT JOIN c.expenses e where ((e.modified is null) or (year(e.modified) = ?1 and month(e.modified) = ?2)) and c.user.username = ?3")
	List<Category> getByModifiedInYearAndMonth(Integer year, Integer month, String username);
	
	Optional<Category> findByName(String name);
	
	List<Category> findByUser(User user);

	
}
