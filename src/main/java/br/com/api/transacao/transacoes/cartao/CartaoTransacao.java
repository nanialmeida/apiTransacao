package br.com.api.transacao.transacoes.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class CartaoTransacao {

    @Id
    private String id;

    @Email
    @NotBlank
    private String email;

    @Deprecated
    public CartaoTransacao() {
    }

    public CartaoTransacao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
