package br.com.bank.dao;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class ExtratoDAO {

    @PersistenceContext(unitName = "BankPU")
    private javax.persistence.EntityManager em;

    public void salvar(br.com.bank.entity.Extrato extrato) {
        em.persist(extrato);
    }

    public java.util.List<br.com.bank.entity.Extrato> buscarPorConta(Long contaId) {
        return em.createQuery("SELECT e FROM Extrato e WHERE e.conta.id = :contaId ORDER BY e.dataHora DESC", br.com.bank.entity.Extrato.class)
                .setParameter("contaId", contaId)
                .getResultList();
    }

}
