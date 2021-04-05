package sk.juraj.projects.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.service.ExpenseService;

@RestController
@RequestMapping(ExpenseController.API_PATH)
public class ExpenseController {
	
	public static final String API_PATH = "/expenses";
	
	@Autowired
	private ExpenseService expenseService;

}
