package sk.juraj.projects.expenses.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.ExpenseCreateRepresentation;
import sk.juraj.projects.expenses.dto.ExpenseGetRepresentation;
import sk.juraj.projects.expenses.service.ExpenseAddingService;

@RestController
@RequestMapping(ExpenseController.API_PATH)
public class ExpenseController {

	public static final String API_PATH = "/expenses";

	@Autowired
	private ExpenseAddingService expenseAddingService;

	@PostMapping(consumes = "application/json")
	public ResponseEntity<ExpenseGetRepresentation> postExpense(
			@Valid @RequestBody ExpenseCreateRepresentation expenseDTO) {
		final ExpenseGetRepresentation expenseSaved = expenseAddingService.addExpense(expenseDTO);
		return ResponseEntity.ok(expenseSaved);
	}

}
