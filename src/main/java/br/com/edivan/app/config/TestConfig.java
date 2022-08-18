package br.com.edivan.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.edivan.app.service.DbService;

@Configuration
@Profile("dev")
public class TestConfig {
	
	@Autowired
	private DbService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@Bean
	public Boolean instanciaDB() {
		if(ddl.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;
	}

}
