package br.com.pokedex.domain.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoginRequest {
    
    @NotNull(message="O campo 'email' no corpo da requisição")
    private String email;

    @NotNull(message="O campo 'password' no corpo da requisição")
    private String password;
}
