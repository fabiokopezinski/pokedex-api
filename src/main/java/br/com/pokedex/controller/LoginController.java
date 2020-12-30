package br.com.pokedex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokedex.domain.request.LoginRequest;
import br.com.pokedex.domain.response.LoginResponse;
import br.com.pokedex.service.LoginService;
import lombok.AllArgsConstructor;

@RequestMapping("/login")
@AllArgsConstructor
@RestController
public class LoginController {

    private LoginService login;

    @PostMapping
    public ResponseEntity<LoginResponse> auth(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(login.auth(loginRequest));
    }
}
