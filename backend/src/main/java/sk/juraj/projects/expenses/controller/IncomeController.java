package sk.juraj.projects.expenses.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.IncomeCreateRepresentation;
import sk.juraj.projects.expenses.dto.IncomeGetRepresentation;
import sk.juraj.projects.expenses.service.IncomeService;

@RestController
@RequestMapping(IncomeController.API_PATH)
public class IncomeController {

    public static final String API_PATH = "/income";

    @Autowired
	private IncomeService incomeService;

	@PostMapping(consumes = "application/json")
	public ResponseEntity<IncomeGetRepresentation> postNewIncome(
			@Valid @RequestBody IncomeCreateRepresentation incomeDTO) {
		final IncomeGetRepresentation incomeSaved = incomeService.addIncome(incomeDTO);
		return ResponseEntity.ok(incomeSaved);
	}
    
}
