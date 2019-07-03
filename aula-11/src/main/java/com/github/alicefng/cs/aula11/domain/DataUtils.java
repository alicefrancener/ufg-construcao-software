package com.github.alicefng.cs.aula11.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DataUtils {

    public static long getDiferencaEntreDatas(final LocalDate dataInicial,
                                             final LocalDate dataFinal) {

        return ChronoUnit.DAYS.between(dataInicial, dataFinal);
    }
}
