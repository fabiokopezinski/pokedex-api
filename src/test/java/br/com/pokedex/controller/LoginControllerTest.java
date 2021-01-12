package br.com.pokedex.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.pokedex.configuration.security.JwtTokenProvider;
import br.com.pokedex.feature.LoginScenarioFactory;
import br.com.pokedex.service.LoginService;
import br.com.pokedex.service.UserPermissionService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@WebMvcTest(LoginController.class)
public class LoginControllerTest {
    
	@Autowired
	private MockMvc mockMvc;

    @MockBean
    private LoginService service;

    @MockBean
	private UserPermissionService userPermissionService;

	@MockBean
    private JwtTokenProvider jwtTokenProvider;
    
    @Test
    public void auth_WhenLoginRequestIsValid_ExpectedOk() throws Exception {
        given(service.auth(any())).willReturn(LoginScenarioFactory.LOGIN_RESPONSE);
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(LoginScenarioFactory.LOGIN))).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
