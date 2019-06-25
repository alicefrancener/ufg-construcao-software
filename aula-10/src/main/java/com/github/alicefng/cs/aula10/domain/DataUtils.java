package com.github.alicefng.cs.aula10.domain;

import java.util.Arrays;

/**
 * Classe para validar datas.
 */
public class DataUtils {

    /**
     * Número de dígitos necessários para uma data válida no formato String.
     */
    private static final int NUMERO_DIGITOS = 8;

    /**
     * Inteiro correspondente ao mês abril.
     */
    private static final int ABRIL = 4;

    /**
     * Inteiro correspondente ao mês de junho.
     */
    private static final int JUNHO = 6;

    /**
     * Inteiro correspondente ao mês de junho.
     */
    private static final int SETEMBRO = 9;

    /**
     * Inteiro correspondente ao mês de junho.
     */
    private static final int NOVEMBRO = 11;


    /**
     * Inteiro correspondente ao mês dezembro.
     */
    private static final int DEZEMBRO = 12;

    /**
     * Máximo número de dias em um mês.
     */
    private static final int MAX_DIAS = 31;

    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private DataUtils() {

    }

    /**
     * Avalia se quantidade de dígitos da data está correto (R13a).
     *
     * @param data Data no formato (aaaammdd)
     * @return 0, se a quantidade de dígitos estiver correta; -1, caso não
     * esteja correta
     */
    public static int qtdDigitos(final String data) {
        return data.length() == NUMERO_DIGITOS ? 0 : -1;
    }

    /**
     * Avalia mês quanto a sua validade (R13c).
     *
     * @param mes Mês a ser avaliado
     * @return -1, se o mês é inválido; 0, caso seja válido
     */
    public static int validaMes(final int mes) {
        return mes == 0 | mes > DEZEMBRO ? -1 : 0;
    }

    /**
     * Avalia dia quanto a sua validade (R13d).
     *
     * @param dia Dia a ser avaliado
     * @return -1, se o mês é inválido; 0, caso seja válido
     */
    public static int validaDia(final int dia) {
        return dia == 0 | dia > MAX_DIAS ? -1 : 0;
    }

    /**
     * Avalia se dia e mês são coerentes (R13e).
     *
     * @param mes Mes a ser avaliado
     * @param dia Dia a ser avaliado
     * @return -1, se o mês e data não são coerentes; 0, caso sejam coerentes
     */
    public static int validaDiaEMes(final int mes, final int dia) {
        if (dia == 31) {
            final int[] mesesTrintaDias = {ABRIL, JUNHO, SETEMBRO, NOVEMBRO};
            return Arrays.stream(mesesTrintaDias).noneMatch(m -> m == mes)
                    ? -1
                    : 0;
        }

        return 0;
    }

}
