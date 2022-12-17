package sk.juraj.projects.expenses.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableIncomeCreateRepresentation.Builder.class)
@JsonSerialize(as = ImmutableIncomeCreateRepresentation.class)
public interface IncomeCreateRepresentation {

    public String getName();
	
	public BigDecimal getAmount();

}
