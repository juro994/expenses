package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.util.Optional;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableExpenseCreateRepresentation.Builder.class)
@JsonSerialize(as = ImmutableExpenseCreateRepresentation.class)
public interface ExpenseCreateRepresentation {

    public String getName();
	
	public BigDecimal getAmount();

	public Optional<Long> categoryId();
    
}
