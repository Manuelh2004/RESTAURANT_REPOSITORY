package sistema.sistema.Entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL) 
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"usr_email"})}) //Para que los email sean únicos
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usr_id; 
    @Column
    private String usr_name;
    @Column
    private String usr_last_name;
    @Column
    private String usr_birthdate;
    @Column
    private String usr_photo;
    @Column
    private String usr_document;
    @Column
    private String usr_status;
    @Column(nullable = false) //Para que los ingresos de nuevos registros no sean permitidos sin el campo usr_email
    private String usr_email;
    @Column
    private String usr_password;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id") // Enlace con la tabla `roles`
    private Set<RoleEntity> authorities = new HashSet<>(); 
    
    @ManyToOne
    @JoinColumn(name = "brh_id")
    private BranchEntity branch;    
    @ManyToOne
    @JoinColumn(name = "tpe_us_id")
    private TypeUserEntity type_user;    
    @ManyToOne
    @JoinColumn(name = "tpe_doc_id")
    private TypeDocumentEntity type_document;      

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { 
        // Convertir los roles en una lista de GrantedAuthority
        return authorities.stream()
                          .map(role -> new SimpleGrantedAuthority(role.getRol_name()))
                          .collect(Collectors.toList());
    }         

    @Override
    public boolean isAccountNonLocked(){
        return true; 
    }

    @Override
    public boolean isAccountNonExpired(){
        return true; 
    }

    @Override
    public boolean isCredentialsNonExpired(){
         return true; 
    }

    @Override
    public boolean isEnabled(){
        return true; 
    }

    @Override
    public String getPassword() {
        return this.usr_password; // Devuelve la contraseña
    }

    @Override
    public String getUsername() {
        return this.usr_email; // Devuelve el email como nombre de usuario
    }  
}
