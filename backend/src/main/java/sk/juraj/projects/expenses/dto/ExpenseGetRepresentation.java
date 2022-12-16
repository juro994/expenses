package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableExpenseGetRepresentation.Builder.class)
@JsonSerialize(as = ImmutableExpenseGetRepresentation.class)
public interface ExpenseGetRepresentation {

    public String getName();
	
	public BigDecimal getAmount();
	
	public LocalDateTime getModified();
    
}
