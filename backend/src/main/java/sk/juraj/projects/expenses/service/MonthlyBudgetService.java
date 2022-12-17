package sk.juraj.projects.expenses.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.CategoryGetRepresentation;
import sk.juraj.projects.expenses.dto.ExpenseGetRepresentation;
import sk.juraj.projects.expenses.dto.ImmutableMonthlyBudgetGetRepresentation;
import sk.juraj.projects.expenses.dto.IncomeGetRepresentation;
import sk.juraj.projects.expenses.dto.MonthlyBudgetGetRepresentation;

@Service
public class MonthlyBudgetService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private IncomeService incomeService;

    @Transactional(readOnly = true)
    public MonthlyBudgetGetRepresentation getMonthlyBudgetOverview(Integer year, Integer month) {
        final List<CategoryGetRepresentation> allCategoriesWithExpensesForDate = categoryService.getAllCategoriesWithExpensesForDate(year, month);

        final BigDecimal totalSpentForTheMonth = allCategoriesWithExpensesForDate
        .stream()
        .map(CategoryGetRepresentation::getExpenses)
        .flatMap(Collection::stream)
        .map(ExpenseGetRepresentation::getAmount)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

        final List<IncomeGetRepresentation> incomeItems = this.incomeService.getAllIncomeItemsWithForDate(year, month);

        final BigDecimal totalBudgetForTheMonth = incomeItems
        .stream()
        .map(IncomeGetRepresentation::getAmount)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

        return ImmutableMonthlyBudgetGetRepresentation.builder()
        .categories(allCategoriesWithExpensesForDate)
        .totalSpent(totalSpentForTheMonth)
        .incomeItems(incomeItems)
        .budgetForTheMonth(totalBudgetForTheMonth)
        .build();
    }
    
}
