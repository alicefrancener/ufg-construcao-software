/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula11.application.console;

import com.github.alicefng.cs.aula11.domain.DataUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Programa que exibe o dia da semana para o dia em que é executado.
 *
 */
public final class ProgramaDiferenca {

    private static final Logger logger =
            LogManager.getLogger(ProgramaDiferenca.class);

    /**
     * Restringe criação de instância.
     */
    private ProgramaDiferenca() {
        // Apenas evita criação de instância.
    }

    /**
     * Ponto de entrada da aplicação. Apenas para ilustra chamada de método.
     *
     * @param args Ignorados.
     */
    public static void main(final String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataI =  LocalDate.parse("03-07-2019", fmt);
        logger.info("iniciado");
        System.out.println(DataUtils.getDiferencaEntreDatas(dataI,dataI));
    }

}
