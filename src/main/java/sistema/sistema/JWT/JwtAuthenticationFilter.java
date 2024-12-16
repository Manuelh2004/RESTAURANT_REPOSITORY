package sistema.sistema.JWT;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Configuración del JWT 
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{ //La extensión es para configurar filtros personalizados
    
    //Filtros relacionados al token
    @Override   //Se tiene acceso al request, response y filterChain (configurado previavemente)
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {

        final String token = getTokenFromRequest(request); //Obtenemos el token del parametro request por medio de un metodo

        if (token == null){
            filterChain.doFilter(request, response); //Si es nulo, se retorna null
            return;
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
}
