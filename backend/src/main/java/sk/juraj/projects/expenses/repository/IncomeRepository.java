package sk.juraj.projects.expenses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sk.juraj.projects.expenses.entity.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
	
	@Query("select i from Income i where year(i.modified) = ?1 and month(i.modified) = ?2 and i.user.username = ?3")
	List<Income> findByModifiedInYearAndMonth(Integer year, Integer month, String username);

}
