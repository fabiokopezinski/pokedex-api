package br.com.pokedex.service.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.pokedex.domain.User;
import br.com.pokedex.domain.response.UserResponse;
import br.com.pokedex.repository.query.UserQueryRepository;
import br.com.pokedex.utils.Converter;
import br.com.pokedex.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service("UserServiceQuery")
@Validated
@Slf4j
public class UserServiceQuery {

	private UserQueryRepository repository;

	private Converter<User, UserResponse> converterResponse;

	public Page<UserResponse> findAll(int offset, int size) {
		Pageable p = PageRequest.of(offset, size);
		log.info("method=finAll offset={} size={}", offset, size);
		return converterResponse.toPage(repository.findAll(p), UserResponse.class);
	}

	public UserResponse findByNickname(String nickname) {
		log.info("method=findByNickname nickname={}", nickname);
		return converterResponse.toOutPut(repository.findByNickname(nickname).orElseThrow(Message.NOT_FOUND_USER::asBusinessException), UserResponse.class);
	}

	public UserResponse findByEmail(String email) {
		log.info("method=findByEmail email={}", email);
		return converterResponse.toOutPut(repository.findByEmail(email).orElseThrow(Message.NOT_FOUND_USER::asBusinessException), UserResponse.class);
	}

	public UserResponse findByName(String name) {
		log.info("method=findByName name={}", name);
		return converterResponse.toOutPut(repository.findByName(name).orElseThrow(Message.NOT_FOUND_USER::asBusinessException), UserResponse.class);
	}

}
