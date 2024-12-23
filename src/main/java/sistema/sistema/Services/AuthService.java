package sistema.sistema.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sistema.sistema.Controllers.Auth.AuthResponse;
import sistema.sistema.Controllers.Auth.LoginRequest;
import sistema.sistema.Controllers.Auth.RegisterRequest;
import sistema.sistema.Entities.BranchEntity;
import sistema.sistema.Entities.RoleEntity;
import sistema.sistema.Entities.TypeDocumentEntity;
import sistema.sistema.Entities.TypeUserEntity;
import sistema.sistema.Entities.UserEntity;
import sistema.sistema.Repositories.BranchRepository;
import sistema.sistema.Repositories.RoleRepository;
import sistema.sistema.Repositories.TypeDocumentRepository;
import sistema.sistema.Repositories.TypeUserRepository;
import sistema.sistema.Repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UserRepository userRepository; 
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final BranchRepository branchRepository;
    @Autowired
    private final TypeDocumentRepository typeDocumentRepository;
    @Autowired
    private final TypeUserRepository typeUserRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final  JWTService jwtService;
    @Autowired
    private final PasswordEncoder passwordEncoder; 

    public AuthResponse login(LoginRequest request) {
        // Autentica al usuario
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsr_email(), request.getUsr_password())
        );
    
        // Busca al usuario en la base de datos
        UserEntity user = userRepository.findByUsrEmail(request.getUsr_email())
            .orElseThrow(() -> new RuntimeException("User not found"));
    
        // Genera el token
        String token = jwtService.getToken(user);
    
        // Retorna el token y los datos del usuario
        return AuthResponse.builder()
            .token(token)
            .usr_id(user.getUsr_id())
            .usr_last_name(user.getUsr_last_name())
            .usr_status(user.getUsr_status())
            .usr_photo(user.getUsr_photo())
            .usr_name(user.getUsr_name())
            .usr_document(user.getUsr_document())
            .branch(user.getBranch()) // Asegúrate de que `getBranch()` retorna un `BranchEntity`
            .build();
    }
    

    public AuthResponse register(RegisterRequest request) {       
           // Buscar las entidades relacionadas usando los IDs de la solicitud
        RoleEntity userRole = roleRepository.findById(request.getRol_id())
            .orElseThrow(() -> new RuntimeException("Role not found"));
        BranchEntity branch = branchRepository.findById(request.getBrh_id())
            .orElseThrow(() -> new RuntimeException("Branch not found"));
        TypeUserEntity typeUser = typeUserRepository.findById(request.getTpe_us_id())
            .orElseThrow(() -> new RuntimeException("Type User not found"));
        TypeDocumentEntity typeDocument = typeDocumentRepository.findById(request.getTpe_doc_id())
            .orElseThrow(() -> new RuntimeException("Type Document not found"));
        
        // Crear el objeto UserEntity con todos los campos
            UserEntity user = UserEntity.builder()
            .usr_name(request.getUsr_name())
            .usr_last_name(request.getUsr_last_name())
            .usr_birthdate(request.getUsr_birthdate())
            .usr_photo(request.getUsr_photo())
            .usr_document(request.getUsr_document())
            .usr_status(request.getUsr_status())
            .usr_email(request.getUsr_email())
            .usr_password(passwordEncoder.encode(request.getUsr_password())) // Codifica la contraseña            
            .branch(branch)
            .type_user(typeUser)
            .type_document(typeDocument)
            .build();

        // Guardar el usuario en la base de datos
        userRepository.save(user);

        return AuthResponse.builder() 
            .token(jwtService.getToken(user))
            .build();
    }
    public UserEntity getLoggedInUserEntity() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserEntity) {
            return (UserEntity) principal; // Devuelve la entidad del usuario logueado
        }
        throw new RuntimeException("Usuario no encontrado en el contexto de seguridad");
    }

   
    
}
