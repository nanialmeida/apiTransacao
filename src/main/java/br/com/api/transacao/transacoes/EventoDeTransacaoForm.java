package br.com.api.transacao.transacoes;


import br.com.api.transacao.transacoes.cartao.CartaoTransacao;
import br.com.api.transacao.transacoes.cartao.CartaoTransacaoForm;
import br.com.api.transacao.transacoes.estabelecimento.Estabelecimento;
import br.com.api.transacao.transacoes.estabelecimento.EstabelecimentoForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoDeTransacaoForm {

    @NotBlank
    private String id;

    @Positive
    private BigDecimal valor;

    @NotNull
    private EstabelecimentoForm estabelecimento;

    @NotNull
    private CartaoTransacaoForm cartao;

    @NotNull
    private LocalDate efetivadaEm;

    @Deprecated
    public EventoDeTransacaoForm() {
    }

    public EventoDeTransacaoForm(@NotBlank String id,@Positive BigDecimal valor,@NotNull EstabelecimentoForm estabelecimento,
                                 @NotNull CartaoTransacaoForm cartao,@NotNull LocalDate efetivadaEm) {
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

    public EstabelecimentoForm getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoTransacaoForm getCartao() {
        return cartao;
    }

    public LocalDate getEfetivadaEm() {
        return efetivadaEm;
    }

    public EventoDeTransacao converte() {

        return new EventoDeTransacao(id,valor,estabelecimento.converte(),cartao.converte(),efetivadaEm);
    }
}
