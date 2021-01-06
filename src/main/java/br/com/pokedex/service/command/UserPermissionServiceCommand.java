package br.com.pokedex.service.command;

import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.pokedex.domain.Permission;
import br.com.pokedex.domain.UserPermission;
import br.com.pokedex.repository.command.UserPermissionCommandRepository;
import br.com.pokedex.repository.query.PermissionQueryRepository;
import br.com.pokedex.repository.query.UserPermissionQuery;
import br.com.pokedex.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service("UserPermissionServiceCommand")
@Slf4j
public class UserPermissionServiceCommand {
 
    private UserPermissionCommandRepository command;
    private UserPermissionQuery userPermissionQuery;
    private PermissionQueryRepository permissionQueryRepository;

    public void save(String email,String password){
        userPermissionQuery.findByEmail(email).ifPresent(p->{throw Message.IS_PRESENT_USER.asBusinessException();});
        Permission permission = permissionQueryRepository.findByDescription("USER").orElseThrow(Message.IS_PRESENT_USER::asBusinessException);
        UserPermission userPermission = UserPermission.builder().email(email).password(new BCryptPasswordEncoder().encode(password).toString()).accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true).build();
        userPermission.addPermission(permission);
        UserPermission response = command.save(userPermission);
        log.info("method=save userPermissionId={}",response.getUserPermissionId());
        
    }
}
