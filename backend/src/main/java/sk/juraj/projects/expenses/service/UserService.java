package sk.juraj.projects.expenses.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.config.AppUserDetails;
import sk.juraj.projects.expenses.dto.UserCreateDTO;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional(readOnly = true)
	public User getCurrentUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final String username = authentication.getName();
		
		return getUserByUsername(username);
	}

	@Transactional(readOnly = true)
	public User getUserByUsername(final String username) {
		return Optional.ofNullable(userRepository.findByUsername(username))
			.orElseThrow(() -> new IllegalStateException(String.format("User %s is not present in the database", username)));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AppUserDetails(this.getUserByUsername(username));
	}

	@Transactional
	public Long saveUser(final UserCreateDTO userDTO) {
		final User userToSave = mapUserCreateRepresentationToUser(userDTO);
		return this.userRepository.save(userToSave).getId();
	}

	private User mapUserCreateRepresentationToUser(final UserCreateDTO userDTO) {
		final User user = new User();
		user.setUsername(userDTO.username());
		user.setFirstName(userDTO.firstName());
		user.setLastName(userDTO.lastName());
		user.setPassword(this.bCryptPasswordEncoder.encode(userDTO.rawPassword()));
		return user;
	}
	
}
