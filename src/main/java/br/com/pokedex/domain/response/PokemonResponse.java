package br.com.pokedex.domain.response;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PokemonResponse {

	@Id
	private String id;
	
	private Long pokemonId;
	
	private String name;
	

	private String  typeOne;
	
	
	private String  typeTwo;
	

	private String description;
}
