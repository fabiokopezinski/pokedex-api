package br.com.pokedex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
		  info = @Info(
		  title = "Api de Pokemons",
		  description = "" +
		    "Documentção da api ",
		  contact = @Contact(
		    name = "Fábio Kopezinski e Marcelo Campos" ,  
			email = "fabiokopezinski@gmail.com e marcelo.home19@gmail.com"			
		  ),
		  license = @License(
		    name = "MIT Licence", 
		    url = "https://github.com/fabiokopezinski/pokedex-api/blob/main/LICENSE")),
		  servers = @Server(url = "http://localhost:8081/v1"))
public class Swagger {

 @Bean
 public OpenAPI customOpenAPI() {
   return new OpenAPI()
          .components(new Components()
          .addSecuritySchemes("bearerAuth",
          new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
}
	
}
