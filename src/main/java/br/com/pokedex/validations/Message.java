package br.com.pokedex.validations;

import org.springframework.http.HttpStatus;

import br.com.pokedex.exception.BusinessException;

public enum Message {
	
	NOT_FOUND_USER("Usuário não encontrado",HttpStatus.NOT_FOUND),
	NOT_FOT_USER_PERMISSION("Email ou senha inválida",HttpStatus.UNAUTHORIZED),
	TOKEN_ERROR("Erro ao validar o token",HttpStatus.UNAUTHORIZED),
	IS_PRESENT_USER("Usuário já existe",HttpStatus.BAD_REQUEST),
	NICKNAME_IS_USED_USER("Já existe um usuário com esse nickname",HttpStatus.BAD_REQUEST),
	EMAIL_ISPRESENT_USER("Email já existente",HttpStatus.BAD_REQUEST),
	IS_PRESENT_POKEMON("Pokemon já está cadastrado",HttpStatus.BAD_REQUEST),
	NOT_FOUND_POKEMON("Pokemon não encontrado", HttpStatus.NOT_FOUND);
	
	private String value;
	private String description;
	private HttpStatus statusCode;

	private Message(String value, HttpStatus statusCode) {
		this.value = value;
		this.statusCode = statusCode;
	}

	private Message(String value, String description, HttpStatus statusCode) {
		this.value = value;
		this.description = description;
		this.statusCode = statusCode;
	}

	private Message(String value) {
		this.value = value;
	}

	public String getMessage() {
		return this.value;
	}

	public HttpStatus getStatus() {
		return this.statusCode;
	}

	public String getDescription() {
		return description;
	}

	public BusinessException asBusinessException() {
		return BusinessException.builder().httpStatusCode(this.getStatus())
				.code(String.valueOf(this.getStatus().value())).message(this.getMessage())
				.description(this.getDescription()).build();
	}

	
}
