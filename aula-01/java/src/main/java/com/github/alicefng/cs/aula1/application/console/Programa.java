/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.application.console;

import com.github.alicefng.cs.aula1.domain.CPF;
import com.github.alicefng.cs.aula1.domain.Matematica;
import com.github.alicefng.cs.aula1.domain.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Programa {

    private static final Logger logger =
            LogManager.getLogger(Programa.class);

    /**
     * Restringe criação de instância.
     */
    private Programa() {
        // Apenas evita criação de instância.
    }

    /**
     * Ponto de entrada da aplicação. Apenas para ilustrar chamada de método.
     *
     * @param args Ignorados.
     */
    public static void main(final String[] args) {

        logger.info("iniciado");
        System.out.println(Data.diaDaSemana(14, 5, 2019));
        System.out.println(CPF.validarDigitosCPF("43415200086"));
        System.out.println(Matematica.fatorial(5));
    }

}