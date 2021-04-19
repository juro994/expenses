package sk.juraj.projects.expenses.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sk.juraj.projects.expenses.dto.ExpenseDTO;
import sk.juraj.projects.expenses.entity.Expense;

public class ToExpenseDTOConverter extends AbstractConverter<Expense, ExpenseDTO> {

	@Override
	protected ExpenseDTO convert(Expense source) {
		var expense = new ExpenseDTO();
		expense.setName(source.getTitle());
		expense.setAmount(source.getAmount());
		expense.setModified(source.getModified());
		return expense;
	}

}
