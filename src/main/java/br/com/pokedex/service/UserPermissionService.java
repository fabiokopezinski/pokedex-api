package br.com.pokedex.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.pokedex.repository.query.UserPermissionQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserPermissionService implements UserDetailsService {

    UserPermissionQuery userPermissionQuery;
    
    @Override
    public UserDetails loadUserByUsername(String username)  {
        return userPermissionQuery.findByEmail(username).get();
    }
    
}
