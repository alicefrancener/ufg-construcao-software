/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula11.application.api;

import com.github.alicefng.cs.aula11.domain.DataUtils;
import com.github.alicefng.cs.aula11.domain.DiferencaDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class DiferencaController {

    @CrossOrigin
    @RequestMapping("ds")
    public DiferencaDTO diferencaDias(@RequestParam(value = "inicio",
            defaultValue = "não fornecida") String arg, @RequestParam(value =
            "fim", defaultValue = "não fornecida") String arg2) {

        LocalDate dataInicial = localDateFromString(arg);
        LocalDate dataFinal = localDateFromString(arg2);

        // Se data não é fornecida, ou é inválida, use o dia corrente.
        if (dataInicial == null || dataFinal == null) {
            dataInicial = LocalDate.now();
            dataFinal = LocalDate.now();
        }

        long diferenca = DataUtils.getDiferencaEntreDatas(dataInicial,
                dataFinal);

        return new DiferencaDTO(diferenca);
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
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(data, fmt);
        } catch (Exception exp) {
            return null;
        }
    }
}
