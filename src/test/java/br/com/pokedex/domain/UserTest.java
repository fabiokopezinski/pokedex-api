package br.com.pokedex.domain;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.pokedex.feature.UserScenarioFactory;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	@InjectMocks
	User user;
	
	@Test
	public void EqualAndHashCode_ExpectedEquals() {
		User x=UserScenarioFactory.USER;
		User y=UserScenarioFactory.USER_NEW;
		
		assertNotSame(x, y);
		assertNotSame(x.hashCode(),y.hashCode());
		assertNotSame(x.toString(),y.toString());
		assertFalse(x.hashCode()==y.hashCode());
		assertFalse(x.equals(y));
	}
	
	@Test
	public void simpleEqualsContract() {
		EqualsVerifier.simple().forClass(User.class).suppress(Warning.SURROGATE_KEY);
	}
	
	@Test
	public void user_Of() {
		assertNotNull(User.of(UserScenarioFactory.USER_REQUEST));
	}
	
	@Test
	public void user_expectedBuild() {
		assertNotNull(UserScenarioFactory.USER_BUILDER);
	}
	
	@Test
	public void user_ExpectedBuildNoArgs() {
		new User();
	}
	
	@Test
	public void user_ExpectedSetObjects() {
		assertNotNull(UserScenarioFactory.USER_SET);
	}
	
	@Test
	public void user_ExpectedGetObjects() {
		assertNotNull(UserScenarioFactory.USER_GET);
	}
	
	@Test
	public void user_verify() {
		User user=new User();
		user.verify(UserScenarioFactory.USER_UPDATE);
	}
	
	
	@Test
	public void user_verifyNotChange() {
		User user=new User();
		user.verify(UserScenarioFactory.USER_UPDATE_NOT_MOD);
	}
	
	@Test
	public void user_addPokemon() {
		Pokemon pokemon=new Pokemon();
		User user=new User();
		user.addPokemon(pokemon);
	}
	
	@Test
	public void user_addPokemonIsNull() {
		Pokemon pokemon=new Pokemon();
		User user=new User();
		user.setListPokemons(UserScenarioFactory.USER.getListPokemons());
		user.addPokemon(pokemon);
	}
	
	@Test
	public void user_UserBuilder_toString() {
		User.UserBuilder builder=User.builder();
		String expected=User.builder().toString();
		assertEquals(expected,builder.toString());
	}
	
}
