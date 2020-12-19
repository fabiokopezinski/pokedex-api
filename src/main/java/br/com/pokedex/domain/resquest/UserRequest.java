package br.com.pokedex.domain.resquest;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
	@Id
	@JsonIgnore
	private String id;
	
	@NotNull(message="O campo 'name' no corpo da requisição")
	private String name;
	
	@NotNull(message="O campo 'email' no corpo da requisição")
	private String email;
	
	@NotNull(message="O campo 'nickname' no corpo da requisição")
	private String nickname;
}
