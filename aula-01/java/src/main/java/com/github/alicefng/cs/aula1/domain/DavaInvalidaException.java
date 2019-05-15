/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

/**
 * Exceção para datas inválidas.
 */
class DataInvalidaException extends RuntimeException {
    /**
     * Construtor da exceção.
     *
     * @param msg A mensagem a ser enviada quanto a exceção é lançada.
     */
    DataInvalidaException(final String msg) {
        super(msg);
    }
}
