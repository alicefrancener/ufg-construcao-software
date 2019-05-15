/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.inf.cs.aula1;

/**
 * Exceção para datas inválidas
 */
class DataInvalidaException extends RuntimeException {
    public DataInvalidaException(String msg) {
        super(msg);
    }
}