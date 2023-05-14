package sk.juraj.projects.expenses.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.juraj.projects.expenses.dto.CategoryCreateDTO;
import sk.juraj.projects.expenses.dto.CategoryGetDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
	public List<CategoryGetDTO> getAllCategoriesWithExpensesForDate(final Integer year, final Integer month) {
		final User user = userService.getCurrentUser();
		
		final List<Category> allCategories = categoryRepository.getByModifiedInYearAndMonth(year, month, user.getUsername());

		if(allCategories.isEmpty()) {
			return List.of();
		}

		return allCategories.stream().map(category -> {
			return this.modelMapper.map(category, CategoryGetDTO.class);
		}).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Category getCategoryEntityById(Long categoryId) {
		return this.categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException(String.format("Category with id %s doesn't exist", categoryId)));
	}

	@Transactional
	public CategoryGetDTO addNewCategory(CategoryCreateDTO categoryDTO) {
		final Category category = this.modelMapper.map(categoryDTO, Category.class);
		if(category == null) {
			throw new IllegalArgumentException("Cannot save null category");
		}
		var existingCategory = categoryRepository.findByName(category.getName());
		if(existingCategory.isPresent()) {
			throw new IllegalArgumentException("Category with name " + category.getName() + " already exists");
		}
		
		User user = userService.getCurrentUser();
		category.setUser(user);
		
		return this.modelMapper.map(categoryRepository.save(category), CategoryGetDTO.class);
	}
	
}
