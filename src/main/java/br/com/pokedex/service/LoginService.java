package br.com.pokedex.service;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.pokedex.configuration.security.JwtTokenProvider;
import br.com.pokedex.domain.request.LoginRequest;
import br.com.pokedex.domain.response.LoginResponse;
import br.com.pokedex.validations.Message;
import lombok.AllArgsConstructor;

@Service("LoginService")
@AllArgsConstructor
@Validated
public class LoginService {
    
   
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider provider;

    public LoginResponse auth(@Valid LoginRequest loginRequest){
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
          
            String token = provider.createToken(loginRequest.getEmail(),authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
    
            return LoginResponse.builder().type("Bearer").token(token).build();
        } catch (Exception e) {
           throw Message.NOT_FOT_USER_PERMISSION.asBusinessException();
        }
    }
}
