package sk.juraj.projects.expenses.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.CategoryGetDTO;
import sk.juraj.projects.expenses.dto.ExpenseGetDTO;
import sk.juraj.projects.expenses.dto.ImmutableMonthlyBudgetGetDTO;
import sk.juraj.projects.expenses.dto.IncomeGetDTO;
import sk.juraj.projects.expenses.dto.MonthlyBudgetGetDTO;

@Service
public class MonthlyBudgetService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private IncomeService incomeService;

    @Transactional(readOnly = true)
    public MonthlyBudgetGetDTO getMonthlyBudgetOverview(final Integer year, final Integer month) {
        final List<CategoryGetDTO> allCategoriesWithExpensesForDate = categoryService.getAllCategoriesWithExpensesForDate(year, month);

        final BigDecimal totalSpentForTheMonth = allCategoriesWithExpensesForDate
        .stream()
        .map(CategoryGetDTO::getExpenses)
        .flatMap(Collection::stream)
        .map(ExpenseGetDTO::getAmount)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

        final List<IncomeGetDTO> incomeItems = this.incomeService.getAllIncomeItemsWithForDate(year, month);

        final BigDecimal totalBudgetForTheMonth = incomeItems
        .stream()
        .map(IncomeGetDTO::getAmount)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

        return ImmutableMonthlyBudgetGetDTO.builder()
        .categories(allCategoriesWithExpensesForDate)
        .totalSpent(totalSpentForTheMonth)
        .incomeItems(incomeItems)
        .budgetForTheMonth(totalBudgetForTheMonth)
        .build();
    }
    
}
