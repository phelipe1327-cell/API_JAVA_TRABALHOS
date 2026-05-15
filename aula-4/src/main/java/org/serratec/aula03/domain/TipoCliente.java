package org.serratec.aula03.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoCliente {
    PF,
    PJ;

    @JsonCreator
    public static TipoCliente fromString(String valor) {
        for (TipoCliente tipo : TipoCliente.values()) {
            if (tipo.name().equalsIgnoreCase(valor)) {
                return tipo;
            }
        }

        throw new IllegalArgumentException("TipoCliente inválido. Use PF ou PJ.");
    }
}