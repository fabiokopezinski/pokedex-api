package br.com.pokedex.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.pokedex.domain.Permission;
import br.com.pokedex.domain.UserPermission;
import br.com.pokedex.domain.request.LoginRequest;

public class UserPermissionScenarioFactory {
    
    public static final UserPermission USER_PERMISSION=loadUserPermission();
    public static final UserPermission USER_NEW=loadNewUserPermission();
    public static final UserPermission USER_BUILDER=loadUserPermissionBuilder();
    public static final UserPermission USER_SET=loadUserPermissionSet();
    public static final UserPermission USER_GET=loadUserPermissionGet();
    public static final UserDetails USER_LOGIN=loadUserDetailsLogin();
    public static final LoginRequest LOGIN_REQUEST=loadLoginRequest();

    private static UserPermission loadUserPermission() {
        List<Permission>list=new ArrayList<>();
        list.add(new Permission("fdfdasfsdf","ADMIN"));
        return new UserPermission("dsf15sda4fsdaf","fabio@gmail.com","password",true,true,true,list,true);
    }

    private static LoginRequest loadLoginRequest() {
        return new LoginRequest("fabiokopezinski@gmail.com","124578");
    }

    private static UserDetails loadUserDetailsLogin() {
        
        String[] rolesStr = {"USER"};

        List<GrantedAuthority> auth = AuthorityUtils.createAuthorityList(rolesStr);
        return new User("fabiokopezinski@gmail.com", "124578", auth);
    }

    private static UserPermission loadUserPermissionGet() {
        UserPermission user=new UserPermission();
        user.getUserPermissionId();
        user.getEmail();
        user.getPassword();
        user.getAccountNonExpired();
        user.getAccountNonLocked();
        user.getCredentialsNonExpired();
        user.getEnabled();
        user.getPermissions();
        return user;
    }

    private static UserPermission loadUserPermissionSet() {
       UserPermission user=new UserPermission();
       user.setUserPermissionId("dsafdsfsda");
       user.setEmail("fabio@test.com");
       user.setPassword("password");
       user.setAccountNonExpired(true);
       user.setAccountNonLocked(true);
       user.setCredentialsNonExpired(true);
       user.setEnabled(true);
       user.setPermissions(Arrays.asList(new Permission("fjasdofijsd", "MANAGER")));
       return user;
    }

    private static UserPermission loadUserPermissionBuilder() {
        
        List<Permission>list=new ArrayList<>();
        list.add(new Permission("fdfdasfsdf","ADMIN"));

        return UserPermission.builder()
        .userPermissionId("f4asd5f4ds5a6f")
        .email("fabio@gmail.com")
        .password("fsadfsda")
        .accountNonExpired(true)
        .accountNonLocked(true)
        .credentialsNonExpired(true)
        .permissions(list)
        .build();
    }



    private static UserPermission loadNewUserPermission() {
        List<Permission>list=new ArrayList<>();
        list.add(new Permission("fdfdasfsdf","MANAGER"));
        return new UserPermission("dsf15sda4fsdaf","fabio@gmail.com","password",true,true,true,list,true);
    }
}
