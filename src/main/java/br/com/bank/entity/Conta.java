
package br.com.bank.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_seq")
  @SequenceGenerator(name = "conta_seq", sequenceName = "conta_seq", allocationSize = 1)
  private Long id;

  @Column(nullable = false, unique = true)
  private String numeroConta;

  @Column(nullable = false)
  private BigDecimal saldo;

  // getters e setters
}
