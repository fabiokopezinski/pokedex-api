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

import br.com.pokedex.domain.request.PokemonRequest;
import br.com.pokedex.domain.request.PokemonUpdate;
import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.service.command.PokemonServiceCommand;
import lombok.AllArgsConstructor;

@RequestMapping("/pokemons")
@AllArgsConstructor
@RestController
public class PokemonControllerCommand {

	private PokemonServiceCommand service;
	
	@PostMapping
	public ResponseEntity<PokemonResponse> save(@RequestBody PokemonRequest pokemon){
		PokemonResponse response = service.save(pokemon);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(response.getId()).toUri();
		return ResponseEntity.created(uri).body(response);
	}
	
	@PatchMapping("/{pokemonId}")
	public ResponseEntity<PokemonResponse> update(@PathVariable("pokemonId") Long pokemonId,@RequestBody PokemonUpdate pokemon){
		return ResponseEntity.ok(service.update(pokemon, pokemonId));
	}
	
	@DeleteMapping("/{pokemonId}")
	public ResponseEntity<Void> delete(@PathVariable("pokemonId")Long pokemonId){
		service.delete(pokemonId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
