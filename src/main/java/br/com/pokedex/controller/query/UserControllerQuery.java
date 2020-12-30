package br.com.pokedex.controller.query;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokedex.annotation.ListUsersResponseCodeStardand;
import br.com.pokedex.annotation.UserResponseGetEmailCodeStardand;
import br.com.pokedex.annotation.UserResponseGetNameCodeStardand;
import br.com.pokedex.annotation.UserResponseGetNicknameCodeStardand;
import br.com.pokedex.domain.response.UserResponse;
import br.com.pokedex.service.query.UserServiceQuery;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RequestMapping("/users")
@RestController
@Tag(name="Usuário")
@AllArgsConstructor
@SecurityRequirements
public class UserControllerQuery {
	
	private UserServiceQuery service;
	
	@GetMapping
	@ListUsersResponseCodeStardand
	public ResponseEntity<Page<UserResponse>>findAll(@RequestParam(required=false,value="offset",defaultValue = "0")int offset
			,@RequestParam(required = false,value = "limit",defaultValue = "10")int limit){
		return ResponseEntity.ok(service.findAll(offset, limit));
	}
	
	@GetMapping("/names/{name}")
	@UserResponseGetNameCodeStardand
	public ResponseEntity<UserResponse>findByName(@PathVariable("name")String name){
		return ResponseEntity.ok(service.findByName(name));
	}
	@GetMapping("/emails/{email}")
	@UserResponseGetEmailCodeStardand
	public ResponseEntity<UserResponse>findByEmail(@PathVariable("email")String email){
		return ResponseEntity.ok(service.findByEmail(email));
	}
	
	@GetMapping("/nicknames/{nickname}")
	@UserResponseGetNicknameCodeStardand
	public ResponseEntity<UserResponse> findByNickname(@PathVariable("nickname")String nickname){
		return ResponseEntity.ok(service.findByNickname(nickname));
	}

}
