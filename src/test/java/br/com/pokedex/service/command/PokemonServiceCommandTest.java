package br.com.pokedex.service.command;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.domain.resquest.PokemonRequest;
import br.com.pokedex.exception.BusinessException;
import br.com.pokedex.feature.PokemonScenarioFactory;
import br.com.pokedex.repository.command.PokemonCommandRepository;
import br.com.pokedex.repository.query.PokemonQueryRepository;
import br.com.pokedex.utils.Converter;

@RunWith(MockitoJUnitRunner.class)
public class PokemonServiceCommandTest {

	@InjectMocks
	PokemonServiceCommand service;
	@Mock
    Converter<PokemonRequest, Pokemon> converterRequest;
	@Mock
	Converter<Pokemon, PokemonResponse> converterResponse;
	@Mock
	PokemonCommandRepository commandRepository;
	@Mock
	PokemonQueryRepository queryRepository;
		
	@Test
	public void save_WhenPokemonRequestIsValid_ExpectedOk() {
		when(converterRequest.toEntity(any(PokemonRequest.class), any())).thenReturn(PokemonScenarioFactory.POKEMON_VALID.get());
		when(queryRepository.findByPokemonId(any())).thenReturn(Optional.empty());
		when(commandRepository.save(any(Pokemon.class))).thenReturn(PokemonScenarioFactory.POKEMON_VALID.get());
		service.save(PokemonScenarioFactory.POKEMON_REQUEST);
		verify(commandRepository,times(1)).save(any());
	}
	
	@Test
	public void update_WhenPokemonUpdateIsValid_ExpectedOk() {
		when(queryRepository.findByPokemonId(any())).thenReturn(PokemonScenarioFactory.POKEMON_VALID);
		when(commandRepository.save(any())).thenReturn(PokemonScenarioFactory.POKEMON_VALID.get());
		service.update(PokemonScenarioFactory.POKEMON_UPDATE, PokemonScenarioFactory.POKEMON_ID_VALID);
		verify(commandRepository,times(1)).save(any());
	}
	
	@Test(expected = BusinessException.class)
	public void update_WhenPokemonIdIsNotValid_ExpectedNotFound() {
		service.update(PokemonScenarioFactory.POKEMON_UPDATE, PokemonScenarioFactory.POKEMON_ID_INVALID);
	}
	
	@Test
	public void delete_WhenIdIsValid_ExpectedNoContent() {
		when(queryRepository.findByPokemonId(any())).thenReturn(PokemonScenarioFactory.POKEMON_VALID);
		service.delete(PokemonScenarioFactory.POKEMON_ID_VALID);
		verify(commandRepository,times(1)).deleteByPokemonId(any());	
	}
	
	@Test(expected=BusinessException.class)
	public void delete_WhenPokemonIdIsInvalid_ExpectedNotFound() {
		service.delete(PokemonScenarioFactory.POKEMON_ID_INVALID);
	}
}
