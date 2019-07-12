package com.github.alicefng.cs.aula12.domain;

import java.util.Arrays;

public class NumeroUtils {


    private final static String[] GRAFIA_UNIDADE = {"zero", "um", "dois",
            "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};

    private final static String[] GRAFIA_CENTENA = {"cento", "cem", "duzentos",
            "trezentos", "quatrocentos", "quinhentos", "seiscentos",
            "setecentos", "oitocentos", "novecentos"};

    private final static String[][] GRAFIA_DEZENA = {{"dez", "onze", "doze",
            "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito",
            "dezenove"},

            {"vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta",
                    "oitenta", "noventa"}};

    public static String getGrafiaNumeroCardinal(final int numero) {
        if (numero < 0 || numero > 9999) {
            throw new IllegalArgumentException("Numero invalido");
        }

        final int milhar = numero / 1000;
        final int restoMilhar = numero % 1000;
        final int centena = restoMilhar / 100;
        final int restoCentena = restoMilhar % 100;
        final int dezena = restoCentena / 10;
        final int unidade = restoCentena % 10;

        return  unirGrafiaNumero(milhar, centena, dezena, unidade);


    }

    private static String unirGrafiaNumero(int milhar, int centena, int dezena,
                                           int unidade) {
        final String[] grafiaNumero = {getGrafiaMillhar(milhar),
                getGrafiaCentena(centena, dezena, unidade),
                getGrafiaDezena(dezena, unidade),
                getGrafiaUnidade(milhar, centena, dezena, unidade)};

        long contNotNull =
                Arrays.stream(grafiaNumero).filter(grafia -> grafia != null).count();

        StringBuilder resu = new StringBuilder();
        int contNotNullAux = 0;
        while (contNotNullAux != contNotNull) {
            for (String grafia : grafiaNumero) {

                if (grafia != null) {
                    contNotNullAux++;

                    if (contNotNull == 1) {
                        resu.append(grafia);
                    }

                    if (contNotNull == 2) {
                        if (contNotNullAux == 1) {
                            resu.append(grafia);
                        }
                        if (contNotNullAux == 2) {
                            resu.append(" e ");
                            resu.append(grafia);
                        }
                    }

                    if (contNotNull == 3) {
                        if (contNotNullAux == 1) {
                            resu.append(grafia);
                        }
                        if (contNotNullAux == 2) {
                            resu.append(", ");
                            resu.append(grafia);
                        }
                        if (contNotNullAux == 3) {
                            resu.append(" e ");
                            resu.append(grafia);
                        }
                    }
                }
            }
        }

        return resu.toString();
    }

    public static String getGrafiaDezena(final int dezena,
                                         final int unidade) {
        if (dezena == 0) {
            return null;
        }

        if (dezena == 1) {
            return GRAFIA_DEZENA[0][unidade];
        }

        return GRAFIA_DEZENA[1][dezena - 2];
    }

    public static String getGrafiaMillhar(final int milhar) {
        if (milhar == 0) {
            return null;
        }

        final String grafiaMilhar = "mil";
        if (milhar == 1) {
            return grafiaMilhar;
        }

        return String.format("%s %s", GRAFIA_UNIDADE[milhar], "mil");
    }

    public static String getGrafiaCentena(final int centena,
                                          final int dezena,
                                          final int unidade) {
        if (centena == 0) {
            return null;
        }

        if (centena == 1 && (dezena != 0 || unidade != 0)) {
            return GRAFIA_CENTENA[0];
        } else {
            return GRAFIA_CENTENA[centena];
        }
    }

    public static String getGrafiaUnidade(final int milhar,
                                          final int centena
            , final int dezena, final int unidade) {
        if (dezena == 1) {
            return null;
        }

        if (unidade == 0) {
            if (milhar == 0 && centena == 0 && dezena == 0) {
                return GRAFIA_UNIDADE[unidade];
            }
            return null;
        }

        return GRAFIA_UNIDADE[unidade];
    }

}
