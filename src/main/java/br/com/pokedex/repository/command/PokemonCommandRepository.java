package br.com.pokedex.repository.command;

import org.springframework.stereotype.Repository;

import br.com.pokedex.domain.Pokemon;
import br.com.pokedex.repository.BaseCommandRepository;

@Repository
public interface PokemonCommandRepository extends BaseCommandRepository<Pokemon, String>  {
	
	void deleteByPokemonId(String ID);
}
