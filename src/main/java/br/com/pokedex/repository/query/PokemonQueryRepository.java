package br.com.pokedex.repository.query;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.repository.BaseQueryRepository;

@Repository
public interface PokemonQueryRepository extends BaseQueryRepository<Pokemon, String>{

	List<Pokemon> findAll(); 
}
