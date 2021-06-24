package br.com.api.transacao.transacoes;

import br.com.api.transacao.transacoes.cartao.CartaoTransacao;
import br.com.api.transacao.transacoes.estabelecimento.Estabelecimento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class EventoDeTransacao {

    @Id
    private String id;

    @Positive
    private BigDecimal valor;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelecimento;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private CartaoTransacao cartao;

    private LocalDate efetivadaEm;

    @Deprecated
    public EventoDeTransacao() {
    }

    public EventoDeTransacao(String id, BigDecimal valor, Estabelecimento estabelecimento, CartaoTransacao cartao, LocalDate efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoTransacao getCartao() {
        return cartao;
    }

    public LocalDate getEfetivadaEm() {
        return efetivadaEm;
    }
}
