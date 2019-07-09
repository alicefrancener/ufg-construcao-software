package com.github.alicefng.cs.aula12.domain;

public class NumeroUtils {

    public static void getGrafiaNumeroCardinal(final int numero){
        if (numero < 0 && numero > 9999){
            throw new IllegalArgumentException("Numero invalido");
        }

        // obter cada um dos dígitos: milhar, centena, dezena, unidade

        // todos os dígitos vão de 0 a 9 (zero a nove)
            // 1º dígito (0 a 9) => getGrafiaMilhar()
                // se for zero, ignore
                // se for 1, mil
                // se for 2 a 9, pegue a grafia do dígito e adicione mil

            // 2º dígito se for 1 e se os próximos não forem zero: cento, cem

            // 2º dígito (0 a 9, exceto 1) => getGrafiaCentena()
                // se for zero ignore
                // duzentos, trezentos...

            // 3º digito, se for 1, checar próximo
                // dez, onze, doze, treze, quatorze, ...

            // 3º dígito (0 a 9, exceto 1) => getGrafiaDezena()
                // se for zero, ignore
                // se for entre 2 a 9, vinte, trinta ...

            // 4º dígito, se todos os anteriores forem zero e esse for zero,
                // retorne zero, se não ignore

            // 4º dígito (1 a 9) =>
                // retorne um a nove
    }

}
