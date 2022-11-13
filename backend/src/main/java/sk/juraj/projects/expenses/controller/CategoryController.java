package sk.juraj.projects.expenses.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.expenses.dto.CategoryDTO;
import sk.juraj.projects.expenses.dto.ExpenseDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;
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
	@Deprecated
	public ResponseEntity<List<CategoryDTO>> getCategoriesWithExpensesFromDate(@RequestParam Optional<Integer> year, @RequestParam Optional<Integer> month) {
		//TODO validate month and year
		var categoryDTOs = (List<CategoryDTO>) null;
		if(year.isPresent() && month.isPresent()) {
			categoryDTOs = categoryService.getAllCategoriesWithExpensesForDate(year.get(), month.get());
		} else {
			categoryDTOs = categoryService.getAllCategories();
		}
		
		return ResponseEntity.ok(categoryDTOs);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<CategoryDTO> postCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		var categoryToSave = modelMapper.map(categoryDTO, Category.class);
		var savedCategory = categoryService.addNewCategory(categoryToSave);
		var savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
		return ResponseEntity.ok(savedCategoryDTO);
	}
	
	@PostMapping(value = "/{categoryId}/expenses", consumes = "application/json")
	public ResponseEntity<CategoryDTO> postExpenseToCategory(@PathVariable Long categoryId, @Valid @RequestBody ExpenseDTO expenseDTO) {
		var expenseToSave = modelMapper.map(expenseDTO, Expense.class);
		var savedCategory = categoryService.addExpenseToCategory(categoryId, expenseToSave);
		var savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
		return ResponseEntity.ok(savedCategoryDTO);
	}
	
}
