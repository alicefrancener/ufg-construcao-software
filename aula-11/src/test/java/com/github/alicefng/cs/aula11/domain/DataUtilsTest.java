package com.github.alicefng.cs.aula11.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataUtilsTest {

    @Test
    public void testDiferencaEntreDatas() {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataI =  LocalDate.parse("03/07/2019", fmt);
        LocalDate dataF =  LocalDate.parse("04/07/2019", fmt);

        assertEquals(1, DataUtils.getDiferencaEntreDatas(dataI,dataF));
        assertEquals(-1, DataUtils.getDiferencaEntreDatas(dataF,dataI));
        assertEquals(0, DataUtils.getDiferencaEntreDatas(dataI,dataI));
    }

    @Test
    public void testDiferencaEntreDatas2() {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataI =  LocalDate.parse("03/07/2019", fmt);
        LocalDate dataF =  LocalDate.parse("02/07/2020", fmt);

        assertEquals(365, DataUtils.getDiferencaEntreDatas(dataI,dataF));
    }

}
