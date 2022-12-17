package sk.juraj.projects.expenses.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.ImmutableIncomeGetRepresentation;
import sk.juraj.projects.expenses.dto.IncomeCreateRepresentation;
import sk.juraj.projects.expenses.dto.IncomeGetRepresentation;
import sk.juraj.projects.expenses.entity.Income;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.IncomeRepository;

@Service
public class IncomeService {
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public IncomeGetRepresentation addIncome(final IncomeCreateRepresentation incomeCreateRepresentation) {
		final User user = userService.getCurrentUser();

		final Income incomeSaved = incomeRepository.save(mapIncomeCreateRepresentationToIncome(incomeCreateRepresentation, user));

		return mapIncomeToIncomeGetRepresentation(incomeSaved);
	}

	@Transactional(readOnly = true)
	public List<IncomeGetRepresentation> getAllIncomeItemsWithForDate(Integer year, Integer month) {
		final User user = userService.getCurrentUser();
		
		final List<Income> allIncomeItemsInYearAndMonth = incomeRepository.findByModifiedInYearAndMonth(year, month, user.getUsername());

		return allIncomeItemsInYearAndMonth.stream().map(this::mapIncomeToIncomeGetRepresentation).collect(Collectors.toList());
	}

	private Income mapIncomeCreateRepresentationToIncome(final IncomeCreateRepresentation incomeDTO, final User user) {
		final Income income = new Income();
		income.setTitle(incomeDTO.getName());
		income.setAmount(incomeDTO.getAmount());
		income.setUser(user);
		return income;
	}

	private IncomeGetRepresentation mapIncomeToIncomeGetRepresentation(final Income income) {
		return ImmutableIncomeGetRepresentation.builder()
		.name(income.getTitle())
		.amount(income.getAmount())
		.modified(income.getModified())
		.build();
	}
	

}
