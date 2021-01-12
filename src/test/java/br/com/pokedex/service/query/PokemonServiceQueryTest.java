package br.com.pokedex.service.query;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.exception.BusinessException;
import br.com.pokedex.feature.PokemonScenarioFactory;
import br.com.pokedex.repository.query.PokemonQueryRepository;
import br.com.pokedex.service.UserPermissionService;
import br.com.pokedex.utils.Converter;

@RunWith(MockitoJUnitRunner.class)
public class PokemonServiceQueryTest {

	@InjectMocks
	PokemonServiceQuery service;
	
	@Mock
	PokemonQueryRepository repository;
	
	@Mock
	Converter<Pokemon, PokemonResponse> converter;

	@Mock
	UserPermissionService servicePermission;
	
	@Test
	public void findAll_WhenOffsetAndSizeIsDefault() {
		given(repository.findAll(any(Pageable.class))).willReturn(PokemonScenarioFactory.POKEMON_DEFAULT_PAGE);
		given(converter.toPage(any(), any())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_DEFAULT_PAGE);
		assertNotNull(service.findAll(0, 10));
		verify(repository).findAll(any(Pageable.class));
	}
	
	@Test
	public void findByPokemon_WhenPokemonIdIsValid_ExpectedOk() {
		given(repository.findByPokemonId(any())).willReturn(PokemonScenarioFactory.POKEMON_VALID);
		given(converter.toOutPut(any(), any())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_VALID.get());
		assertNotNull(service.findByPokemon(PokemonScenarioFactory.POKEMON_ID_VALID));
		verify(repository).findByPokemonId(any());
	}
	
	@Test
	public void findByPokemon_WhenPokemonIdIsInvalid_ExpectedNotFound() {
		assertThrows(BusinessException.class, ()->service.findByPokemon(PokemonScenarioFactory.POKEMON_ID_INVALID));
	}
	
	@Test
	public void findByTypeOne_WhenTypeOneIsValid_ExpectedOk() {
		given(repository.findByTypeOne(any(),any(Pageable.class))).willReturn(PokemonScenarioFactory.POKEMON_DEFAULT_PAGE);
		given(converter.toPage(any(), any())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_DEFAULT_PAGE);
		assertNotNull(service.findByTypeOne("Grama", 0, 10));
		verify(repository).findByTypeOne(any(), any(Pageable.class));
	}
	
	@Test
	public void findByTypeOneAndTypeTwo_WhenTypeOneAndTypeTwoIsValid_ExpectedOk() {
		given(repository.findByTypeOneAndTypeTwo(any(),any(),any(Pageable.class))).willReturn(PokemonScenarioFactory.POKEMON_DEFAULT_PAGE);
		given(converter.toPage(any(), any())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_DEFAULT_PAGE);
		assertNotNull(service.findByTypeOneAndTypeTwo("Grama","Fogo" ,0, 10));
		verify(repository).findByTypeOneAndTypeTwo(any(),any(),any(Pageable.class));
	}
	
	@Test
	public void findByName_WhenNameIsValid_ExpectedOk() {
		given(repository.findByName(any())).willReturn(PokemonScenarioFactory.POKEMON_NAME);
		given(converter.toOutPut(any(), any())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_NAME.get());
		assertNotNull(service.findByName(PokemonScenarioFactory.POKEMON_NAME_PARAM_VALID));
		verify(repository).findByName(any());
	}
	
	@Test
	public void findByName_WhenNameIsInvalid_ExpectedNotFound() {
		assertThrows(BusinessException.class, ()->service.findByName(PokemonScenarioFactory.POKEMON_NAME_PARAM_INVALID));
	}
}
