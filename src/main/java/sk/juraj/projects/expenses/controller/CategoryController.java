package sk.juraj.projects.expenses.controller;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Category postCategory(CategoryDTO categoryDTO) {
		var category = modelMapper.map(categoryDTO, Category.class);
		return categoryService.addNewCategory(category);
	}
	
}
