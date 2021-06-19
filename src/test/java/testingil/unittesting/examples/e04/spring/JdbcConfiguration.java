package testingil.unittesting.examples.e04.spring;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcConfiguration {
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource ) {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.driverClassName("org.h2.Driver")
				.url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
				.username("sa")
				.password("sa")
				.build();
	}
	
	@Bean
	public ItemRepository itemRepository() {
		return new ItemRepository();
	}
	
}
