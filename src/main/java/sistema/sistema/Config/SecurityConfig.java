package sistema.sistema.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults; 

import lombok.RequiredArgsConstructor;

//Annotation
@Configuration //Clase de configuración
@EnableWebSecurity 
@RequiredArgsConstructor

//Contiene la cadena de filtros
public class SecurityConfig {    

    //Restringe el acceso a las rutas
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf-> //Desabilita la protección CSRF (Cross-Site Request Forgey)
                    csrf //Es una medida de seguridad para los métodos POST
                    .disable())
                .authorizeHttpRequests(authRequest -> //Rutas privadas o públicas
                authRequest
                    .requestMatchers("/auth/**").permitAll() //Todas las rutas auth, son públicas
                    .anyRequest().authenticated() //Las rutas que no son auth, se va a pedir autenticación
                    ) 
                .formLogin(withDefaults()) //Formulario de login de sprint security
                .build(); 
    }


}
