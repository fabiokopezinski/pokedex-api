package br.com.pokedex.domain.request;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PokemonUpdate {
	
	@Size(min=1,message="O campo 'name' no corpo da requisição está errado")
	private String name;
	@Size(min=1,message="O campo 'typeOne' no corpo da requisição está errado")
	private String  typeOne;
	@Size(min=1,message="O campo 'typeTwo' no corpo da requisição está errado")

	private String  typeTwo;
	@Size(min=1,message="O campo 'description' no corpo da requisição está errado")
	private String description;
}
