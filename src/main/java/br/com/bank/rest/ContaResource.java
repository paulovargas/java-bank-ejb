
package br.com.bank.rest;

import br.com.bank.entity.Conta;
import br.com.bank.facade.ContaFacade;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/contas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContaResource {

  @Inject
  private ContaFacade facade;

  @POST
  public void abrirConta(Conta conta) {
    facade.abrirConta(conta);
  }

  @POST
  @Path("/{numero}/deposito")
  public void depositar(@PathParam("numero") String numero,
                        BigDecimal valor) {
    facade.depositar(numero, valor);
  }
}
