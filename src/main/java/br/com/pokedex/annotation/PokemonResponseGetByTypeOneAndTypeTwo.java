package br.com.pokedex.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.MediaType;

import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.exception.BusinessException.BusinessExceptionBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Retorna os pokemon", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = PokemonResponse.class))),
		@ApiResponse(responseCode = "401", description = "Acesso não autorizado",content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
		@ApiResponse(responseCode = "404", description = "Pokemons não encontrado",content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = BusinessExceptionBody.class))),
		@ApiResponse(responseCode = "500", description = "Sistema indisponivel",content=@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)) })
@Operation(summary = Constants.POKEMON_TYPEONE_AND_TYPETWO_SUMMARRY, description = Constants.POKEMON_TYPEONE_AND_TYPETWO_DESCRIPTION)
public @interface PokemonResponseGetByTypeOneAndTypeTwo {
    
}
