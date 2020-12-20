package br.com.pokedex.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.domain.User;
import br.com.pokedex.domain.response.UserResponse;
import br.com.pokedex.domain.resquest.UserRequest;
import br.com.pokedex.domain.resquest.UserUpdate;

public class UserScenarioFactory {

	public static final String ID_VALID=UUID.randomUUID().toString();
	public static final UserResponse USER_RESPONSE_SAVE=loadUserResponse();
	public static final UserRequest USER_REQUEST=loadUserRequest();
	public static final User USER_SAVE=loadUser();
	public static final User USER_UPDATE_SAVE=loadUpdateSave();
	public static final UserUpdate USER_UPDATE=loadUpdate();
	public static final User USER=loadUser();
	public static final User USER_NEW=loadUserNew();
	public static final User USER_BUILDER=loadUserBuilder();
	public static final User USER_SET=loadSetUser();
	public static final User USER_GET=loadGetUser();
	public static final UserUpdate USER_UPDATE_NOT_MOD=loadUpdateNotMod();
	
	private static User loadGetUser() {
		User user=new User();
		user.getUserId();
		user.getName();
		user.getEmail();
		user.getNickname();
		user.getListPokemons();
		return user;
	}
	
	private static UserUpdate loadUpdateNotMod() {
		return UserUpdate.builder().build();
	}

	private static UserResponse loadUserResponse() {
		List<Pokemon> listPokemon=new ArrayList<>();

		listPokemon.add(PokemonScenarioFactory.POKEMON_VALID.get());
		
		return UserResponse.builder()
				.id("f4sad56f4dsafsad4f6as5f4")
				.email("teste@test.com")
				.nickname("tst")
				.listPokemons(listPokemon)
				.build();
	}
	
	private static User loadSetUser() {
		User user=new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setName("TESTE");
		user.setEmail("teste@este.com.br");
		user.setNickname("tt");
		return user;
	}

	private static User loadUserBuilder() {
		List<Pokemon> listPokemon=new ArrayList<>();

		listPokemon.add(PokemonScenarioFactory.POKEMON_VALID.get());
		
		return User.builder()
				.userId("f4sad56f4dsafsad4f6as5f4")
				.email("teste@test.com")
				.nickname("tst")
				.listPokemons(listPokemon)
				.build();
	}

	private static User loadUserNew() {
		List<Pokemon> listPokemon=new ArrayList<>();

		listPokemon.add(PokemonScenarioFactory.POKEMON_VALID.get());
		
		return User.builder()
				.userId("f4sad56f4dsafsad4f6as5fs4")
				.email("teste@test.com")
				.nickname("tste")
				.listPokemons(listPokemon)
				.build();
	}
	

	private static User loadUpdateSave() {
		List<Pokemon> listPokemon=new ArrayList<>();

		listPokemon.add(PokemonScenarioFactory.POKEMON_VALID.get());
		
		return User.builder()
				.userId("f4sad56f4dsafsad4f6as5f4")
				.email("teste@test.com")
				.nickname("tst")
				.listPokemons(listPokemon)
				.build();
	}
	

	private static UserUpdate loadUpdate() {
		return UserUpdate.builder()
				.name("TESTE")
				.nickname("TST")
				.build();
	}

	private static UserRequest loadUserRequest() {
		return UserRequest.builder()
				.name("TESTE")
				.email("teste@teste.com")
				.nickname("tes")
				.build();
	}

	private static User loadUser() {
		List<Pokemon> listPokemon=new ArrayList<>();

		listPokemon.add(PokemonScenarioFactory.POKEMON_VALID.get());
		
		return User.builder()
				.userId("f4sad56f4dsafsad4f6as5f4")
				.email("teste@test.com")
				.nickname("tst")
				.listPokemons(listPokemon)
				.build();
	}
}
