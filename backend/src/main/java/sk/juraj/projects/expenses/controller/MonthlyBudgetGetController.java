package sk.juraj.projects.expenses.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.MonthlyBudgetGetDTO;
import sk.juraj.projects.expenses.service.MonthlyBudgetService;

@RestController
@RequestMapping(MonthlyBudgetGetController.API_PATH)
public class MonthlyBudgetGetController {

    public static final String API_PATH = "/monthlybudget";

    @Autowired
    private MonthlyBudgetService monthlyBudgetService;
    
    @GetMapping
	public ResponseEntity<MonthlyBudgetGetDTO> getMonthlyBudgetOverview(@RequestParam Optional<Integer> year, @RequestParam Optional<Integer> month) {
		if(year.isPresent() && month.isPresent()) {
			final MonthlyBudgetGetDTO monthlyBudgetDTO = monthlyBudgetService.getMonthlyBudgetOverview(year.get(), month.get());
			return ResponseEntity.ok(monthlyBudgetDTO);
		} else {
			throw new UnsupportedOperationException("Cannot get monthly budget overview without month and year");
		}
	}
}
