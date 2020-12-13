package br.com.pokedex.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class User {

	@Id
	@Indexed(name="_id",unique=true)
	private String id;
	
	@Indexed(name="NOME")
	private String name;
	
	@Indexed(name="EMAIL")
	private String email;
	
	@Indexed(name="APELIDO")
	private String nickname;
	
	@DBRef(lazy = true)
	@Indexed(name="LISTA_POKEMON")
	private List<Pokemon> listPokemons;
	
}
