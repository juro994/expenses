package sk.juraj.projects.expenses;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CategoryIT extends BaseIT {

	@Test
	public void checkEmptyCategories() throws Exception {
		assertThat(this.restTemplate.getForObject(getUrlBase(),
				String.class)).contains("deliberately failed test");
	}
	
	
}
