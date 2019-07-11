package com.github.alicefng.cs.aula12.domain;

public class NumeroUtils {


    private final static String[] GRAFIA_UNIDADE = {"zero", "um", "dois",
            "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};

    private final static String[] GRAFIA_CENTENA = {"cento", "cem", "duzentos",
            "trezentos", "quatrocentos", "quinhentos", "seiscentos",
            "setecentos", "oitocentos", "novecentos"};

    public static void getGrafiaNumeroCardinal(final int numero) {
        if (numero < 0 || numero > 9999) {
            throw new IllegalArgumentException("Numero invalido");
        }

        final int milhar = numero / 1000;
        final int restoMilhar = numero % 1000;
        final int centena = restoMilhar / 100;
        final int restoCentena = restoMilhar % 100;
        final int dezena = restoCentena / 10;
        final int unidade = restoCentena % 10;

        final StringBuilder grafiaNumero = new StringBuilder();

        if (milhar != 0) {
            grafiaNumero.append(getGrafiaMillhar(milhar));
        }
        if(milhar != 0){
            grafiaNumero.append(getGrafiaCentena(centena,dezena,unidade));
        }

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

    public static String getGrafiaMillhar(final int milhar) {
        final String grafiaMilhar = "mil";

        if (milhar == 1) {
            return grafiaMilhar;
        }

        return String.format("%s %s", getGrafiaUnidade(milhar), "mil");
    }

    public static String getGrafiaCentena(final int centena, final int dezena
            , final int unidade) {
        if (centena == 1 && dezena != 0 && unidade != 0) {
            return GRAFIA_CENTENA[0];
        } else {
            return GRAFIA_CENTENA[centena];
        }
    }

    public static String getGrafiaUnidade(final int unidade) {
        return GRAFIA_UNIDADE[unidade];
    }


}
