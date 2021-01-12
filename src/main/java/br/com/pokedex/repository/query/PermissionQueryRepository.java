package br.com.pokedex.repository.query;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.pokedex.domain.Permission;
import br.com.pokedex.repository.BaseQueryRepository;

@Repository
public interface PermissionQueryRepository extends BaseQueryRepository<Permission,String> {
    
    Optional<Permission> findByDescription(String description);
}
