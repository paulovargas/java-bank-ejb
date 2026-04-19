package br.com.bank.rest;

import br.com.bank.dto.LoginDTO;
import br.com.bank.dto.TokenDTO;
import br.com.bank.entity.Usuario;
import br.com.bank.service.AuthService;
import br.com.bank.security.JwtUtil;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {

    @EJB
    private AuthService authService;

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO dto){

        Usuario usuario = authService.login(dto.getLogin(), dto.getSenha());

        if (usuario == null){
            return Response.status(401).build();
        }

        String token = JwtUtil.gerarToken(usuario.getLogin());

        return Response.ok(new TokenDTO(token)).build();
    }
}
