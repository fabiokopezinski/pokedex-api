package br.com.pokedex.controller.command;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pokedex.domain.response.UserResponse;
import br.com.pokedex.domain.resquest.UserRequest;
import br.com.pokedex.domain.resquest.UserUpdate;
import br.com.pokedex.service.command.UserServiceCommand;
import lombok.AllArgsConstructor;

@RequestMapping("/users")
@AllArgsConstructor
@RestController
public class UserControllerCommand {

	private UserServiceCommand service;
	
	@PostMapping
	public ResponseEntity<UserResponse> save(@RequestBody UserRequest user){
		UserResponse response = service.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(response.getId()).toUri();
		return ResponseEntity.created(uri).body(response);
	}
	
	@PatchMapping("/{userId}")
	public ResponseEntity<UserResponse>update(@PathVariable("userId")String userId,@RequestBody UserUpdate userUpdate){
		return ResponseEntity.ok(service.update(userUpdate, userId));
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<UserResponse> delete(@PathVariable("userId")String userId){
		service.delete(userId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
