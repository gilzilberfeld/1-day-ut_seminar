package testingil.unittesting.examples.e06.testability.modularity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class Just_adder_tests {

	@Autowired
	public AdderService calc;

	@Configuration
	static class ContextConfiguration {

		@Bean
		public AdderService calculator() {
			return new AdderService();
		}

		@Bean
		public AdderLogic adderLogic() {
			return new AdderLogic();
		}

	}

	@Test
	@DisplayName("Requires just dependencies that it needs")
	void calculator_with_many_dependencies() {
		calc.add(2);
		assertThat(calc.getResult(), is(2));
	}

}