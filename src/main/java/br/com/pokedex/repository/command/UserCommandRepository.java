package br.com.pokedex.repository.command;

import org.springframework.stereotype.Repository;

import br.com.pokedex.domain.User;
import br.com.pokedex.repository.BaseCommandRepository;

@Repository
public interface UserCommandRepository extends BaseCommandRepository<User, String> {

	void deleteByUserId(String ID);
}
