package com.github.alicefng.cs.aula11.domain;

import java.time.LocalDate;
import java.time.Period;

public class DataUtils {

    public static int getDiferencaEntreDatas(final LocalDate dataInicial,
                                             final LocalDate dataFinal) {
        Period periodo = Period.between(dataInicial, dataFinal);
        int diferenca = periodo.getDays();

        return diferenca;
    }
}
