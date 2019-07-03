/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula11.application.api;

import com.github.alicefng.cs.aula11.domain.Calendario;
import com.github.alicefng.cs.aula11.domain.DataUtils;
import com.github.alicefng.cs.aula11.domain.DiaDaSemana;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class DiaDaSemanaController {

    @CrossOrigin
    @RequestMapping("ds")
    public DiaDaSemana diaDaSemana(@RequestParam(value = "data", defaultValue =
            "não fornecida") String arg, @RequestParam(value = "data2",
            defaultValue = "não fornecida") String arg2) {

        LocalDate dataInicial = localDateFromString(arg);
        LocalDate dataFinal = localDateFromString(arg2);

        // Se data não é fornecida, ou é inválida, use o dia corrente.
        if (dataInicial == null) {
            dataInicial = LocalDate.now();
        }

        long ds = DataUtils.getDiferencaEntreDatas(dataInicial, dataFinal);

        return new DiaDaSemana(dataInicial, Calendario.semana[1]);
    }

    /**
     * Recupera a instância de {@link LocalDate} correspondente à sequência
     * de caracteres.
     *
     * @param data Sequência de caracteres no formato dd-MM-yyyy.
     * @return Instância de {@link LocalDate} ou {@code null}, se a sequência
     * não está no formato esperado (por exemplo, "01-01-2018")
     */
    public LocalDate localDateFromString(String data) {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(data, fmt);
        } catch (Exception exp) {
            return null;
        }
    }
}
