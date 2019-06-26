package com.github.alicefng.cs.aula10.domain;

public final class ControladorUtils {

    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private ControladorUtils() {

    }

    /**
     * Executa método para obter dia da semana, avaliando todos os parâmetros
     * de  entrada fornecidos pelo usuário.
     *
     * @param argumentos Argumentos a serem fornecidos pelo usuário
     * @return -1, caso os argumentos fornecidos não estejam de acordo com
     * especificado pelos requisitos; 0 a 6, caso os parâmetros estejam
     * corretos, sendo 0 correspondente à segunda-feira, 1, terça-feira, e
     * assim sucessivamente.
     * @implNote Para atender aos requisitos R6 e R14
     */
    public static int executar(final String[] argumentos) {
        try {
            InputUtils.evalQtdArgumentos(argumentos);
            InputUtils.evalArgumentoIsNatural(argumentos);

            DataUtils.evalQtdDigitosData(argumentos[0]);
            DataUtils.evalQtdDigitosData(argumentos[2]);

            DataUtils.evalRangeAno(argumentos[0]);
            DataUtils.evalRangeAno(argumentos[2]);
            DataUtils.evalRangeAnoBissexto(argumentos[1]);
            DataUtils.evalRangeDiaDaSemana(argumentos[3]);

            return DataUtils.getDiaDaSemana(argumentos[0], argumentos[1],
                    argumentos[2], argumentos[3]);

        } catch (IllegalArgumentException | DataInvalidaException ex) {
            return -1;
        }
    }
}
