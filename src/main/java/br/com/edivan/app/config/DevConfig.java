package br.com.edivan.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.edivan.app.service.DbService;

@Configuration
@Profile("test")
public class DevConfig {
	
	@Autowired
	private DbService dbService;
	
	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}

}
