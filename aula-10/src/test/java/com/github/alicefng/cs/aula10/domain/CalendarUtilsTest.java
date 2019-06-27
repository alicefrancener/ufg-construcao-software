package com.github.alicefng.cs.aula10.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalendarUtilsTest {

    @Test
    public void testGet() {
        String dataValida = "20190621";
        assertEquals(2019, CalendarUtils.getAnoAsInt(dataValida));
        assertEquals(6, CalendarUtils.getMesAsInt(dataValida));
        assertEquals(21, CalendarUtils.getDiaAsInt(dataValida));
    }

    @Test
    public void testComparaData() {
        assertEquals(0, CalendarUtils.comparaDatas("20190229",
                "20190229"));
        assertEquals(1, CalendarUtils.comparaDatas("20190229",
                "20190228"));
        assertEquals(-1, CalendarUtils.comparaDatas("20190227",
                "20190228"));
        assertEquals(1, CalendarUtils.comparaDatas("20001010",
                "15001010"));
    }

    @Test
    public void testAdicionaData() {
        assertEquals("20190201", CalendarUtils.adicionaDia("20190131", "2016"));
        assertEquals("20200229", CalendarUtils.adicionaDia("20200228", "2020"));
        assertEquals("20200301", CalendarUtils.adicionaDia("20200229", "2020"));
        assertEquals("20190301", CalendarUtils.adicionaDia("20190228", "2016"));
        assertEquals("20190202", CalendarUtils.adicionaDia("20190201", "2016"));
        assertEquals("20190302", CalendarUtils.adicionaDia("20190301", "2016"));
        assertEquals("20190402", CalendarUtils.adicionaDia("20190401", "2016"));
        assertEquals("20190601", CalendarUtils.adicionaDia("20190531", "2016"));
        assertEquals("20190701", CalendarUtils.adicionaDia("20190630", "2019"));
        assertEquals("20190602", CalendarUtils.adicionaDia("20190601", "2016"));
        assertEquals("20190801", CalendarUtils.adicionaDia("20190731", "2016"));
        assertEquals("20190802", CalendarUtils.adicionaDia("20190801", "2016"));
        assertEquals("20190902", CalendarUtils.adicionaDia("20190901", "2016"));
        assertEquals("20191002", CalendarUtils.adicionaDia("20191001", "2016"));
        assertEquals("20191102", CalendarUtils.adicionaDia("20191101", "2016"));
        assertEquals("20191216", CalendarUtils.adicionaDia("20191215", "2016"));
        assertEquals("20200101", CalendarUtils.adicionaDia("20191231", "2019"));
    }

    @Test
    public void testGetDiaDaSemana() {
        assertEquals(1, CalendarUtils.getDiaDaSemana("20190101",
                "2020", "20190101", "1"));
        assertEquals(2, CalendarUtils.getDiaDaSemana("20190102",
                "2020", "20190101", "1"));
        assertEquals(3, CalendarUtils.getDiaDaSemana("20190103",
                "2020", "20190101", "1"));
        assertEquals(1, CalendarUtils.getDiaDaSemana("20160301",
                "2016", "20160228", "6"));
        assertEquals(0, CalendarUtils.getDiaDaSemana("20160229",
                "2016", "20161231", "5"));
        assertEquals(1, CalendarUtils.getDiaDaSemana("20191231",
                "2016", "20190101", "1"));
    }

    @Test
    public void coberturaException() {
        new DataInvalidaException("Mensagem");
        new DataInvalidaException("Mensagem", new Throwable());
    }

}
