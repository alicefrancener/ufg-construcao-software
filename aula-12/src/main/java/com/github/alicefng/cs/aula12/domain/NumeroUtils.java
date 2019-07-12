package com.github.alicefng.cs.aula12.domain;

import java.util.Arrays;

/**
 * Classe para se obter grafia de números.
 */
public final class NumeroUtils {
    /**
     * Grafia de unidades.
     */
    private static final String[] GRAFIA_UNIDADE = {"zero", "um", "dois",
            "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};

    /**
     * Grafia de centenas.
     */
    private static final String[] GRAFIA_CENTENA = {"cento", "cem", "duzentos",
            "trezentos", "quatrocentos", "quinhentos", "seiscentos",
            "setecentos", "oitocentos", "novecentos"};

    /**
     * Grafia de dezenas.
     */
    private static final String[][] GRAFIA_DEZENA = {{"dez", "onze", "doze",
            "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito",
            "dezenove"},

            {"vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta",
                    "oitenta", "noventa"}};

    /**
     * Construtor privado para evitar instanciação da classe.
     */
    private NumeroUtils() {

    }

    /**
     * Obtém a grafia de um número cardinal.
     *
     * @param numero O número a se obter a grafia
     * @return A grafia do número
     * @throws IllegalArgumentException, se parâmetro for menor que 0 e maior
     * que 9999.
     */
    public static String getGrafiaNumeroCardinal(final int numero) {
        final int menorNumero = 0;
        final int maiorNumero = 9999;
        if (numero < menorNumero || numero > maiorNumero) {
            throw new IllegalArgumentException("Numero invalido");
        }

        final int milhar = numero / 1000;
        final int restoMilhar = numero % 1000;
        final int centena = restoMilhar / 100;
        final int restoCentena = restoMilhar % 100;
        final int dezena = restoCentena / 10;
        final int unidade = restoCentena % 10;

        return unirGrafiaNumero(milhar, centena, dezena, unidade);
    }

    /**
     * Reúne a grafia de cada um dos dígitos.
     *
     * @param milhar Dígito de milhar a se obter a grafia
     * @param centena Dígito de centena a se obter a grafia
     * @param dezena Dígito de dezena a se obter a grafia
     * @param unidade Dígito de unidade a se obter a grafia
     * @return A grafia reunida de cada um dos dígitos
     */
    private static String unirGrafiaNumero(final int milhar, final int centena,
                                           final int dezena,
                                           final int unidade) {
        final String[] grafiaNumero = {getGrafiaMillhar(milhar),
                getGrafiaCentena(centena, dezena, unidade),
                getGrafiaDezena(dezena, unidade),
                getGrafiaUnidade(milhar, centena, dezena, unidade)};

        long contNotNull = Arrays.stream(grafiaNumero).filter(
                grafia -> grafia != null).count();

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

    /**
     * Produz a grafia da dezena.
     *
     * @param dezena A dezena a ser obtida a grafia
     * @param unidade A unidade para auxiliar a obtenção da grafia da dezena
     * @return A grafia da dezena
     */
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

    /**
     * Produz a grafia do milhar.
     *
     * @param milhar O milhar a ser obtido a grafia
     * @return A grafia do milhar
     */
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

    /**
     * Produz a grafia da centena.
     *
     * @param centena A centena a ser obtida a grafia
     * @param dezena A dezena para auxiliar a obtenção da grafia da centena
     * @param unidade A unidade para auxiliar a obtenção da grafia da centena
     * @return A grafia da centena
     */
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

    /**
     * Produz a grafia da unidade.
     *
     * @param milhar O milhar para auxiliar a obtenção da grafia da unidade
     * @param centena A centena para auxiliar a obtenção da grafia da unidade
     * @param dezena A dezena para auxiliar a obtenção da grafia da unidade
     * @param unidade A unidade a ser obtida a grafia
     * @return A grafia da unidade
     */
    public static String getGrafiaUnidade(final int milhar,
                                          final int centena,
                                          final int dezena, final int unidade) {
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
