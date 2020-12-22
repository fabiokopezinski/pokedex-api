package br.com.pokedex.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.domain.User;
import br.com.pokedex.domain.request.UserRequest;
import br.com.pokedex.domain.request.UserUpdate;
import br.com.pokedex.domain.response.UserResponse;

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
	public static final Page<User> USER_DEFAULT_PAGE = loadUserDefaultPage();
	public static final Page<UserResponse> USER_RESPONSE_DEFAULT_PAGE = loadUserResponseDefaultPage();
	public static final Optional<User> USER_VALID = loadUserNickname();
	public static final Optional<UserResponse> USER_RESPONSE_VALID = loadUserResponseNickname();
	public static final String USER_NICKNAME_VALID = "teste";
	public static final String USER_NICKNAME_INVALID = "invalido";
	public static final String USER_EMAIL_VALID = "teste@gmail.com";
	public static final String USER_EMAIL_INVALID = "invalido@gmail.com";
	public static final String USER_NAME_VALID = "Teste";
	public static final String USER_NAME_INVALID = "Invalido";
	
	
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
				.id(UUID.randomUUID().toString())
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
	
	private static Page<User> loadUserDefaultPage() {
		User user = new User(ID_VALID, "Teste", "teste@gmail.com", "teste", null);
		return new PageImpl<>(Arrays.asList(user));		
	}
	
	private static Page<UserResponse> loadUserResponseDefaultPage() {
		UserResponse user = new UserResponse(ID_VALID, "Teste", "teste@gmail.com", "teste", null);
		return new PageImpl<>(Arrays.asList(user));
	}
	
	private static Optional<User> loadUserNickname() {
		return Optional.of(User.builder()
				.userId(ID_VALID)
				.email("teste@gmail.com")
				.name("Teste")
				.nickname("teste")
				.listPokemons(null)
				.build());
	}
	
	private static Optional<UserResponse> loadUserResponseNickname() {
		return Optional.of(UserResponse.builder()
				.id(ID_VALID)
				.email("teste@gmail.com")
				.name("Teste")
				.nickname("teste")
				.listPokemons(null)
				.build());
	}
	
}
