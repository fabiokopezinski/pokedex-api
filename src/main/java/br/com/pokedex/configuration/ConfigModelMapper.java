package br.com.pokedex.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigModelMapper {

	@Bean
	public ModelMapper conversor() {
		return new ModelMapper();
	}
}
