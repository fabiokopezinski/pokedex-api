package br.com.pokedex.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "pokemon")
public class Pokemon {

	@Id
	private String id;

	@Indexed(unique=true)
	@Field(name="CD_POKEMON")
	private String pokemonId;
	
	@Field(name="NOME")
	private String name;
	
	@Field(name="TIPO_UM",targetType = FieldType.STRING)
	private String  typeOne;
	
	@Field(name="TIPO_DOIS",targetType = FieldType.STRING)
	private String  typeTwo;
	
	@Field(name="DESCRICAO")
	private String description;
	
}
