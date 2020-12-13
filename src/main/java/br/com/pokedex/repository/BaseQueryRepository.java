package br.com.pokedex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseQueryRepository <T,ID> extends Repository<T,ID> {

	List<T>findAll();
	
	Optional<T> findById(String ID);
}
