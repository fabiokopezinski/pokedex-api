package br.com.pokedex.domain.response;

import org.springframework.data.annotation.Id;

import br.com.pokedex.domain.enums.Type;
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
	
	private Type  typeOne;
	
	private Type  typeTwo;
	
	private String description;
}
