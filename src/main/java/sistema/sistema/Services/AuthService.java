package sistema.sistema.Services;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sistema.sistema.Controllers.Auth.AuthResponse;
import sistema.sistema.Controllers.Auth.LoginRequest;
import sistema.sistema.Controllers.Auth.RegisterRequest;
import sistema.sistema.Entities.RoleEntity;
import sistema.sistema.Entities.UserEntity;
import sistema.sistema.Repositories.RoleRepository;
import sistema.sistema.Repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UserRepository userRepository; 
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final  JWTService jwtService;
    @Autowired
    private final PasswordEncoder passwordEncoder; 


   public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsr_email(), request.getUsr_password()));
        UserDetails user = userRepository.findByUsrEmail(request.getUsr_email()).orElseThrow(); 
        String token=jwtService.getToken(user); 
        return AuthResponse.builder()
            .token(token)
            .build(); 
    }

    public AuthResponse register(RegisterRequest request) {

        RoleEntity userRole = roleRepository.findByRolName("USER")
        .orElseThrow(() -> new RuntimeException("Role USER not found"));

        UserEntity user = UserEntity.builder()
        .usr_email(request.getUsr_email())
        .usr_password(passwordEncoder.encode(request.getUsr_password())) // Codifica la contraseña
        .role(userRole)
        .build();

        userRepository.save(user); //Registra el user en la BD

        return AuthResponse.builder() 
            .token(jwtService.getToken(user))
            .build();
    }
}
