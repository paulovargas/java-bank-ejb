
package br.com.bank.dao;

import br.com.bank.entity.Conta;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class ContaDAO {

  @PersistenceContext(unitName = "BankPU")
  private EntityManager em;

  public void salvar(Conta conta) {
    em.persist(conta);
  }

  public Conta buscarPorNumero(String numeroConta) {
    return em.createQuery(
        "SELECT c FROM Conta c WHERE c.numeroConta = :numero",
        Conta.class)
      .setParameter("numero", numeroConta)
      .getSingleResult();
  }

  public List<Conta> listar() {
    return em.createQuery("SELECT c FROM Conta c", Conta.class)
             .getResultList();
  }
}
