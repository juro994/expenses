package sk.juraj.projects.expenses.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sk.juraj.projects.expenses.entity.Category;

@ExtendWith(MockitoExtension.class)
public class ToCategoryDTOConverterTest {

	@Mock
	private Category category;

	private ToCategoryDTOConverter toCategoryDTOConverter;

	private static final String CATEGORY_NAME = "Test Category";

	@BeforeEach
	public void setup() {
		toCategoryDTOConverter = new ToCategoryDTOConverter();

		when(category.getName()).thenReturn(CATEGORY_NAME);
	}

	@Test
	void testConvertCategory() {
		var categoryDTO = toCategoryDTOConverter.convert(category);

		assertEquals(CATEGORY_NAME, categoryDTO.getName());
	}

}
