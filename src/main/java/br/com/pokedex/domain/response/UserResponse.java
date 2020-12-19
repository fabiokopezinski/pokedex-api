package br.com.pokedex.domain.response;

import java.util.List;

import org.springframework.data.annotation.Id;

import br.com.pokedex.domain.Pokemon;
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
public class UserResponse {

	@Id
	private String id;

	private String name;

	private String email;

	private String nickname;

	private List<Pokemon> listPokemons;
}
