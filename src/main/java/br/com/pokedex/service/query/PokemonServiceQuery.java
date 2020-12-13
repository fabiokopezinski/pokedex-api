package br.com.pokedex.service.query;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.repository.query.PokemonQueryRepository;
import br.com.pokedex.utils.Converter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("PokemonQueryService")
@Validated
public class PokemonServiceQuery {

	private PokemonQueryRepository repository;
	
	private Converter<Pokemon, PokemonResponse> pokemonList;
	
	public List<PokemonResponse>findAll(){
		return pokemonList.toArray(repository.findAll(), PokemonResponse.class);
	}
}
