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
		return converterResponse.toOutPut(repository.findByPokemonId(String.valueOf(pokemonId)).orElseThrow(Message.NOT_FOUND_POKEMON::asBusinessException), PokemonResponse.class);
	}
	
	public Page<PokemonResponse>findByTypeOneAndTypeTwo(String typeOne, String typeTwo, int offeset, int size){
		Pageable p = PageRequest.of(offeset, size);
		log.info("method=findByTypeOneAndTypeTwo typeOne={} typeTwo={} offset={} size={}",typeOne, typeTwo,offeset,size);
		return converterResponse.toPage(repository.findByTypeOneAndTypeTwo(typeOne, typeTwo, p), PokemonResponse.class);
	}
	
	public Page<PokemonResponse>findByTypeOne(String typeOne,int offeset, int size){
		Pageable p = PageRequest.of(offeset, size);
		log.info("method=findByTypeOne typeOne={} offset={} size={}",typeOne,offeset,size);
		return converterResponse.toPage(repository.findByTypeOne(typeOne, p), PokemonResponse.class);
	}
	
	public PokemonResponse findByName(String name){
		log.info("method=findTypePokemon name={}",name);
		return converterResponse.toOutPut(repository.findByName(name).orElseThrow(Message.NOT_FOUND_POKEMON::asBusinessException), PokemonResponse.class);
	}
	
}
