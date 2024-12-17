package sistema.sistema.Controllers.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {
    String usr_email;
    String usr_password;
    String usr_name;
    String usr_last_name;
    String usr_birthdate;
    String usr_photo;
    String usr_document;
    String usr_status;
    Integer rol_id;        
    Integer brh_id;      
    Integer tpe_us_id;     
    Integer tpe_doc_id; 
}
