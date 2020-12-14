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

	private Converter<PokemonRequest, Pokemon> converterRequest;
	private Converter<Pokemon, PokemonResponse> converterResponse;
	private PokemonCommandRepository commandRepository;
	private PokemonQueryRepository queryRepository;
	
	private void findByPokemon(String id) {
		queryRepository.findByPokemonId(id).ifPresent(p->{throw Message.IS_PRESENT.asBusinessException();});
	}
	
	public PokemonResponse save(@Valid PokemonRequest pokemonRequest) {
		Pokemon pokemon = converterRequest.toEntity(pokemonRequest, Pokemon.class);
		findByPokemon(pokemon.getPokemonId());
		log.info("method=save pokemonId={}",pokemon.getPokemonId());
		return converterResponse.toOutPut(commandRepository.save(pokemon), PokemonResponse.class);
	}

	public PokemonResponse update(@Valid PokemonUpdate pokemonUpdate,Long id) {
		Pokemon pokemon = queryRepository.findByPokemonId(String.valueOf(id)).orElseThrow(Message.NOT_FOUND::asBusinessException);
		
		if(pokemonUpdate.getName() != null) {
			pokemon.setName(pokemonUpdate.getName());
		}else if(pokemonUpdate.getTypeOne() != null) {
			pokemon.setTypeOne(pokemonUpdate.getTypeOne());
		}else if(pokemonUpdate.getTypeTwo() != null) {
			pokemon.setTypeTwo(pokemonUpdate.getTypeTwo());
		}else if(pokemon.getDescription() != null) {
			pokemon.setDescription(pokemonUpdate.getDescription());
		}
		log.info("method=update id={} pokemonId={}",pokemon.getId(),pokemon.getPokemonId());
		return converterResponse.toOutPut(commandRepository.save(pokemon), PokemonResponse.class);
	}
	
	public void delete(Long pokemonId) {
		queryRepository.findByPokemonId(String.valueOf(pokemonId)).orElseThrow(Message.NOT_FOUND::asBusinessException);
		commandRepository.deleteByPokemonId(String.valueOf(pokemonId));
		log.info("method=delete pokemonId={}",pokemonId);
	}
}
