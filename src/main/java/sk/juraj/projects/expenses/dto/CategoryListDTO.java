package sk.juraj.projects.expenses.dto;

import java.util.List;

public class CategoryListDTO extends EntityListDTO<CategoryDTO> {
	
	public CategoryListDTO() {
		super();
	}
	
	public CategoryListDTO(List<CategoryDTO> categories) {
		super(categories);
	}
	
	public static CategoryListDTO of(List<CategoryDTO> categories) {
		return new CategoryListDTO(categories);
	}
	

}
