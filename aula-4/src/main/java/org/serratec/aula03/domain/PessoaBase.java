package org.serratec.aula03.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public class PessoaBase {

    @NotBlank(message = "O telefone não pode ser vazio")
    private String telefone;

    @NotBlank(message = "O endereço não pode ser vazio")
    private String endereco;

    @NotNull(message = "O campo ativo não pode ser nulo")
    private Boolean ativo;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}