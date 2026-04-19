
package br.com.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
