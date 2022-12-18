package sk.juraj.projects.expenses.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.ImmutableIncomeGetDTO;
import sk.juraj.projects.expenses.dto.IncomeCreateDTO;
import sk.juraj.projects.expenses.dto.IncomeGetDTO;
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
	public IncomeGetDTO addIncome(final IncomeCreateDTO incomeCreateRepresentation) {
		final User user = userService.getCurrentUser();

		final Income incomeSaved = incomeRepository.save(mapIncomeCreateRepresentationToIncome(incomeCreateRepresentation, user));

		return mapIncomeToIncomeGetRepresentation(incomeSaved);
	}

	@Transactional(readOnly = true)
	public List<IncomeGetDTO> getAllIncomeItemsWithForDate(Integer year, Integer month) {
		final User user = userService.getCurrentUser();
		
		final List<Income> allIncomeItemsInYearAndMonth = incomeRepository.findByModifiedInYearAndMonth(year, month, user.getUsername());

		return allIncomeItemsInYearAndMonth.stream().map(this::mapIncomeToIncomeGetRepresentation).collect(Collectors.toList());
	}

	private Income mapIncomeCreateRepresentationToIncome(final IncomeCreateDTO incomeDTO, final User user) {
		final Income income = new Income();
		income.setTitle(incomeDTO.getName());
		income.setAmount(incomeDTO.getAmount());
		income.setUser(user);
		return income;
	}

	private IncomeGetDTO mapIncomeToIncomeGetRepresentation(final Income income) {
		return ImmutableIncomeGetDTO.builder()
		.name(income.getTitle())
		.amount(income.getAmount())
		.modified(income.getModified())
		.build();
	}
	

}
