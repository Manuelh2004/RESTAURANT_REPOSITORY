package sistema.sistema.Controllers.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sistema.sistema.Services.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor 
public class AuthController {

    private final AuthService authService; //Servicio de autenticación 
    
    //El ResponseEntity representa toda la respuesta (codigo de estado, encabezados y el cuerpo de respuesta) 
    @PostMapping(value = "/login") 
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){ //LoginRequest -> Credenciales del usuario (logueo)
        return ResponseEntity.ok(authService.login(request)); 
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){ //RegisterRequest -> Credenciales del usuario (registro) 
        return ResponseEntity.ok(authService.register(request)); 
    }
}
