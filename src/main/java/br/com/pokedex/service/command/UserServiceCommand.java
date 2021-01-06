package br.com.pokedex.service.command;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.pokedex.domain.User;
import br.com.pokedex.domain.request.UserRequest;
import br.com.pokedex.domain.request.UserUpdate;
import br.com.pokedex.domain.response.UserResponse;
import br.com.pokedex.exception.BusinessException;
import br.com.pokedex.repository.command.UserCommandRepository;
import br.com.pokedex.repository.query.UserQueryRepository;
import br.com.pokedex.utils.Converter;
import br.com.pokedex.validations.Message;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service("UserServiceCommand")
@Validated
@Slf4j
public class UserServiceCommand {

	private Converter<User,UserResponse> converterResponse;
	private UserCommandRepository commandRepository;
	private UserQueryRepository queryRepository;
	private UserPermissionServiceCommand userPermissionServiceCommand;

	public UserResponse save(@Valid UserRequest userRequest)throws BusinessException {
		User user=User.of(userRequest);
		queryRepository.findByEmail(userRequest.getEmail()).ifPresent(p->{throw Message.EMAIL_ISPRESENT_USER.asBusinessException();});
		queryRepository.findByNickname(userRequest.getNickname()).ifPresent(ex->{throw Message.IS_PRESENT_USER.asBusinessException();});
		userPermissionServiceCommand.save(userRequest.getEmail(), userRequest.getPassword());
		User response = commandRepository.save(user);
		log.info("method=save userId={}",response.getUserId());
		return converterResponse.toOutPut(response, UserResponse.class);
	}
	
	public UserResponse update(@Valid UserUpdate userUpdate,String id ) throws BusinessException,NotFoundException {
			
		User user = queryRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND_USER.getMessage()));
		queryRepository.findByName(userUpdate.getName()).ifPresent(p->{Message.IS_PRESENT_USER.asBusinessException();});
		queryRepository.findByNickname(userUpdate.getNickname()).ifPresent(p->{Message.NICKNAME_IS_USED_USER.asBusinessException();});
		user.verify(userUpdate);
		log.info("method=save userId={}",user.getUserId());
		return converterResponse.toOutPut(commandRepository.save(user), UserResponse.class);
	}
	
	public void delete(String userId ) {
		queryRepository.findById(userId).orElseThrow(Message.NOT_FOUND_USER::asBusinessException);
		commandRepository.deleteByUserId(String.valueOf(userId));
		log.info("method=delete userId={}",userId);
	}
	
}
