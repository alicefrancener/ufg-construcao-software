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
     * Inteiro correspondente ao mês de janeiro
     */
    private static final int JANEIRO = 1;


    /**
     * Inteiro correspondente ao mês de fevereiro
     */
    private static final int FEVEREIRO = 2;

    /**
     * Inteiro correspondente ao mês de março.
     */
    private static final int MARCO = 3;

    /**
     * Inteiro correspondente ao mês abril.
     */
    private static final int ABRIL = 4;

    /**
     * Inteiro correspondente ao mês de maio.
     */
    private static final int MAIO = 5;

    /**
     * Inteiro correspondente ao mês de junho.
     */
    private static final int JUNHO = 6;

    /**
     * Inteiro correspondente ao mês de julho.
     */
    private static final int JULHO = 7;

    /**
     * Inteiro correspondente ao mês de agosto.
     */
    private static final int AGOSTO = 8;

    /**
     * Inteiro correspondente ao mês de setembro.
     */
    private static final int SETEMBRO = 9;

    /**
     * Inteiro correspondente ao mês de outubro.
     */
    private static final int OUTUBRO = 10;

    /**
     * Inteiro correspondente ao mês de novembro.
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
     * Máximo número de dias em fevereiro em ano comum.
     */
    private static final int MAX_DIAS_FEV = 28;


    /**
     * Máximo número de dias em fevereiro em ano bissexto.
     */
    private static final int MAX_DIAS_FEV_BISSEXTO = 29;

    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private DataUtils() {

    }

    /**
     * Avalia se quantidade de dígitos da data está correta (R13a).
     *
     * @param data Data no formato (aaaammdd)
     * @return 0, se a quantidade de dígitos estiver correta; -1, caso não
     * esteja correta
     */
    public static void qtdDigitosData(final String data) {
        if(data.length() != NUMERO_DIGITOS){
          throw new DataInvalidaException();
        }
    }

    public static void rangeAno(final String data){
        final int primeiroDigitoData = Integer.parseInt(data.substring(0));
        if(primeiroDigitoData == 0) {
            throw new DataInvalidaException();
        }
    }

    public static void rangeDiaDaSemana(final String diaDaSemana){
        final int diaDaSemanaAux = Integer.parseInt(diaDaSemana);
        if(diaDaSemanaAux > 6 ){
            throw new IllegalArgumentException();
        }
    }


    public static int getAnoAsInt(final String data) {
        final int ano = Integer.parseInt(data.substring(0, 4));
        return ano;
    }


    /**
     * Avalia mês quanto a sua validade (R13c).
     *
     * @param data Mês a ser avaliado
     * @return -1, se o mês é inválido; 0, caso seja válido
     */
    public static int getMesAsInt(final String data) {
        final int mes = Integer.parseInt(data.substring(4, 6));
        return mes == 0 | mes > DEZEMBRO ? -1 : mes;
    }

    /**
     * Avalia dia quanto a sua validade (R13d).
     *
     * @param data Dia a ser avaliado
     * @return -1, se o mês é inválido; 0, caso seja válido
     */
    public static int getDiaAsInt(final String data, final String anoBissexto) {
        final int dia = Integer.parseInt(data.substring(6, 8));
        final int mes = getMesAsInt(data);

        if (dia == 31) {
            final int[] mesesTrintaEUmDias = {JANEIRO, MARCO, MAIO, JULHO,
                    AGOSTO, OUTUBRO, DEZEMBRO};
            return Arrays.stream(mesesTrintaEUmDias).anyMatch(m -> m == mes)
                    ? dia
                    : -1;
        }

        if (mes == FEVEREIRO) {
            final int ano = getAnoAsInt(data);
            return dia <= MAX_DIAS_FEV | (dia == MAX_DIAS_FEV_BISSEXTO
                    & isBissexto(anoBissexto, ano))
                    ? dia
                    : -1;
        }

        return dia > 0 & dia <= MAX_DIAS ? dia : -1;
    }

    public static int comparaDatas(final String data,
                                   final String dataDeReferencia,
                                   final String anoBissexto) {
        final int ano = getAnoAsInt(data);
        final int mes = getMesAsInt(data);
        final int dia = getDiaAsInt(data, anoBissexto);
        final int anoRef = getAnoAsInt(dataDeReferencia);
        final int mesRef = getMesAsInt(dataDeReferencia);
        final int diaRef = getDiaAsInt(dataDeReferencia, anoBissexto);

        if (ano < anoRef) {
            return -1;
        }
        if (ano > anoRef) {
            return 1;
        } else {
            if (mes < mesRef) {
                return -1;
            }
            if (mes > mesRef) {
                return 1;
            } else {
                if (dia < diaRef) {
                    return -1;
                }
                if (dia > diaRef) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static final int getDiaDaSemana(final String dataDeInteresse,
                                           final String anoBissexto,
                                           final String dataDeReferencia,
                                           final String diaDaSemana) {
        final int comparacao = comparaDatas(dataDeInteresse, dataDeReferencia,
                anoBissexto);
        int diaDaSemanaAux = Integer.parseInt(diaDaSemana);
        String dataDeReferenciaAux = dataDeReferencia;

        if (comparacao == -1) {
            while (!dataDeInteresse.equals(dataDeReferenciaAux)) {
                dataDeReferenciaAux = subtraiDia(dataDeReferenciaAux,
                        anoBissexto);
                diaDaSemanaAux = subtraiDiaDaSemana(diaDaSemanaAux);
            }
        }

        if (comparacao == 1) {
            while (!dataDeInteresse.equals(dataDeReferenciaAux)) {
                dataDeReferenciaAux = adicionaDia(dataDeReferenciaAux, anoBissexto);
                diaDaSemanaAux = adicionaDiaDaSemana(diaDaSemanaAux);
            }
        }

        return diaDaSemanaAux;
    }


    public static String adicionaDia(String data, String anoBissexto) {
        int ano = getAnoAsInt(data);
        int mes = getMesAsInt(data);
        int dia = getDiaAsInt(data, anoBissexto);

        switch (mes) {
            case ABRIL:
            case JUNHO:
            case SETEMBRO:
            case NOVEMBRO:
                if (dia == 30) {
                    dia = 1;
                    mes = adicionaMes(mes);
                } else {
                    dia++;
                }
                break;
            case JANEIRO:
            case MARCO:
            case MAIO:
            case JULHO:
            case AGOSTO:
            case OUTUBRO:
                if (dia == 31) {
                    dia = 1;
                    mes = adicionaMes(mes);
                } else {
                    dia++;
                }
                break;
            case DEZEMBRO:
                if (dia == 31) {
                    dia = 1;
                    mes = adicionaMes(mes);
                    ano++;
                } else {
                    dia++;
                }
                break;
            case FEVEREIRO:
                if (isBissexto(anoBissexto, ano)) {
                    if (dia == 29) {
                        dia = 1;
                        mes = adicionaMes(mes);
                    } else {
                        dia++;
                    }
                } else if (dia == 28) {
                    dia = 1;
                    mes = adicionaMes(mes);
                } else {
                    dia++;
                }
        }

        return String.format("%04d%02d%02d", ano, mes, dia);
    }

    private static String subtraiDia(String data, String anoBissexto) {
        int ano = getAnoAsInt(data);
        int mes = getMesAsInt(data);
        int dia = getDiaAsInt(data, anoBissexto);

        switch (mes) {

            case FEVEREIRO:
            case ABRIL:
            case JUNHO:
            case AGOSTO:
            case SETEMBRO:
            case NOVEMBRO:
                if (dia == 1) {
                    dia = 31;
                    mes = subtraiMes(mes);
                } else {
                    dia--;
                }
                break;

            case MAIO:
            case JULHO:
            case OUTUBRO:
            case DEZEMBRO:
                if (dia == 1) {
                    dia = 30;
                    mes = subtraiMes(mes);
                } else {
                    dia--;
                }
                break;

            case JANEIRO:
                if (dia == 1) {
                    dia = 31;
                    mes = subtraiMes(mes);
                    ano--;
                } else {
                    dia--;
                }
                break;

            case MARCO:
                if (dia == 1) {
                    dia = isBissexto(anoBissexto, ano)
                            ? 29
                            : 28;
                    mes = subtraiMes(mes);
                } else {
                    dia--;
                }
        }

        return String.format("%04d%02d%02d", ano, mes, dia);
    }

    private static int adicionaMes(int mes) {
        if (mes == DEZEMBRO) {
            return JANEIRO;
        }

        return ++mes;
    }

    private static int subtraiMes(int mes) {
        if (mes == JANEIRO) {
            return DEZEMBRO;
        }

        return --mes;
    }

    private static int adicionaDiaDaSemana(final int diaDaSemana) {
        int diaDaSemanaAux = diaDaSemana;
        if (diaDaSemanaAux == 6) {
            return 0;
        }

        return ++diaDaSemanaAux;
    }

    private static int subtraiDiaDaSemana(int diaDaSemana) {
        if (diaDaSemana == 0) {
            return 6;
        }
        return --diaDaSemana;
    }

    public static boolean isMultiplo(final int num1, final int num2) {
        return !(num1 % num2 != 0);
    }

    public static boolean isBissexto(final String anoBissexto,
                                     final int anoAvaliado) {
        final int anoBissextoInt = Integer.parseInt(anoBissexto);
        if ((anoBissextoInt - anoAvaliado) % 4 == 0) {
            return isMultiplo(anoAvaliado, 100)
                    ? isMultiplo(anoAvaliado, 400)
                    : true;
        }

        return false;
    }

}


