package sk.juraj.projects.expenses.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.User;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Optional<Category> findByName(String name);
	
	List<Category> findByUser(User user);

	
}
