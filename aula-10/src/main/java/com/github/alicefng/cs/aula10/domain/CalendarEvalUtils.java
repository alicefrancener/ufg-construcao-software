package com.github.alicefng.cs.aula10.domain;

import java.util.Arrays;

/**
 * Classe para validar entradas relativas à datas e dias da semana.
 */
public final class CalendarEvalUtils {

    /**
     * Número de dígitos necessários para uma data válida no formato String
     * (aaaammdd).
     */
    private static final int NUMERO_DIGITOS = 8;

    /**
     * Menor ano bissexto considerado válido de acordo com os requisitos.
     */
    private static final int MENOR_ANO_BISSEXTO = 1;

    /**
     * Construtor privado para evitar instanciação da classe utilitária.
     */
    private CalendarEvalUtils() {

    }

    /**
     * Avalia se amplitude do dia da semana está correta.
     *
     * @param diaDaSemana Dia da semana a ser avaliado
     * @throws IllegalArgumentException Se o dia da semana for maior que 6
     * @implNote Para atender o requisito R10
     */
    public static void evalDiaDaSemana(final String diaDaSemana) {
        final int diaDaSemanaAux = Integer.parseInt(diaDaSemana);
        if (diaDaSemanaAux > CalendarUtils.DOMINGO) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Avalia ano bissexto quanto ao seu menor valor.
     *
     * @param anoBissexto O ano bissexto a ser avaliado
     * @throws IllegalArgumentException Se o ano bissexto for menor que 1
     * @implNote Para atender o requisito R11
     */
    public static void evalAnoBissexto(final String anoBissexto) {
        final int anoBissextoAux = Integer.parseInt(anoBissexto);
        if (anoBissextoAux < MENOR_ANO_BISSEXTO) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Compila todos os métodos que avaliam data.
     *
     * @param data        A data a ser avaliada
     * @param anoBissexto O ano bissexto de referência
     * @throws DataInvalidaException Se a data for inválida de acordo com
     *                               cada um dos métodos invocados
     * @implNote Para atender requisito R12 e R13
     */
    public static void evalData(final String data, final String anoBissexto) {
        evalQtdDigitosData(data);
        evalRangeAno(data);
        evalRangeMes(data);
        evalRangeDia(data);
        evalDiaMesLongo(data);
        evalDiaFevereiro(data, anoBissexto);
    }

    /**
     * Avalia se a quantidade de dígitos de uma data esperado no formato
     * "aaaammdd" está incorreta.
     *
     * @param data Data a ser avaliada
     * @throws DataInvalidaException Se a quantidade de dígitos não for
     *                               formada exatamente 8
     * @implNote Para atender o requisito R13a
     */
    private static void evalQtdDigitosData(final String data) {
        if (data.length() != NUMERO_DIGITOS) {
            throw new DataInvalidaException();
        }
    }

    /**
     * Avalia se o primeiro dígito da data está incorreto.
     *
     * @param data Data a ter seu primeiro dígito avaliado
     * @throws DataInvalidaException Se o primeiro dígito for 0
     * @implNote Para atender o requisito R13b
     */
    private static void evalRangeAno(final String data) {
        final int primeiroDigitoData =
                Integer.parseInt(data.substring(0, 1));
        if (primeiroDigitoData == 0) {
            throw new DataInvalidaException();
        }
    }

    /**
     * Avalia se mês está dentro da amplitude permitida.
     *
     * @param data Data a ter o mês avaliado
     * @throws DataInvalidaException Se mês está fora da amplitude (1,12)
     * @implNote Para atender o requisito R13c
     */
    private static void evalRangeMes(final String data) {
        final int mes = CalendarUtils.getMesAsInt(data);
        if (mes < CalendarUtils.JANEIRO || mes > CalendarUtils.DEZEMBRO) {
            throw new DataInvalidaException();
        }
    }

    /**
     * Avalia se dia está dentro da amplitude permitida.
     *
     * @param data Data a ter o dia avaliado
     * @throws DataInvalidaException Se dia forma menor que 1 ou maior que 31
     * @implNote Para atender o requisito R13d
     */
    private static void evalRangeDia(final String data) {
        final int dia = CalendarUtils.getDiaAsInt(data);
        if (dia < CalendarUtils.PRIMEIRO_DIA_MES
                || dia > CalendarUtils.ULTIMO_DIA_MES_LONGO) {
            throw new DataInvalidaException();
        }
    }

    /**
     * Avalia se dia é compatível com meses de 31 dias.
     *
     * @param data Data a ter o dia e mês avaliado
     * @throws DataInvalidaException Se dia 31 não for compatível com mês
     * @implNote Para atender o requisito R13e
     */
    private static void evalDiaMesLongo(final String data) {
        final int dia = CalendarUtils.getDiaAsInt(data);
        final int mes = CalendarUtils.getMesAsInt(data);
        final int[] mesesTrintaEUmDias = {CalendarUtils.JANEIRO,
                CalendarUtils.MARCO, CalendarUtils.MAIO, CalendarUtils.JULHO,
                CalendarUtils.AGOSTO, CalendarUtils.OUTUBRO,
                CalendarUtils.DEZEMBRO};

        if (dia == CalendarUtils.ULTIMO_DIA_MES_LONGO
                && Arrays.stream(mesesTrintaEUmDias).noneMatch(m -> m == mes)) {
            throw new DataInvalidaException();
        }
    }

    /**
     * Avalia se dia é compatível com mês de fevereiro.
     *
     * @param data        Data a ter o dia e mês avaliado
     * @param anoBissexto O ano bissexto de referência
     * @throws DataInvalidaException Se o dia de fevereiro não for compatível
     *                               com o mês
     * @implNote Para atender o requisito R13e
     */
    private static void evalDiaFevereiro(final String data,
                                         final String anoBissexto) {
        final int dia = CalendarUtils.getDiaAsInt(data);
        final int mes = CalendarUtils.getMesAsInt(data);
        final int ano = CalendarUtils.getAnoAsInt(data);

        if (dia > CalendarUtils.ULTIMO_DIA_FEV
                && mes == CalendarUtils.FEVEREIRO) {
            if (CalendarUtils.isBissexto(anoBissexto, ano)) {
                if (dia > CalendarUtils.ULTIMO_DIA_FEV_BISSEXTO) {
                    throw new DataInvalidaException();
                }
            } else {
                throw new DataInvalidaException();
            }
        }
    }

}
