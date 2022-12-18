package sk.juraj.projects.expenses.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.UserCreateDTO;
import sk.juraj.projects.expenses.service.UserService;

@RestController
@RequestMapping(UserController.API_PATH)
public class UserController {
	
	public static final String API_PATH = "/register";
	
	@Autowired
	private UserService userService;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> postUser(@Valid @RequestBody UserCreateDTO userDTO) {
		final Long savedUserId = userService.saveUser(userDTO);
		return ResponseEntity.ok(savedUserId);
	}

}
