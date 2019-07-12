package com.github.alicefng.cs.aula12.domain;

/**
 * Data Transfer Object (DTO) criado para encapsular dados e enviar para api.
 */
public class GrafiaNumeroDTO {

    /**
     * Grafia do número.
     */
    private String grafiaNumero;

    /**
     * Construtor.
     *
     * @param grafiaNumero A grafia do número
     */
    public GrafiaNumeroDTO(String grafiaNumero) {
        this.grafiaNumero = grafiaNumero;
    }

}
