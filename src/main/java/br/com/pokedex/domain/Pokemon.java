package br.com.pokedex.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import br.com.pokedex.domain.enums.Type;
import br.com.pokedex.domain.request.PokemonRequest;
import br.com.pokedex.domain.request.PokemonUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id",callSuper = false)
@Builder
@Setter
@Document(collection = "pokemon")
public class Pokemon {

	@Id
	private String id;

	@Indexed(unique = true)
	@Field(name = "CD_POKEMON")
	private String pokemonId;

	@Field(name = "NOME")
	private String name;

	@Field(name = "TIPO_UM", targetType = FieldType.STRING)
	private Type typeOne;

	@Field(name = "TIPO_DOIS", targetType = FieldType.STRING)
	private Type typeTwo;

	@Field(name = "DESCRICAO")
	private String description;
	
	public static Pokemon of(PokemonRequest request) {
		return Pokemon.builder()
				.pokemonId(request.getPokemonId())
				.name(request.getName())
				.typeOne(Type.getTypee(request.getTypeOne()))
				.typeTwo(Type.getTypee(request.getTypeTwo()))
				.description(request.getDescription())
				.build();
	}
	
	public void verify(PokemonUpdate pokemonUpdate) {

		if (pokemonUpdate.getName() != null) {
			this.name = pokemonUpdate.getName();
		}
		if (pokemonUpdate.getTypeOne() != null) {
			this.typeOne = Type.getTypee(pokemonUpdate.getTypeOne());
		}
		if (pokemonUpdate.getTypeTwo() != null) {
			this.typeTwo = Type.getTypee(pokemonUpdate.getTypeTwo());
		}
		if (pokemonUpdate.getDescription() != null) {
			this.description = pokemonUpdate.getDescription();
		}
	}

}
