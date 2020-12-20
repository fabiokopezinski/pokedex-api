package br.com.pokedex.service.command;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.domain.resquest.PokemonRequest;
import br.com.pokedex.domain.resquest.PokemonUpdate;
import br.com.pokedex.repository.command.PokemonCommandRepository;
import br.com.pokedex.repository.query.PokemonQueryRepository;
import br.com.pokedex.utils.Converter;
import br.com.pokedex.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service("PokemonServiceCommand")
@Validated
@Slf4j
public class PokemonServiceCommand {

	private Converter<Pokemon, PokemonResponse> converterResponse;
	private PokemonCommandRepository commandRepository;
	private PokemonQueryRepository queryRepository;
	
		 
	public PokemonResponse save(@Valid PokemonRequest pokemonRequest){
		Pokemon pokemon =Pokemon.of(pokemonRequest);
		queryRepository.findByPokemonId(pokemon.getPokemonId()).ifPresent(p->{throw Message.IS_PRESENT_POKEMON.asBusinessException();}); 
		Pokemon response = commandRepository.save(pokemon);
		log.info("method=save pokemonId={}",pokemon.getPokemonId());
		return converterResponse.toOutPut(response, PokemonResponse.class);
	}

	public PokemonResponse update(@Valid PokemonUpdate pokemonUpdate,Long id) {
		Pokemon pokemon = queryRepository.findByPokemonId(String.valueOf(id)).orElseThrow(Message.NOT_FOUND_POKEMON::asBusinessException);
		pokemon.verify(pokemonUpdate);
		log.info("method=update id={} pokemonId={}",pokemon.getId(),pokemon.getPokemonId());
		return converterResponse.toOutPut(commandRepository.save(pokemon), PokemonResponse.class);
	}
	
	public void delete(Long pokemonId) {
		queryRepository.findByPokemonId(String.valueOf(pokemonId)).orElseThrow(Message.NOT_FOUND_POKEMON::asBusinessException);
		commandRepository.deleteByPokemonId(String.valueOf(pokemonId));
		log.info("method=delete pokemonId={}",pokemonId);
	}
}
