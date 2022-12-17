package sk.juraj.projects.expenses.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableUserCreateRepresentation.Builder.class)
@JsonSerialize(as = ImmutableUserCreateRepresentation.class)
public interface UserCreateRepresentation {

	public String firstName();
	
	public String lastName();
	
	public String username();
	
	public String rawPassword();
    
}
