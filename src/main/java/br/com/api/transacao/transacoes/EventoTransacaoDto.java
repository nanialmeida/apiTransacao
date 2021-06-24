package br.com.api.transacao.transacoes;

import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoTransacaoDto {

    private String idTransacao;
    private BigDecimal valorTransacao;
    private String nomeEstabelecimento;
    private String cidadeEstabelecimento;
    private String enderecoEstabelecimento;
    private String numeroCartao;
    private String emailUsuarioCartao;
    private LocalDate efetivadaEm;

    @Deprecated
    public EventoTransacaoDto() {
    }

    public EventoTransacaoDto(EventoDeTransacao evento) {
        String numeroCartaoCodificado = evento.getCartao().getId().substring(0,4) + "-------"
                + evento.getCartao().getId().substring(evento.getCartao().getId().length()-4);

        String emailUsuarioCodificado = evento.getCartao().getEmail().substring(0,3) + "-------"
                + evento.getCartao().getEmail().substring(evento.getCartao().getEmail().length()-7);

        this.idTransacao = evento.getId();
        this.valorTransacao = evento.getValor();
        this.nomeEstabelecimento = evento.getEstabelecimento().getNome();
        this.cidadeEstabelecimento = evento.getEstabelecimento().getCidade();
        this.enderecoEstabelecimento = evento.getEstabelecimento().getEndereco();
        this.numeroCartao = numeroCartaoCodificado;
        this.emailUsuarioCartao = emailUsuarioCodificado;
        this.efetivadaEm = evento.getEfetivadaEm();
    }


    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public String getCidadeEstabelecimento() {
        return cidadeEstabelecimento;
    }

    public String getEnderecoEstabelecimento() {
        return enderecoEstabelecimento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getEmailUsuarioCartao() {
        return emailUsuarioCartao;
    }

    public LocalDate getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "EventoTransacaoDto{" +
                "idTransacao='" + idTransacao + '\'' +
                ", valorTransacao=" + valorTransacao +
                ", nomeEstabelecimento='" + nomeEstabelecimento + '\'' +
                ", cidadeEstabelecimento='" + cidadeEstabelecimento + '\'' +
                ", enderecoEstabelecimento='" + enderecoEstabelecimento + '\'' +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", emailUsuarioCartao='" + emailUsuarioCartao + '\'' +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
