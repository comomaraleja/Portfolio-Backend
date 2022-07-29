  
package com.portfolio.mgb.security.jwt;

import com.portfolio.mgb.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private int expiration;
    
    
    //método para generar el token
    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
            return Jwts.builder().setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date())//Esto es para marcar la fecha de inicio)
                    .setExpiration(new Date(new Date().getTime()+expiration*1000)) //para que se sume a la fecha actual, el tiempo de expiracion
                    .signWith(SignatureAlgorithm.HS512, secret) //es el algoritmo que vamos a utilizar para la firma
                    .compact();
    }
    
    public String getNombreUsuarioFromToken(String Token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(Token).getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        
        //validación del token
        try{
            
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        
        //si el try no sale bien, tenemos 5 posibilidades de errores
        
        //El token está formado por 3 partes, si alguna de las partes está mal 
        //tenemos este error para el token mal formado
        catch (MalformedJwtException e){
            logger.error("Token mal formado");
        }
        catch (UnsupportedJwtException e){
            logger.error("Token no soportado");
        }
        //Token expirado
        catch (ExpiredJwtException e){
            logger.error("Token expirado");
        }
        
        //Token vacío
        catch (IllegalArgumentException e){
            logger.error("Token vacío");
        }
        
        //Firma no válida o fallo en la firma
        catch (SignatureException e){
            logger.error("Firma no válida");
        }
        
        return false; //si el token no pasa, y pasa con alguna de estas excepciones, devuelve "false"
    }
}

