package br.com.pokedex.service.command;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.pokedex.domain.User;
import br.com.pokedex.domain.response.UserResponse;
import br.com.pokedex.exception.BusinessException;
import br.com.pokedex.feature.UserScenarioFactory;
import br.com.pokedex.repository.command.UserCommandRepository;
import br.com.pokedex.repository.query.UserQueryRepository;
import br.com.pokedex.utils.Converter;
import javassist.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceCommandTest {

	@InjectMocks
	UserServiceCommand service;
	@Mock
	Converter<User,UserResponse> converterResponse;
	@Mock 
	UserCommandRepository commandRepository;
	@Mock 
	UserQueryRepository queryRepository;
	
	@Test
	public void save_WhenUserRequestIsValid_ExpectedCreated()throws BusinessException {
		when(queryRepository.findByEmail(any())).thenReturn(Optional.empty());
		when(queryRepository.findByNickname(any())).thenReturn(Optional.empty());
		when(commandRepository.save(any())).thenReturn(UserScenarioFactory.USER_SAVE);
		when(converterResponse.toOutPut(any(), any())).thenReturn(UserScenarioFactory.USER_RESPONSE_SAVE);
		assertNotNull(service.save(UserScenarioFactory.USER_REQUEST));
		verify(commandRepository,times(1)).save(any());
	}
	
	@Test(expected = BusinessException.class)
	public void save_WhenEmailExisted_ExpectedBusinessException()throws BusinessException {
		when(queryRepository.findByEmail(any())).thenReturn(Optional.of(UserScenarioFactory.USER_SAVE));
		service.save(UserScenarioFactory.USER_REQUEST);
	}
	
	@Test(expected = BusinessException.class)
	public void save_WhenNicknameExisted_ExpectedBusinessException()throws BusinessException {
		when(queryRepository.findByEmail(any())).thenReturn(Optional.empty());
		when(queryRepository.findByNickname(any())).thenReturn(Optional.of(UserScenarioFactory.USER_SAVE));
		service.save(UserScenarioFactory.USER_REQUEST);
	}
	
	@Test
	public void update_WhenUserUpdateIsValid_ExpectedOk() throws BusinessException, NotFoundException {
		when(queryRepository.findById(anyString())).thenReturn(Optional.of(UserScenarioFactory.USER_UPDATE_SAVE));
		when(queryRepository.findByName(any())).thenReturn(Optional.empty());
		when(queryRepository.findByNickname(any())).thenReturn(Optional.empty());
		when(commandRepository.save(any())).thenReturn(UserScenarioFactory.USER_UPDATE_SAVE);
		when(converterResponse.toOutPut(any(), any())).thenReturn(UserScenarioFactory.USER_RESPONSE_SAVE);
		assertNotNull(service.update(UserScenarioFactory.USER_UPDATE, UserScenarioFactory.ID_VALID));
		verify(commandRepository).save(any());
	}
	
	@Test(expected = NotFoundException.class)
	public void update_WhenIdNotExist_ExpectedNotFound() throws BusinessException, NotFoundException {
		when(queryRepository.findById(any())).thenReturn(Optional.empty());
		service.update(UserScenarioFactory.USER_UPDATE, UserScenarioFactory.ID_VALID);
	}
	
	@Test(expected=BusinessException.class)
	public void update_WhenNameExist_ExpectBusiness() throws BusinessException, NotFoundException {
		when(queryRepository.findById(any())).thenReturn(Optional.of(UserScenarioFactory.USER_SAVE));
		when(queryRepository.findByName(any())).thenThrow(BusinessException.class);
		service.update(UserScenarioFactory.USER_UPDATE, UserScenarioFactory.ID_VALID);
	}
	
	@Test(expected = BusinessException.class)
	public void update_WhenNicknameExist_ExpectBusiness() throws BusinessException, NotFoundException {
		when(queryRepository.findById(any())).thenReturn(Optional.of(UserScenarioFactory.USER_UPDATE_SAVE));
		when(queryRepository.findByName(anyString())).thenReturn(Optional.empty());
		when(queryRepository.findByNickname(any())).thenThrow(BusinessException.class);
		service.update(UserScenarioFactory.USER_UPDATE, UserScenarioFactory.ID_VALID);
	} 
	
	@Test
	public void delete_WhenUserIdIsValid_ExpectOk() {
		when(queryRepository.findById(any())).thenReturn(Optional.of(UserScenarioFactory.USER_SAVE));
		service.delete(UserScenarioFactory.ID_VALID);
		verify(commandRepository,times(1)).deleteByUserId(anyString());
	}
	
	@Test(expected = BusinessException.class)
	public void delete_WhenUserIdNotExist_ExpectNotFound() {
		service.delete(UserScenarioFactory.ID_VALID);		
	}
	
}
