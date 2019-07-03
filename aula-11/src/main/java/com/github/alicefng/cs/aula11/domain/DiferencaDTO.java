package com.github.alicefng.cs.aula11.domain;

/**
 * Data Transfer Object (DTO) criado para encapsular dados e enviar para api.
 */
public class DiferencaDTO {

    private long diferecaDias;

    public DiferencaDTO(long diferencaDias) {
        this.diferecaDias = diferencaDias;
    }

}
