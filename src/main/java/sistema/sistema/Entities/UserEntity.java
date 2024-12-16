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

@Data
@Builder
@AllArgsConstructor
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
   
    public UserEntity(String usr_name, String usr_last_name, String usr_birthdate, String usr_photo,
            String usr_document, String usr_status, String usr_email, String usr_password, RoleEntity role,
            BranchEntity branch, TypeUserEntity type_user, TypeDocumentEntity type_document) {
        this.usr_name = usr_name;
        this.usr_last_name = usr_last_name;
        this.usr_birthdate = usr_birthdate;
        this.usr_photo = usr_photo;
        this.usr_document = usr_document;
        this.usr_status = usr_status;
        this.usr_email = usr_email;
        this.usr_password = usr_password;
        this.role = role;
        this.branch = branch;
        this.type_user = type_user;
        this.type_document = type_document;
    }
    public UserEntity() {
    }
    
    public String getUsr_email() {
        return usr_email;
    }
    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }
    public String getUsr_password() {
        return usr_password;
    }
    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }
    public int getUsr_id() {
        return usr_id;
    }
    public void setUsr_id(int usr_id) {
        this.usr_id = usr_id;
    }
    public String getUsr_name() {
        return usr_name;
    }
    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }
    public String getUsr_last_name() {
        return usr_last_name;
    }
    public void setUsr_last_name(String usr_last_name) {
        this.usr_last_name = usr_last_name;
    }
    public String getUsr_birthdate() {
        return usr_birthdate;
    }
    public void setUsr_birthdate(String usr_birthdate) {
        this.usr_birthdate = usr_birthdate;
    }
    public String getUsr_photo() {
        return usr_photo;
    }
    public void setUsr_photo(String usr_photo) {
        this.usr_photo = usr_photo;
    }
    public String getUsr_document() {
        return usr_document;
    }
    public void setUsr_document(String usr_document) {
        this.usr_document = usr_document;
    }
    public String getUsr_status() {
        return usr_status;
    }
    public void setUsr_status(String usr_status) {
        this.usr_status = usr_status;
    }
    public RoleEntity getRole() {
        return role;
    }
    public void setRole(RoleEntity role) {
        this.role = role;
    }
    public BranchEntity getBranch() {
        return branch;
    }
    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }
    public TypeUserEntity getType_user() {
        return type_user;
    }
    public void setType_user(TypeUserEntity type_user) {
        this.type_user = type_user;
    }
    public TypeDocumentEntity getType_document() {
        return type_document;
    }
    public void setType_document(TypeDocumentEntity type_document) {
        this.type_document = type_document;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //Representa la autoridad del usuario autenticado
       return List.of(new SimpleGrantedAuthority(role.getRol_name())); 
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
    /*
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        throw new UnsupportedOperationException("dasd"); 
    }
    @Override
    public boolean isAccountNonLocked(){
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
    public String getUsername() {
        return this.usr_email; // Usamos el email como nombre de usuario
    }
    
    @Override
    public String getPassword() {
        return this.usr_password; // Devuelve la contraseña
    }
   */

}
