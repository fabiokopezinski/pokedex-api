package br.com.pokedex.domain.request;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PokemonRequest {

	@Id
	@JsonIgnore
	private String id;
	@NotNull(message="O campo 'pokemonId' no corpo da requisição")
	private String pokemonId;
	@NotNull(message="O campo 'name' no corpo da requisição")
	private String name;
	@NotNull(message="O campo 'typeOne' no corpo da requisição")
	private String  typeOne;
	@NotNull(message="O campo 'typeTwo' no corpo da requisição")
	private String  typeTwo;
	@NotNull(message="O campo 'description' no corpo da requisição")
	private String description;
}
