package br.com.pokedex.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="userPermissionId",callSuper = false)
@Setter
@Builder
@Document(collection = "userPermission")
public class UserPermission implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
	@Indexed(name = "_id", unique = true)
	private String userPermissionId;

    @Indexed(name = "EMAIL")
	private String email;

    @Indexed(name="SENHA")
    private String password;
    
    @Indexed(name="CONTA_NAO_EXPIRADA")
    private Boolean accountNonExpired;

    @Indexed(name="CONTA_NAO_BLOQUEADA")
    private Boolean accountNonLocked;

    @Indexed(name="HABILITADO")
    private Boolean enabled;

    @DBRef(lazy = true)
    @Indexed(name="LISTA_PERMISSAO")
    private List<Permission> permissions;

    @Indexed(name="CREDENCIAL_NAO_EXPIRADA")
    private Boolean credentialsNonExpired;

    public List<String> getRoles(){
        List<String> roles=new ArrayList<>();
        for (Permission permission : this.permissions) {
            roles.add(permission.getDescription());
        }
        return roles;
    }

    public void addPermission(Permission permission){
        if(permissions==null){
            permissions=new ArrayList<>();
            permissions.add(permission);
        }
        else {
            permissions.add(permission);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {    
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    
}
