package sk.juraj.projects.expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category addNewCategory(Category category) {
		return categoryRepository.save(category);
	}

}
