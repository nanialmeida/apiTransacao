package br.com.api.transacao.transacoes.cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoTransacaoForm {

    @NotBlank
    private String id;

    @Email
    @NotBlank
    private String email;

    @Deprecated
    public CartaoTransacaoForm() {
    }

    public CartaoTransacaoForm(@NotBlank String id, @Email @NotBlank String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public CartaoTransacao converte() {

        return new CartaoTransacao(id, email);
    }
}

