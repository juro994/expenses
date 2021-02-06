package sk.juraj.projects.expenses.converter;

import org.modelmapper.AbstractConverter;

import sk.juraj.projects.expenses.dto.ExpenseDTO;
import sk.juraj.projects.expenses.entity.Expense;

public class ToExpenseConverter extends AbstractConverter<ExpenseDTO, Expense>{

	@Override
	protected Expense convert(ExpenseDTO source) {
		var expense = new Expense();
		expense.setTitle(source.getName());
		expense.setAmount(source.getAmount());
		return expense;
	}

}
