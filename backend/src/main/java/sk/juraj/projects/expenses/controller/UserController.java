package sk.juraj.projects.expenses.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.ExpenseDTO;
import sk.juraj.projects.expenses.dto.UserDTO;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.service.UserService;

@RestController
@RequestMapping(UserController.API_PATH)
public class UserController {
	
	public static final String API_PATH = "/users";
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> postUser(@Valid @RequestBody UserDTO userDTO) {
		var userToSave = modelMapper.map(userDTO, User.class);
		var savedUser = userService.saveUser(userToSave);
		return ResponseEntity.ok(savedUser.getId());
	}

}