package com.github.alicefng.cs.aula10.domain;

public final class ControladorUtils {

    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private ControladorUtils() {

    }

    public static int executar(String[] argumentos) {
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
