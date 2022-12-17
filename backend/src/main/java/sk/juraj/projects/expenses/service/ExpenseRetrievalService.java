package sk.juraj.projects.expenses.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.ExpenseGetRepresentation;
import sk.juraj.projects.expenses.dto.ImmutableExpenseGetRepresentation;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.ExpenseRepository;

@Service
public class ExpenseRetrievalService {
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Transactional(readOnly = true)
	public List<ExpenseGetRepresentation> findByModifiedInYearAndMonth(final Integer year, final Integer month, final User user) {
		return expenseRepository.findByModifiedInYearAndMonth(year, month, user.getUsername()).stream().map(this::mapExpenseToExpenseDTO).collect(Collectors.toList());
	}

	private ExpenseGetRepresentation mapExpenseToExpenseDTO(final Expense expense) {
		return ImmutableExpenseGetRepresentation.builder()
			.amount(expense.getAmount())
			.modified(expense.getModified())
			.name(expense.getTitle())
			.categoryId(expense.getCategory().getId())
			.build();
	}

}
