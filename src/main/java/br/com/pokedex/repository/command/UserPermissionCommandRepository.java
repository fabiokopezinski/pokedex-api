package br.com.pokedex.repository.command;

import org.springframework.stereotype.Repository;

import br.com.pokedex.domain.UserPermission;
import br.com.pokedex.repository.BaseCommandRepository;

@Repository
public interface UserPermissionCommandRepository extends BaseCommandRepository <UserPermission,String> {
    
}
