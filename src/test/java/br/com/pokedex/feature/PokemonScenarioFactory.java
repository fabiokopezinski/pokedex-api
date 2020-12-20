package br.com.pokedex.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.domain.response.PokemonResponse;
import br.com.pokedex.domain.resquest.PokemonRequest;
import br.com.pokedex.domain.resquest.PokemonUpdate;

public class PokemonScenarioFactory {

	public static final Long POKEMON_ID_VALID=1L;
	public static final Long POKEMON_ID_INVALID=-1L;
	public static final PokemonUpdate POKEMON_UPDATE=loadPokemonUpdate();
	public static final PokemonUpdate POKEMON_UPDATE_IF_NOT_MODI=loadPokemonUpdateNotModi();
	public static final PokemonRequest POKEMON_REQUEST=loadPokemonRequest();
	public static final String POKEMON_NAME_PARAM_VALID="Bulbasaur";
	public static final String POKEMON_NAME_PARAM_INVALID="Goku";
	public static final Page<Pokemon> POKEMON_DEFAULT_PAGE=loadPokemonDefaultPage();
	public static final Page<PokemonResponse> POKEMON_RESPONSE_DEFAULT_PAGE=loadPokemonResponseDefaultPage();
	public static final Optional<PokemonResponse> POKEMON_RESPONSE_VALID=loadPokemonResponseValid();
	public static final Optional<Pokemon> POKEMON_VALID=loadPokemonValid();
	public static final Optional<Pokemon> POKEMON_NAME=loadPokemonNameValid();
	public static final Optional<PokemonResponse> POKEMON_RESPONSE_NAME=loadPokemonResponseNameValid();
	public static final Pokemon POKEMON_NEW=loadPokemonNew();
	public static final Pokemon POKEMON_SET=loadPokemonSet();
	public static final Pokemon POKEMON_GET=loadPokemonGet();
	public static final Pokemon POKEMON=loadPokemon();
	public static final Pokemon POKEMON_BUILDER=loadPokemonBuilder();



	private static Optional<PokemonResponse> loadPokemonResponseNameValid() {
		return Optional.of(PokemonResponse.builder()
				.id("TESTE")
				.pokemonId(1L)
				.typeOne("T1")
				.typeTwo("T2")
				.description("DESCRIPTION")
				.build());
	}

	private static PokemonUpdate loadPokemonUpdateNotModi() {
		return new PokemonUpdate();
	}


	private static Pokemon loadPokemonBuilder() {
		return Pokemon.builder()
				.id("1")
				.pokemonId("2")
				.typeOne("T1")
				.typeTwo("T2")
				.description("DESCRIPTION")
				.build();
	}


	private static Pokemon loadPokemon() {
		return Pokemon.builder()
				.id("1")
				.pokemonId("2")
				.typeOne("T1")
				.typeTwo("T2")
				.description("DESCRIPTION")
				.build();
	}


	private static Pokemon loadPokemonGet() {
		Pokemon pokemon=new Pokemon();
		pokemon.getId();
		pokemon.getPokemonId();
		pokemon.getName();
		pokemon.getTypeOne();
		pokemon.getTypeTwo();
		pokemon.getDescription();
		return pokemon;
	}


	private static Pokemon loadPokemonSet() {
		Pokemon pokemon=new Pokemon();
		pokemon.setId("1");
		pokemon.setPokemonId("1");
		pokemon.setName("teste");
		pokemon.setTypeOne("T1");
		pokemon.setTypeTwo("T2");
		pokemon.setDescription("TESTE");
		return pokemon;
	}


	private static Pokemon loadPokemonNew() {
		return Pokemon.builder()
				.id("1")
				.pokemonId("1")
				.typeOne("T1")
				.typeTwo("T2")
				.description("DESCRIPTION")
				.build();
	}


	private static PokemonUpdate loadPokemonUpdate() {
		return PokemonUpdate.builder()
				.name("TESTE")
				.typeOne("TESTE!")
				.typeTwo("TESTE2")
				.description("DES")
				.build();
	}


	private static PokemonRequest loadPokemonRequest() {
		return PokemonRequest.builder()
				.id(UUID.randomUUID().toString())
				.pokemonId("1")
				.name("Bulbasaur")
				.typeOne("Grama")
				.typeTwo("Venoso")
				.description("TT")
				.build();
	}


	private static Optional<Pokemon> loadPokemonNameValid() {
		return Optional.of(Pokemon.builder()
				.id("1")
				.pokemonId("1")
				.typeOne("T1")
				.typeTwo("T2")
				.description("DESCRIPTION")
				.build());
	}
	
	private static Page<Pokemon> loadPokemonDefaultPage() {
		Pokemon p=new Pokemon("1", "1", "TT", "T1", "T2", "TETE");
		List<Pokemon> lista=new ArrayList<>();
		lista.add(p);
		return new PageImpl<>(lista);
	}

	private static Optional<Pokemon> loadPokemonValid() {
		return Optional.of(Pokemon.builder()
				.id("1")
				.pokemonId("1")
				.name("Bulbasaur")
				.typeOne("Grama")
				.typeTwo("Venoso")
				.description("TT")
				.build());
	}


	private static Optional<PokemonResponse> loadPokemonResponseValid() {
		return Optional.of(PokemonResponse.builder()
				.id("1")
				.pokemonId(1L)
				.name("Bulbasaur")
				.typeOne("Grama")
				.typeTwo("Venoso")
				.description("TT")
				.build());
	}


	private static Page<PokemonResponse> loadPokemonResponseDefaultPage() {
		PokemonResponse p=new PokemonResponse("1", 1L, "TT", "T1", "T2", "TETE");
		List<PokemonResponse> lista=new ArrayList<>();
		lista.add(p);
		return new PageImpl<>(lista);
	}
}
