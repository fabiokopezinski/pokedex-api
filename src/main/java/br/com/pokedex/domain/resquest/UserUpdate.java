package br.com.pokedex.domain.resquest;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserUpdate {

	@Size(min=1,max=255,message="O campo 'nickname' no corpo da requisição está errado")
	private String nickname;
	
	@Size(min=1,max=255,message="O campo 'name' no corpo da requisição está errado")
	private String name;
}
