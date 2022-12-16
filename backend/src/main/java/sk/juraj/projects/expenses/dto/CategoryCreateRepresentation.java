package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableCategoryCreateRepresentation.Builder.class)
@JsonSerialize(as = ImmutableCategoryCreateRepresentation.class)
public interface CategoryCreateRepresentation {

    public String getName();

    public Optional<String> getColorCode();

    public BigDecimal getMonthlyBudget();

    public List<ExpenseGetRepresentation> getExpenses();
    
}
