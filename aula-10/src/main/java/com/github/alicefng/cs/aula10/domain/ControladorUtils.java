package com.github.alicefng.cs.aula10.domain;

public final class ControladorUtils {

    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private ControladorUtils() {

    }

    public static int executar(String[] argumentos) {
        try {
            InputUtils.qtdArgumentos(argumentos);
            InputUtils.argumentoIsNatural(argumentos);

            DataUtils.qtdDigitosData(argumentos[0]);
            DataUtils.qtdDigitosData(argumentos[2]);

            DataUtils.rangeAno(argumentos[0]);
            DataUtils.rangeAno(argumentos[2]);
            DataUtils.rangeDiaDaSemana(argumentos[3]);

            return DataUtils.getDiaDaSemana(argumentos[0], argumentos[1],
                    argumentos[2], argumentos[3]);

        } catch (IllegalArgumentException | DataInvalidaException ex) {
            return -1;
        }
    }
}
