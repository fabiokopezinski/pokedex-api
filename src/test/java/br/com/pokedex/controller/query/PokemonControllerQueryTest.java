package br.com.pokedex.controller.query;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.pokedex.feature.PokemonScenarioFactory;
import br.com.pokedex.service.UserPermissionService;
import br.com.pokedex.service.query.PokemonServiceQuery;

@RunWith(SpringRunner.class)
@WebMvcTest(PokemonControllerQuery.class)
@ActiveProfiles("test")
public class PokemonControllerQueryTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PokemonServiceQuery service;
	
	@MockBean
	private UserPermissionService servicePermission;

	@Test
	public void findAll_WhenSendOffesetAndLimitDefault_ExpectedOk() throws Exception {
		given(service.findAll(0, 10)).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_DEFAULT_PAGE);
		mockMvc.perform(get("/pokemons")
				.param("offset", "0")
				.param("limit","10"))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void findByPokemonId_WhenIdIsValid_ExpectedOk() throws Exception {
		given(service.findByPokemon(any())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_VALID.get());
		mockMvc.perform(get("/pokemons/1")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void findByTypeOneAndTypeTwo_ExpectedOK()throws Exception{
		given(service.findByTypeOneAndTypeTwo(any(), any(), anyInt(), anyInt())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_DEFAULT_PAGE);
		mockMvc.perform(get("/pokemons/types/Grama/Venenoso")
				.param("offset", "0")
				.param("limit","10"))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void findByTypeOne_ExpectedOK()throws Exception{
		given(service.findByTypeOne(any(),anyInt(), anyInt())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_DEFAULT_PAGE);
		mockMvc.perform(get("/pokemons/types/Grama")
				.param("offset", "0")
				.param("limit","10"))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void findByName_ExpectedOK()throws Exception{
		given(service.findByName(anyString())).willReturn(PokemonScenarioFactory.POKEMON_RESPONSE_NAME.get());
		mockMvc.perform(get("/pokemons/names")
				.param("name", "bulbasaur"))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
}
