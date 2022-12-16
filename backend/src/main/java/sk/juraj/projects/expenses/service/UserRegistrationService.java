package sk.juraj.projects.expenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sk.juraj.projects.expenses.config.AppUserDetails;
import sk.juraj.projects.expenses.dto.UserCreateRepresentation;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.UserRepository;

@Service
public class UserRegistrationService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Long saveUser(final UserCreateRepresentation userDTO) {
		final User userToSave = mapUserCreateRepresentationToUser(userDTO);
		return userRepository.save(userToSave).getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AppUserDetails(user);
	}
	
	private User mapUserCreateRepresentationToUser(final UserCreateRepresentation userDTO) {
		final User user = new User();
		user.setUsername(userDTO.username());
		user.setFirstName(userDTO.firstName());
		user.setLastName(userDTO.lastName());
		user.setPassword(this.bCryptPasswordEncoder.encode(userDTO.rawPassword()));
		return user;
	}
	

}
