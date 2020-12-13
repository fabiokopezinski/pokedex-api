package br.com.pokedex.repository.query;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.repository.BaseQueryRepository;

@Repository
public interface PokemonQueryRepository extends BaseQueryRepository<Pokemon, String>, PagingAndSortingRepository<Pokemon,String> {

	Page<Pokemon> findAll(Pageable page); 
	
	Optional<Pokemon> findByPokemonId(String pokemon);
}
