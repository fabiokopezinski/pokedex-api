package br.com.pokedex.controller.command;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.pokedex.feature.UserScenarioFactory;
import br.com.pokedex.service.command.UserServiceCommand;

@RunWith(SpringRunner.class)
@WebMvcTest(UserControllerCommand.class)
public class UserControllerCommandTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UserServiceCommand service;
    
    @Test
    public void save_WhenUserRequestIsValid_ExpectedCreated() throws Exception {
        given(service.save(any())).willReturn(UserScenarioFactory.USER_RESPONSE_VALID.get());
		mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(UserScenarioFactory.USER_REQUEST))).andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void update_WhenUserUpdateIsValid_ExpectedOk() throws Exception {
        given(service.update(any(), any())).willReturn(UserScenarioFactory.USER_RESPONSE_VALID.get());
		mockMvc.perform(patch("/users/1").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(UserScenarioFactory.USER_UPDATE))).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void delete_WhenUserIdIsValid_ExpectedOk() throws Exception {
        mockMvc.perform(delete("/users/1").contentType(MediaType.APPLICATION_JSON));
    }


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
