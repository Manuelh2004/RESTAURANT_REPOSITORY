package sistema.sistema.Controllers.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sistema.sistema.Entities.BranchEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthResponse {
    String token;     
    Integer usr_id;
    String usr_name;
    String usr_last_name;
    String usr_document;
    String usr_photo;   
    String usr_status;
    BranchEntity branch;   
}
