package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableMonthlyBudgetGetDTO.Builder.class)
@JsonSerialize(as = ImmutableMonthlyBudgetGetDTO.class)
public interface MonthlyBudgetGetDTO {

    public List<CategoryGetDTO> categories();

    public BigDecimal totalSpent();

    public BigDecimal budgetForTheMonth();

    public List<IncomeGetDTO> incomeItems();
    
}
