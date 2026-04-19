package br.com.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "extrato")
public class Extrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "extrato_seq")
    @SequenceGenerator(name = "extrato_seq", sequenceName = "extrato_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    @Column(nullable = false)
    private java.time.LocalDateTime dataHora;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private java.math.BigDecimal valor;

    @Column(nullable = false)
    private String operacao; // Ex: DEBITO, CREDITO
}
