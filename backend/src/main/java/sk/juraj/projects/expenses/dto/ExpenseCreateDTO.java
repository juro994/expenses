package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.util.Optional;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableExpenseCreateDTO.Builder.class)
@JsonSerialize(as = ImmutableExpenseCreateDTO.class)
public interface ExpenseCreateDTO {

    public String getName();
	
	public BigDecimal getAmount();

	public Optional<Long> categoryId();
    
}
