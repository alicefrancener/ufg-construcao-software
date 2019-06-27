package com.github.alicefng.cs.aula10.domain;

/**
 * Classe para avaliar parâmetros das classes InputUtils e CalendarUtils, além de
 * executar o programa para obter o dia da semana de interesse.
 */
public final class ControladorUtils {

    /**
     * Índice da data de interesse no parâmetro String[] fornecido.
     */
    private static final int INDEX_DATA_INTERESSE = 0;

    /**
     * Índice do ano bissexto de referência no parâmetro String[] fornecido.
     */
    private static final int INDEX_ANO_BISSEXTO = 1;

    /**
     * Índice da data de referência no parâmetro String[] fornecido.
     */
    private static final int INDEX_DATA_REFERENCIA = 2;

    /**
     * Índice do dia da semana da data de referência no parâmetro String[]
     * fornecido.
     */
    private static final int INDEX_DIA_DA_SEMANA = 3;


    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private ControladorUtils() {

    }

    /**
     * Executa método para obter dia da semana, avaliando todos os parâmetros
     * de  entrada fornecidos.
     *
     * @param argumentos Argumentos a serem fornecidos pelo usuário
     * @return -1, caso os argumentos fornecidos não estejam de acordo com
     * especificado pelos requisitos; 0 a 6, caso os parâmetros estejam
     * corretos, sendo 0 correspondente à segunda-feira, 1, terça-feira, e
     * assim sucessivamente.
     * @implNote Para atender aos requisitos R1, R2, R3, R4, R5, R6 e R14
     */
    public static int executar(final String[] argumentos) {
        try {
            InputUtils.evalQtdArgumentos(argumentos);
            InputUtils.evalArgumentoIsNatural(argumentos);

            CalendarUtils.evalQtdDigitosData(argumentos[INDEX_DATA_INTERESSE]);
            CalendarUtils.evalQtdDigitosData(argumentos[INDEX_DATA_REFERENCIA]);

            CalendarUtils.evalRangeAno(argumentos[INDEX_DATA_INTERESSE]);
            CalendarUtils.evalRangeAno(argumentos[INDEX_DATA_REFERENCIA]);
            CalendarUtils.evalRangeAnoBissexto(argumentos[INDEX_ANO_BISSEXTO]);
            CalendarUtils.evalRangeDiaDaSemana(argumentos[INDEX_DIA_DA_SEMANA]);
            //CalendarUtils.evalRangeDia();

            return CalendarUtils.getDiaDaSemana(argumentos[INDEX_DATA_INTERESSE],
                    argumentos[INDEX_ANO_BISSEXTO],
                    argumentos[INDEX_DATA_REFERENCIA],
                    argumentos[INDEX_DIA_DA_SEMANA]);

        } catch (IllegalArgumentException | DataInvalidaException ex) {
            return -1;
        }
    }
}
