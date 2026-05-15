package org.serratec.aula03.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente_premium")
public class ClientePremium extends Cliente {

    @NotNull(message = "O limite de crédito não pode ser nulo")
    @Column(name = "limite_credito", nullable = false)
    private Double limiteCredito;

    @NotBlank(message = "O nível de fidelidade não pode ser vazio")
    @Column(name = "nivel_fidelidade", nullable = false)
    private String nivelFidelidade;

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getNivelFidelidade() {
        return nivelFidelidade;
    }

    public void setNivelFidelidade(String nivelFidelidade) {
        this.nivelFidelidade = nivelFidelidade;
    }
}