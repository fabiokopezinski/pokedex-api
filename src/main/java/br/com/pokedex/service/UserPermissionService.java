package br.com.pokedex.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pokedex.repository.query.UserPermissionQuery;
import br.com.pokedex.validations.Message;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserPermissionService implements UserDetailsService {

    UserPermissionQuery userPermissionQuery;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userPermissionQuery.findByEmail(username).orElseThrow(()->new UsernameNotFoundException(Message.NOT_FOUND_USER.getDescription()));
    }
    
}
