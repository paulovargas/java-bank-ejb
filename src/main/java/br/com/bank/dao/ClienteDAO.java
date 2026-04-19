package br.com.bank.dao;

import br.com.bank.entity.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteDAO {
    
    @PersistenceContext(unitName = "BankPU")
    private EntityManager em;

    public void salvar(Cliente cliente) {
        em.persist(cliente);
    }

    public Cliente buscarPorCpf(String cpf) {
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public java.util.List<Cliente> listarTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    public void atualizar(Cliente cliente) {
        em.merge(cliente);
    }

    public void remover(Long id) {
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            em.remove(cliente);
        }
    }
}
