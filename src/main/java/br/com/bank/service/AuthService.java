package br.com.bank.service;

import br.com.bank.dao.UsuarioDAO;
import br.com.bank.entity.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AuthService {

    @EJB
    private UsuarioDAO usuarioDAO;

    public Usuario login(String login, String senha){
        Usuario usuario = usuarioDAO.buscarPorLogin(login);
        if(usuario != null && BCrypt.checkpw(senha, usuario.getSenha())){
            return usuario;
        }
        return null;
    }
}
