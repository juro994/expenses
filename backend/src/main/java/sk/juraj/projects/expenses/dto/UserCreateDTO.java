package sk.juraj.projects.expenses.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = ImmutableUserCreateDTO.Builder.class)
@JsonSerialize(as = ImmutableUserCreateDTO.class)
public interface UserCreateDTO {

	public String firstName();
	
	public String lastName();
	
	public String username();
	
	public String rawPassword();
    
}
