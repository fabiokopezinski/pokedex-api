package br.com.pokedex.service.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.repository.query.PokemonQueryRepository;
import br.com.pokedex.utils.Converter;
import br.com.pokedex.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service("PokemonQueryService")
@Validated
@Slf4j
public class PokemonServiceQuery {

	private PokemonQueryRepository repository;
	
	private Converter<Pokemon, PokemonResponse> converterResponse;
	
	public Page<PokemonResponse>findAll(int offeset,int size){
		Pageable p=PageRequest.of(offeset, size);
		log.info("method=findAll offset={} size={}",offeset,size);
		return converterResponse.toPage(repository.findAll(p), PokemonResponse.class);
	}
	
	public PokemonResponse findByPokemon(Long pokemonId) {
		log.info("method=findByPokemon pokemonId={}",pokemonId);
		return converterResponse.toOutPut(repository.findByPokemonId(String.valueOf(pokemonId)).orElseThrow(()->Message.NOT_FOUND.asBusinessException()), PokemonResponse.class);
	}
}
