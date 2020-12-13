package br.com.pokedex.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseCommandRepository <T,ID> extends Repository<T, ID>{
	
		T save(T ID);
		
		T deleteByPokemonId(String ID);
}
