package sistema.sistema.Entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private RoleEntity role;
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
    public Collection<? extends GrantedAuthority> getAuthorities() { //Representa la autoridad del usuario autenticado
       return List.of(new SimpleGrantedAuthority(role.getRol_name())); 
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }  
        
      
}
