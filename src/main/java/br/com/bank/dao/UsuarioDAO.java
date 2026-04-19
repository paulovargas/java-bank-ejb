package br.com.bank.dao;

import br.com.bank.entity.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UsuarioDAO {

    @PersistenceContext(unitName = "BankPU")
    private EntityManager em;

    public void salvar(Usuario usuario) {
        em.persist(usuario);
    }

    public Usuario buscarPorLogin(String login){
        List<Usuario> lista = em.createQuery("SELECT u FROM Usuario WHERE u.login = :login", Usuario.class)
                .setParameter("login", login)
                .getResultList();

        return lista.isEmpty() ? null : lista.get(0);
    }
}
