package br.com.pokedex.repository.query;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.pokedex.domain.UserPermission;
import br.com.pokedex.repository.BaseQueryRepository;

@Repository
public interface UserPermissionQuery extends BaseQueryRepository<UserPermission,String> {
    
    Optional<UserPermission> findByEmail(String email);
}
