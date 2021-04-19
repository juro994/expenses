package sk.juraj.projects.expenses.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sk.juraj.projects.expenses.converter.ToCategoryConverter;
import sk.juraj.projects.expenses.converter.ToCategoryDTOConverter;
import sk.juraj.projects.expenses.converter.ToExpenseConverter;
import sk.juraj.projects.expenses.converter.ToExpenseDTOConverter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories("sk.juraj.projects.expenses.repository")
@EnableSwagger2
@Configuration
public class ApplicationConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		addConverters(modelMapper);
		return modelMapper;
	}
	
	private void addConverters(ModelMapper modelMapper) {
		modelMapper.addConverter(new ToCategoryConverter());
		modelMapper.addConverter(new ToCategoryDTOConverter());
		modelMapper.addConverter(new ToExpenseConverter());
		modelMapper.addConverter(new ToExpenseDTOConverter());
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080","http://localhost:8081");
			}
		};
	}
	
}
