package br.com.pokedex.controller.query;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.pokedex.feature.UserScenarioFactory;
import br.com.pokedex.service.query.UserServiceQuery;

@RunWith(SpringRunner.class)
@WebMvcTest(UserControllerQuery.class)
public class UserControllerQueryTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceQuery service;

    @Test
    public void findAll_WhenSendOffesetAndLimitDefault_ExpectedOk()throws Exception{
        given(service.findAll(0, 10)).willReturn(UserScenarioFactory.USER_RESPONSE_DEFAULT_PAGE);
        mockMvc.perform(get("/users")
        .param("offset", "0")
        .param("limit","10"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
