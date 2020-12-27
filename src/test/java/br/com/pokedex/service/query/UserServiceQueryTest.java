package br.com.pokedex.service.query;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.security.test.context.support.WithMockUser;

import br.com.pokedex.domain.User;
import br.com.pokedex.domain.response.UserResponse;
import br.com.pokedex.exception.BusinessException;
import br.com.pokedex.feature.UserScenarioFactory;
import br.com.pokedex.repository.query.UserQueryRepository;
import br.com.pokedex.service.UserPermissionService;
import br.com.pokedex.utils.Converter;

@RunWith(MockitoJUnitRunner.class)
@WithMockUser(username = "fabiokopezinski@gmail.com", password = "124578", roles = "ADMIN")
public class UserServiceQueryTest {
	
	@InjectMocks
	UserServiceQuery service;

	@Mock
	UserQueryRepository repository;
	
	@Mock
	Converter<User, UserResponse> converterResponse;

	@Mock
	UserPermissionService servicePermission;
	
	@Test
	public void findAll_WhenOffsetAndSizeIsDefault() {
		given(repository.findAll(any(Pageable.class))).willReturn(UserScenarioFactory.USER_DEFAULT_PAGE);
		given(converterResponse.toPage(any(), any())).willReturn(UserScenarioFactory.USER_RESPONSE_DEFAULT_PAGE);
		assertNotNull(service.findAll(0, 10));
		verify(repository,times(1)).findAll(any(Pageable.class));
	}
	
	@Test
	public void findByNickname_WhenUserNicknameIsValid_ExpectedOk() {
		given(repository.findByNickname(any())).willReturn(UserScenarioFactory.USER_VALID);
		given(converterResponse.toOutPut(any(), any())).willReturn(UserScenarioFactory.USER_RESPONSE_VALID.get());
		assertNotNull(service.findByNickname(UserScenarioFactory.USER_NICKNAME_VALID));
		verify(repository).findByNickname(any());
	}
	
	@Test
	public void findByNickname_WhenUserNicknameIsInvalid_ExpectedNotFound() {
		assertThrows(BusinessException.class, ()->service.findByNickname(UserScenarioFactory.USER_NICKNAME_INVALID));
	}
	
	@Test
	public void findByEmail_WhenUserEmailIsValid_ExpectedOk() {
		given(repository.findByEmail(any())).willReturn(UserScenarioFactory.USER_VALID);
		given(converterResponse.toOutPut(any(), any())).willReturn(UserScenarioFactory.USER_RESPONSE_VALID.get());
		assertNotNull(service.findByEmail(UserScenarioFactory.USER_EMAIL_VALID));
		verify(repository).findByEmail(any());
	}
	
	@Test
	public void findByEmail_WhenUserEmailIsInvalid_ExpectedNotFound() {
		assertThrows(BusinessException.class, ()->service.findByEmail(UserScenarioFactory.USER_EMAIL_INVALID));
	}
	
	@Test
	public void findByName_WhenUserNameIsValid_ExpectedOk() {
		given(repository.findByName(any())).willReturn(UserScenarioFactory.USER_VALID);
		given(converterResponse.toOutPut(any(), any())).willReturn(UserScenarioFactory.USER_RESPONSE_VALID.get());
		assertNotNull(service.findByName(UserScenarioFactory.USER_NAME_VALID));
		verify(repository).findByName(any());
	}
	
	@Test
	public void findByName_WhenUserNameIsInvalid_ExpectedNotFound() {
		assertThrows(BusinessException.class, ()->service.findByName(UserScenarioFactory.USER_EMAIL_INVALID));
	}
	
}
