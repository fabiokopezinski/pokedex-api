package br.com.pokedex.controller.query;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.service.query.PokemonServiceQuery;
import lombok.AllArgsConstructor;

@RequestMapping("/pokemons")
@RestController
@AllArgsConstructor
public class PokemonControllerQuery {

	private PokemonServiceQuery service;
	
	@GetMapping
	public ResponseEntity<List<PokemonResponse>>findAll(){
		return ResponseEntity.ok(service.findAll());
	}
}
