package com.github.alicefng.cs.aula12.domain;

public class NumeroUtils {

    public static void getGrafiaNumeroCardinal(final int numero){
        // checar se tem 4 dígitos
        // checar se todos são dígitos
        // obter cada um dos dígitos: milhar, centena, dezena, unidade
        // todos os dígitos vão de 0 a 9 (zero a nove)
            // 1º dígito (0 a 9) => getGrafiaMilhar()
                // se for zero, ignore
                // se for 1, mil
                // se for 2 a 9, pegue a grafia do dígito e adicione mil
            // 2º dígito (0 a 9) => getGrafiaCentena()
                // se o anterior for zero e esse for zero, ignore
                // se os dois posteriores forem zeros ou se for numero redondo
                    // cem, duzentos, trezentos ... e ignore os metodos abaixo
            // 3º dígito (0 a 9) => getGrafiaDezena()
                //se o dois anteriores forem zero e esse for zero, ignore
                //se for 1 => dez, onze, doze, treze, quatorze, ... ignore o método abaixo
                // se for entre 2 a 9, vinte, trinta ...
            // 4º dígito (0 a 9) =>
                // se todos os anteriores forem zero e esse for zero, retorne zero
                // zero a nove
    }


}
