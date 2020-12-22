package br.com.pokedex.repository.query;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pokedex.domain.User;
import br.com.pokedex.repository.BaseQueryRepository;

@Repository
public interface UserQueryRepository extends BaseQueryRepository<User,String>, PagingAndSortingRepository<User, String> {
	
		Page<User> findAll(Pageable page);
		
		Optional<User> findByNickname(String nickname);
		
		Optional<User> findByEmail(String email);
		
		Optional<User> findByName(String name);
}
