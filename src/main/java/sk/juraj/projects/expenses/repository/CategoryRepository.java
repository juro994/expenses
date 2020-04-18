package sk.juraj.projects.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.juraj.projects.expenses.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
