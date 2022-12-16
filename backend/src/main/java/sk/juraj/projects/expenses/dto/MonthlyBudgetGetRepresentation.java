package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableMonthlyBudgetGetRepresentation.Builder.class)
@JsonSerialize(as = ImmutableMonthlyBudgetGetRepresentation.class)
public interface MonthlyBudgetGetRepresentation {

    public List<CategoryGetRepresentation> categories();

    public BigDecimal totalSpent();

    public BigDecimal budgetForTheMonth();

    public List<IncomeGetRepresentation> incomeItems();
    
}
