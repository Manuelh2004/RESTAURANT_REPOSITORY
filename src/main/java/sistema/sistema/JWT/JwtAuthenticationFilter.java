package sistema.sistema.JWT;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import sistema.sistema.Services.JWTService;

//Configuración del JWT 
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{ //La extensión es para configurar filtros personalizados

    private final JWTService jwtService; 
    private final UserDetailsService userDetailsService; 
    
    //Filtros relacionados al token
    @Override   //Se tiene acceso al request, response y filterChain (configurado previavemente)
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
       
        final String token = getTokenFromRequest(request); //Obtenemos el token del parametro request por medio de un metodo
        final String username; 

        if (token == null){
            filterChain.doFilter(request, response); //Si es nulo, se retorna null
            return;
        }
        username = jwtService.getUsernameFromToken(token); 

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username); 

            if(jwtService.isTokenValid(token, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); 
                
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        
        filterChain.doFilter(request, response); //Llamamos al filtro para que siga el curso
    }

    private String getTokenFromRequest(HttpServletRequest request) { //Devuelve el token 

       final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION); //Guarda el encabezado de autenticación  
        
       if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")){ //Evalua si existe este texto en el encabezado y 
                                                                                //si este comienza con la palabra "Bearer"
        return authHeader.substring(7); //Retornamos el token
       }
       return null;
    }

     // Método para ignorar rutas de autenticación
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/auth/");
    }

}
