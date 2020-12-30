package br.com.pokedex.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


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
		  servers = @Server(url = "http://localhost:8080/v1"))
		  @SecurityScheme(
			  name = "BasicAuth",
			  type = SecuritySchemeType.HTTP,
			  in = SecuritySchemeIn.DEFAULT,
			  flows = @OAuthFlows(
				implicit = @OAuthFlow(
				   scopes = {
					  @OAuthScope(name = "read", description = "read access"),
					  @OAuthScope(name = "write", description = "Write access")
				   }
			  )
	  
		  )
		)
public class Swagger {

}
