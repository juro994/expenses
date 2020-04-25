package sk.juraj.projects.expenses.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sk.juraj.projects.expenses.dto.CategoryDTO;

@ExtendWith(MockitoExtension.class)
class ToCategoryConverterTest {
	
	@Mock
	private CategoryDTO categoryDTO;
	
	private ToCategoryConverter toCategoryConverter;
	
	private static final String CATEGORY_NAME = "Test Category";
	
	@BeforeEach
	public void setup() {
		toCategoryConverter = new ToCategoryConverter();
		
		when(categoryDTO.getName()).thenReturn(CATEGORY_NAME);
	}

	@Test
	public void testConvertCategoryDTO() {
		var category = toCategoryConverter.convert(categoryDTO);
		
		assertEquals(CATEGORY_NAME, category.getName());
	}

}
