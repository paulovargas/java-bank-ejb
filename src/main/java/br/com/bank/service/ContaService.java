
package br.com.bank.service;

import br.com.bank.dao.ContaDAO;
import br.com.bank.entity.Conta;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;

@Stateless
public class ContaService {

  @Inject
  private ContaDAO dao;

  public void abrirConta(Conta conta) {
    conta.setSaldo(BigDecimal.ZERO);
    dao.salvar(conta);
  }

  public void depositar(String numeroConta, BigDecimal valor) {
    Conta conta = dao.buscarPorNumero(numeroConta);
    conta.setSaldo(conta.getSaldo().add(valor));
  }
}
