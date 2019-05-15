/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

/**
 * Implementação do algoritmo para calcular o  dia da semana de acordo com uma data válida fornecida
 */

public class Data {

    /**
     * Valores que compõe uma data, correspondentes ao dia, mes e ano
     */
    private int dia;
    private int mes;
    private int ano;

    /**
     * Configura data (dia, mes e ano)
     *
     * @param dia Inteiro que informa dia do mês
     * @param mes Inteiro que informa mês do ano
     * @param ano Inteiro que informa ano
     */
    public Data(int dia, int mes, int ano) {
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }

    /**
     * Configura dia, avaliando sua validade
     *
     * @param dia Inteiro que informa dia do mês
     * @throws DataInvalidaException Se o dia for inválido
     */
    public void setDia(int dia) {
        if (dia < 1 || dia > 31) {
            throw new DataInvalidaException("dia invalido: " + dia);
        }
        this.dia = dia;
    }

    /**
     * Configura mês, avaliando sua validade
     *
     * @param mes Inteiro que informa mês do ano
     * @throws DataInvalidaException Se o mês for inválido
     */
    public void setMes(int mes) {
        if (mes < 1 || mes > 12) {
            throw new DataInvalidaException("mes inválido: " + mes);
        }
        this.mes = mes;
    }

    /**
     * Configura ano, avaliando sua validade
     *
     * @param ano Inteiro que informa ano
     * @throws DataInvalidaException Se o ano for inválido
     */
    public void setAno(int ano) {
        if (ano < 1754) {
            throw new DataInvalidaException("ano inválido: " + ano);
        }
        this.ano = ano;
    }

    /**
     * Retorna dia
     *
     * @return O inteiro correspondente ao dia
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Retorna o mes
     *
     * @return O inteiro correspondente ao mês
     */

    public int getMes() {
        return this.mes;
    }

    /**
     * Retorna ano
     *
     * @return O inteiro correspondente ao ano
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * Transforma inteiros (0 a 6) em strings correspondetes aos dias da semana: "segunda-feira" (índice 0),
     * "terça-feira" (índice 1) e assim sucessivamente, até "domingo" (índice 6).
     *
     * @param dia Inteiro que representa o dia da semana (0 = segunda, 1 = terça, e assim sucessivamente)
     * @return String que representa o nome do dia da semana
     * @throws IllegalArgumentException se o dia informado estiver fora do amplitude
     */
    public String diaDaSemanaToString(int dia) {
        if (dia < 0 || dia > 6) {
            throw new IllegalArgumentException("Dia inválido: " + dia + ". Dia deve estar entre 0 e 6.");
        }
        String nomesDiasDaSemana[] = {"segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira",
                "sábado", "domingo"};
        return nomesDiasDaSemana[dia];
    }

    /**
     * Calcula o dia da semana equivalente a data fornecida
     *
     * @return O nome do dia da semana correspondente a data fornecida
     */
    public String diaDaSemana() {
        int mes = getMes();
        int ano = getAno();
        if (getMes() == 1 | getMes() == 2) {
            mes = getMes() + 12;
            ano = getAno() - 1;
        }
        int calculoDiaDaSemanaParcial = getDia() + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400;
        int calculoDiaDaSemanaFinal = calculoDiaDaSemanaParcial % 7;
        return diaDaSemanaToString(calculoDiaDaSemanaFinal);
    }

}
