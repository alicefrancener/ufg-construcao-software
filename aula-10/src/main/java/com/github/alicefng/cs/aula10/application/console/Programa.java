package com.github.alicefng.cs.aula10.application.console;

import com.github.alicefng.cs.aula10.domain.ControladorUtils;

/**
 * Classe para executar o programa pelo terminal.
 */
public final class Programa {

    /**
     * Construtor privado para evitar instanciação.
     */
    private Programa() {
    }

    /**
     * Programa para executar pelo terminal.
     *
     * @param args Os argumentos a serem fornecidos via linha de comando.
     */
    public static void main(final String[] args) {
        System.exit(ControladorUtils.executar(args));
    }

}
