package br.com.bank.security;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JwtFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext request){

        String header = request.getHeaderString("Authorization");

        if (header == null || !header.startsWith("Bearer ")){
            throw new NotAuthorizedException("Token invalido");
        }

        String token = header.substring(7);

        try {
            String login = JwtUtil.validarToken(token);
            request.setProperty("login", login);
        } catch (Exception e){
            throw new NotAuthorizedException("Token invalido");
        }
    }
}
