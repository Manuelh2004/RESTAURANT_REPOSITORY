package sistema.sistema.Services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sistema.sistema.Controllers.Auth.AuthResponse;
import sistema.sistema.Controllers.Auth.LoginRequest;
import sistema.sistema.Controllers.Auth.RegisterRequest;

@Service
@RequiredArgsConstructor
public class AuthService {

    public AuthResponse login(LoginRequest request) {
        return null; 
    }

    public AuthResponse register(RegisterRequest request) {
        return null; 
    }

}
