package sk.juraj.projects.expenses.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.dto.CategoryListDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.service.CategoryService;

@RestController
@RequestMapping(CategoryController.API_PATH)
public class CategoryController {
	
	public static final String API_PATH = "/categories";
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public CategoryListDTO getCategories() {
		var categories = categoryService.getAllCategories();
		var categoryDTOs = categories.stream().map(c -> modelMapper.map(c, CategoryDTO.class)).collect(Collectors.toList());
		return CategoryListDTO.of(categoryDTOs);
	}
	
	@PostMapping
	public CategoryDTO postCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		var categoryToSave = modelMapper.map(categoryDTO, Category.class);
		var savedCategory = categoryService.addNewCategory(categoryToSave);
		return modelMapper.map(savedCategory, CategoryDTO.class);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
}
