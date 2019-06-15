/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

/**
 * Exceção para datas inválidas.
 */
class DataInvalidaException extends RuntimeException implements
        java.io.Serializable {

    /**
     * Serial para resolver MissingSerialVersionUID.
     */
    private static final long serialVersionUID = 1;


    /**
     * Constroi uma exceção com mensagem e causa.
     *
     * @param mensagem A mensagem a ser enviada quanto a exceção é lançada.
     * @param causa Causa raiz da exceção (root case)
     */
    DataInvalidaException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
    }
}
