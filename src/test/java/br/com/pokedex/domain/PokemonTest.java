package br.com.pokedex.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.pokedex.feature.PokemonScenarioFactory;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class PokemonTest {
	
	@InjectMocks
	Pokemon pokemon;
	
	@Test
	public void EqualsAndHashCode_ExpectedEquals() {
		Pokemon x=PokemonScenarioFactory.POKEMON;
		Pokemon y=PokemonScenarioFactory.POKEMON_NEW;
		
		assertNotSame(x, y);
		assertNotSame(pokemon, x);
		assertEquals(x.hashCode(),y.hashCode());
		assertEquals(x.toString(),y.toString());
		assertTrue(x.toString()!=pokemon.toString());
		assertNotEquals(x ,pokemon);
		assertFalse(x.equals(pokemon));
		assertTrue(x.hashCode()==y.hashCode());
		assertTrue(x.equals(y));
	}
	
	@Test
	public void simpleEqualsContract() {
		EqualsVerifier.simple().forClass(Pokemon.class).suppress(Warning.SURROGATE_KEY);
	}
	
	@Test
	public void pokemon_Of() {
		assertNotNull(Pokemon.of(PokemonScenarioFactory.POKEMON_REQUEST));
	}
	
	@Test
	public void pokemon_expectedBuild() {
		assertNotNull(PokemonScenarioFactory.POKEMON_BUILDER);
	}
	
	@Test
	public void pokemon_ExpectedBuildNoArgs() {
		new Pokemon();
	}
	
	@Test
	public void pokemon_ExpectedSetObjects() {
		assertNotNull(PokemonScenarioFactory.POKEMON_SET);
	}
	
	@Test
	public void pokemon_ExpectedGetObjects() {
		assertNotNull(PokemonScenarioFactory.POKEMON_GET);
	}
	
	@Test
	public void pokemon_verify() {
		Pokemon pokemon=new Pokemon();
		pokemon.verify(PokemonScenarioFactory.POKEMON_UPDATE);
	}
	@Test
	public void pokemon_verifyNotChange() {
		Pokemon pokemon=new Pokemon();
		pokemon.verify(PokemonScenarioFactory.POKEMON_UPDATE_IF_NOT_MODI);
	}
	
	@Test
	public void pokemon_PokemonBuilder_toString() {
		Pokemon.PokemonBuilder builder=Pokemon.builder();
		String expected=Pokemon.builder().toString();
		assertEquals(expected,builder.toString());
	}
	
}
