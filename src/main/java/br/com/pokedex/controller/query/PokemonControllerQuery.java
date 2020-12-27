package br.com.pokedex.controller.query;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokedex.annotation.ListPokemonsGetCodeStandard;
import br.com.pokedex.annotation.PokemonResponseGetByTypeOneCodeStandard;
import br.com.pokedex.annotation.PokemonResponseGetByTypeOneAndTypeTwo;
import br.com.pokedex.annotation.PokemonResponseGetNameCodeStandard;
import br.com.pokedex.annotation.PokemonsGetIdCodeStandard;
import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.service.query.PokemonServiceQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RequestMapping("/pokemons")
@RestController
@Tag(name = "Pokemons")
@AllArgsConstructor
public class PokemonControllerQuery {

	private PokemonServiceQuery service;
	
	@GetMapping
	@ListPokemonsGetCodeStandard
	public ResponseEntity<Page<PokemonResponse>>findAll(@RequestParam(required=false,value="offset",defaultValue = "0")int offset
			,@RequestParam(required = false,value = "limit",defaultValue = "10")int limit){
		return ResponseEntity.ok(service.findAll(offset,limit));
	}
	
	@GetMapping("/{pokemonId}")
	@PokemonsGetIdCodeStandard
	public ResponseEntity<PokemonResponse>findByPokemonId(@PathVariable("pokemonId")Long pokemonId){
		return ResponseEntity.ok(service.findByPokemon(pokemonId));
	}
	
	@GetMapping("/types/{typeOne}/{typeTwo}")
	@PokemonResponseGetByTypeOneAndTypeTwo
	public ResponseEntity<Page<PokemonResponse>>findByTypeOneAndTypeTwo(@PathVariable("typeOne")String typeOne, @PathVariable("typeTwo")String typeTwo, @RequestParam(required=false,value="offset",defaultValue = "0")int offset
			,@RequestParam(required = false,value = "limit",defaultValue = "10")int limit) {
		return ResponseEntity.ok(service.findByTypeOneAndTypeTwo(typeOne,typeTwo, offset, limit));
	}
	
	@GetMapping("/types/{typeOne}")
	@PokemonResponseGetByTypeOneCodeStandard
	public ResponseEntity<Page<PokemonResponse>>findByTypeOne(@PathVariable("typeOne")String typeOne, @RequestParam(required=false,value="offset",defaultValue = "0")int offset
			,@RequestParam(required = false,value = "limit",defaultValue = "10")int limit) {
		return ResponseEntity.ok(service.findByTypeOne(typeOne, offset, limit));
	}
	
	@GetMapping("/names")
	@PokemonResponseGetNameCodeStandard
	public ResponseEntity<PokemonResponse>findByName(@RequestParam(required = true) String name) {
		return ResponseEntity.ok(service.findByName(name));
	}
}
