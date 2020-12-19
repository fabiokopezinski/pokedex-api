package br.com.pokedex.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.pokedex.domain.resquest.UserRequest;
import br.com.pokedex.domain.resquest.UserUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "user")
public class User {

	@Id
	@Indexed(name = "_id", unique = true)
	private String userId;

	@Indexed(name = "NOME")
	private String name;

	@Indexed(name = "EMAIL")
	private String email;

	@Indexed(name = "APELIDO", unique = true)
	private String nickname;

	@DBRef(lazy = true)
	@Indexed(name = "LISTA_POKEMON")
	private List<Pokemon> listPokemons;

	public void addPokemon(Pokemon pokemon) {
		if (listPokemons == null) {
			listPokemons = new ArrayList<Pokemon>();
		}
		listPokemons.add(pokemon);
	}
	
	public static User of(UserRequest user) {
		return User.builder()
				.userId(user.getId())
				.name(user.getName())
				.nickname(user.getNickname())
				.email(user.getEmail())
				.build();
	}
	
	public void  verify(UserUpdate userUpdate) {
		
		if(userUpdate.getName()!=null) {
			this.name=userUpdate.getName();
		}
		if(userUpdate.getNickname()!=null) {
			this.nickname=userUpdate.getNickname();
		}
	}

}
