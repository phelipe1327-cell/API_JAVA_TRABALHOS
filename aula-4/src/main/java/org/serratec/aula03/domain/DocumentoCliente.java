package org.serratec.aula03.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Embeddable
public class DocumentoCliente {

    @NotBlank(message = "CPF ou CNPJ é obrigatório")
    @Size(max = 14, message = "CPF ou CNPJ deve ter no máximo 14 caracteres")
    private String cpfOuCnpj;

    @Size(max = 20, message = "RG ou Inscrição Estadual deve ter no máximo 20 caracteres")
    private String rgInscricaoEstadual;

    @NotNull(message = "Tipo do cliente é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @NotNull(message = "Status do cliente é obrigatório")
    @Enumerated(EnumType.ORDINAL)
    private StatusCliente statusCliente;

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getRgInscricaoEstadual() {
        return rgInscricaoEstadual;
    }

    public void setRgInscricaoEstadual(String rgInscricaoEstadual) {
        this.rgInscricaoEstadual = rgInscricaoEstadual;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }
}