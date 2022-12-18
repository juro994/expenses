package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableExpenseGetDTO.Builder.class)
@JsonSerialize(as = ImmutableExpenseGetDTO.class)
public interface ExpenseGetDTO {

    public String getName();
	
	public BigDecimal getAmount();
	
	public LocalDateTime getModified();

	@JsonIgnore
	public Long categoryId();
    
}
