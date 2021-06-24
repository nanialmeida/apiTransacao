package br.com.api.transacao.transacoes.estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoForm {
    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;

    @Deprecated
    public EstabelecimentoForm() {
    }

    public EstabelecimentoForm(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }


    public Estabelecimento converte() {

        return new Estabelecimento(nome,cidade,endereco);
    }
}