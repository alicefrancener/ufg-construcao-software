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
     * Ponto de entrada da aplicação. Apenas para ilustra chamada de método.
     *
     * @param args Ignorados.
     */
    public static void main(final String[] args) {

        logger.info("iniciado");
		Data data = new Data(14,5,2019);
        System.out.println(data.diaDaSemana());
		System.out.println(CPF.validarDigitosCPF("12345678901"));
    }

}