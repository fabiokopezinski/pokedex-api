package br.com.pokedex.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="permissionId",callSuper = false)
@Setter
@Builder
@Document(collection = "permission")
public class Permission implements GrantedAuthority {

    /**
     *
     */
    private static final long serialVersionUID = 5896746037866772079L;

    @Id
	@Indexed(name = "_id", unique = true)
	private String permissionId;

	@Indexed(name = "DESCRICAO")
	private String description;
    
    @Override
    public String getAuthority() {
        
        return this.description;
    }
    
}
