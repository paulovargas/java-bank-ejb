
package br.com.bank.facade;

import br.com.bank.entity.Conta;
import br.com.bank.service.ContaService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;

@Stateless
public class ContaFacade {

  @Inject
  private ContaService service;

  public void abrirConta(Conta conta) {
    service.abrirConta(conta);
  }

  public void depositar(String numeroConta, BigDecimal valor) {
    service.depositar(numeroConta, valor);
  }
}
