package sk.juraj.projects.expenses.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sk.juraj.projects.expenses.dto.UserDTO;
import sk.juraj.projects.expenses.entity.User;

public class ToUserConverter extends AbstractConverter<UserDTO, User> {
	
	private BCryptPasswordEncoder passwordEncoder;
	
	public ToUserConverter() {
		super();
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	protected User convert(UserDTO source) {
		var user = new User();
		user.setFirstName(source.getFirstName());
		user.setLastName(source.getLastName());
		user.setPassword(this.passwordEncoder.encode(source.getRawPassword()));
		return null;
	}

}
