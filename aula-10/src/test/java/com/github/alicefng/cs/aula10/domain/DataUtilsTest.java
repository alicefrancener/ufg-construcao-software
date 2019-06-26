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
        assertThrows(DataInvalidaException.class,
                () -> DataUtils.getDiaAsInt(dataInvalida, "2019"));
    }

    @Test
    public void testDataFevereiroValido() {
        String dataValida = "20190228";
        assertEquals(2019, DataUtils.getAnoAsInt(dataValida));
        assertEquals(2, DataUtils.getMesAsInt(dataValida));
        assertEquals(28, DataUtils.getDiaAsInt(dataValida, "2018"));
    }

    @Test
    public void testDataFevereiroInValido() {
        String dataInvalida = "20190230";
        assertEquals(2019, DataUtils.getAnoAsInt(dataInvalida));
        assertEquals(2, DataUtils.getMesAsInt(dataInvalida));
        assertThrows(DataInvalidaException.class,
                () -> DataUtils.getDiaAsInt(dataInvalida, "2019"));
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
        assertThrows(DataInvalidaException.class,
                () -> DataUtils.getDiaAsInt(dataInvalida, "1692"));
    }

    @Test
    public void testComparaData() {
        assertEquals(0, DataUtils.comparaDatas("20190229",
                "20190229", "2019"));
        assertEquals(1, DataUtils.comparaDatas("20190229",
                "20190228", "2019"));
        assertEquals(-1, DataUtils.comparaDatas("20190227",
                "20190228", "2019"));
        assertEquals(1, DataUtils.comparaDatas("20001010",
                "15001010", "2019"));
    }

    @Test
    public void testAdicionaData() {
        assertEquals("20190201", DataUtils.adicionaDia("20190131", "2016"));
        assertEquals("20200229", DataUtils.adicionaDia("20200228", "2020"));
        assertEquals("20200301", DataUtils.adicionaDia("20200229", "2020"));
        assertEquals("20190301", DataUtils.adicionaDia("20190228", "2016"));
        assertEquals("20190202", DataUtils.adicionaDia("20190201", "2016"));
        assertEquals("20190302", DataUtils.adicionaDia("20190301", "2016"));
        assertEquals("20190402", DataUtils.adicionaDia("20190401", "2016"));
        assertEquals("20190601", DataUtils.adicionaDia("20190531", "2016"));
        assertEquals("20190701", DataUtils.adicionaDia("20190630", "2019"));
        assertEquals("20190602", DataUtils.adicionaDia("20190601", "2016"));
        assertEquals("20190801", DataUtils.adicionaDia("20190731", "2016"));
        assertEquals("20190802", DataUtils.adicionaDia("20190801", "2016"));
        assertEquals("20190902", DataUtils.adicionaDia("20190901", "2016"));
        assertEquals("20191002", DataUtils.adicionaDia("20191001", "2016"));
        assertEquals("20191102", DataUtils.adicionaDia("20191101", "2016"));
        assertEquals("20191216", DataUtils.adicionaDia("20191215", "2016"));
        assertEquals("20200101", DataUtils.adicionaDia("20191231", "2019"));
    }

    @Test
    public void testGetDiaDaSemana() {
        assertEquals(1, DataUtils.getDiaDaSemana("20190101",
                "2020", "20190101", "1"));
        assertEquals(2, DataUtils.getDiaDaSemana("20190102",
                "2020", "20190101", "1"));
        assertEquals(3, DataUtils.getDiaDaSemana("20190103",
                "2020", "20190101", "1"));
        assertEquals(1, DataUtils.getDiaDaSemana("20160301",
                "2016", "20160228", "6"));
        assertEquals(0, DataUtils.getDiaDaSemana("20160229",
                "2016", "20161231", "5"));
        assertEquals(1, DataUtils.getDiaDaSemana("20191231",
                "2016", "20190101", "1"));
    }

    @Test
    public void coberturaException(){
        new DataInvalidaException("Mensagem");
        new DataInvalidaException("Mensagem", new Throwable());
    }

}
