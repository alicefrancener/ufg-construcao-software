package com.github.alicefng.cs.aula10.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataUtilsTest {

    @Test
    public void testDataValida() {
        String dataValida = "20190621";
        assertEquals(2019, DataUtils.getAnoAsInt(dataValida));
        assertEquals(6, DataUtils.getMesAsInt(dataValida));
        assertEquals(21, DataUtils.getDiaAsInt(dataValida, "2019"));
    }

    @Test
    public void testDataTrintaEUmDias() {
        String dataValida = "20190131";
        assertEquals(2019, DataUtils.getAnoAsInt(dataValida));
        assertEquals(1, DataUtils.getMesAsInt(dataValida));
        assertEquals(31, DataUtils.getDiaAsInt(dataValida, "2019"));
    }

    @Test
    public void testDataTrintaEUmDiasInvalido() {
        String dataInvalida = "20190431";
        assertEquals(2019, DataUtils.getAnoAsInt(dataInvalida));
        assertEquals(4, DataUtils.getMesAsInt(dataInvalida));
        assertEquals(-1, DataUtils.getDiaAsInt(dataInvalida, "2019"));
    }

    @Test
    public void testDataFevereiroValido() {
        String dataValida = "20190228";
        assertEquals(2019, DataUtils.getAnoAsInt(dataValida));
        assertEquals(2, DataUtils.getMesAsInt(dataValida));
        assertEquals(28, DataUtils.getDiaAsInt(dataValida, "2018"));
    }

    @Test
    public void testDataFevereiroBissexto() {
        String dataValida = "20190229";
        assertEquals(2019, DataUtils.getAnoAsInt(dataValida));
        assertEquals(2, DataUtils.getMesAsInt(dataValida));
        assertEquals(29, DataUtils.getDiaAsInt(dataValida, "2015"));
    }

    @Test
    public void testDataFevereiroBissextoInvalido() {
        String dataInvalida = "17000229";
        assertEquals(1700, DataUtils.getAnoAsInt(dataInvalida));
        assertEquals(2, DataUtils.getMesAsInt(dataInvalida));
        assertEquals(-1, DataUtils.getDiaAsInt(dataInvalida, "1692"));
    }

    @Test
    public void testComparaData(){
        assertEquals(0, DataUtils.comparaDatas("20190229","20190229","2019"));
        assertEquals(-1, DataUtils.comparaDatas("20190229","20200228","2019"));
        assertEquals(1, DataUtils.comparaDatas("20001010","15001010","2019"));
    }

    @Test
    public void testAdicionaData(){
        assertEquals("20190701", DataUtils.adicionaDia("20190630","2019"));
        assertEquals("20200101", DataUtils.adicionaDia("20191231","2019"));
        assertEquals("20200229", DataUtils.adicionaDia("20200228","2020"));
        assertEquals("20200301", DataUtils.adicionaDia("20200229","2020"));
    }

}