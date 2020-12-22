package br.com.pokedex.controller.command;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pokedex.domain.request.PokemonUpdate;
import br.com.pokedex.feature.PokemonScenarioFactory;
import br.com.pokedex.service.command.PokemonServiceCommand;

@RunWith(SpringRunner.class)
@WebMvcTest(PokemonControllerCommand.class)
public class PokemonControllerCommandTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PokemonServiceCommand service;
	
	@Test
	public void save_WhenPokemonRequestIsValid_ExpectedCreated() throws Exception {
		given(service.save(any())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_VALID.get());
		mockMvc.perform(post("/pokemons").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(PokemonScenarioFactory.POKEMON_REQUEST))).andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void update_WhenPokemonUpdateIsValid_ExpectedOk() throws Exception {
		given(service.update(any(PokemonUpdate.class), any())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_VALID.get());
		mockMvc.perform(patch("/pokemons/1").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(PokemonScenarioFactory.POKEMON_UPDATE))).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void delete_WhenPokemonIdIsValid_ExpectedOk() throws Exception{
		mockMvc.perform(delete("/pokemons/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
