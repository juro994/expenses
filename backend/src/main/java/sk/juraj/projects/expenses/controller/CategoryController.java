package sk.juraj.projects.expenses.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.CategoryCreateDTO;
import sk.juraj.projects.expenses.dto.CategoryGetDTO;
import sk.juraj.projects.expenses.service.CategoryService;

@RestController
@RequestMapping(CategoryController.API_PATH)
public class CategoryController {
	
	public static final String API_PATH = "/categories";
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	@Deprecated
	public ResponseEntity<List<CategoryGetDTO>> getCategoriesWithExpensesFromDate(@RequestParam Optional<Integer> year, @RequestParam Optional<Integer> month) {
		if(year.isPresent() && month.isPresent()) {
			List<CategoryGetDTO> categoryDTOs = categoryService.getAllCategoriesWithExpensesForDate(year.get(), month.get());
			return ResponseEntity.ok(categoryDTOs);
		} else {
			throw new UnsupportedOperationException("Cannot get categories without month and year");
		}
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<CategoryGetDTO> postCategory(@Valid @RequestBody CategoryCreateDTO categoryDTO) {
		var savedCategory = categoryService.addNewCategory(categoryDTO);
		return ResponseEntity.ok(savedCategory);
	}
	
}
