package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableIncomeGetDTO.Builder.class)
@JsonSerialize(as = ImmutableIncomeGetDTO.class)
public interface IncomeGetDTO {

    public String getName();
	
	public BigDecimal getAmount();
	
	public LocalDateTime getModified();
    
}
