package sk.juraj.projects.expenses.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.ExpenseDTO;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.service.ExpenseAddingService;

@RestController
@RequestMapping(ExpenseController.API_PATH)
public class ExpenseController {
	
	public static final String API_PATH = "/expenses";
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ExpenseAddingService expenseAddingService;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ExpenseDTO> postExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
		var expenseToSave = modelMapper.map(expenseDTO, Expense.class);
		var savedExpense = expenseAddingService.addExpense(expenseDTO.getCategoryId(), expenseToSave);
		var savedExpenseDTO = modelMapper.map(savedExpense, ExpenseDTO.class);
		return ResponseEntity.ok(savedExpenseDTO);
	}

}
