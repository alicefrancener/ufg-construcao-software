package com.github.alicefng.cs.aula12.application.api;

import com.github.alicefng.cs.aula12.domain.NumeroUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrafiaController {

    @CrossOrigin
    @RequestMapping("ds")
    public String grafiaNumero(@RequestParam(value = "numero",
            defaultValue = "não fornecido") String arg) {

        final int numero = Integer.parseInt(arg);

        return NumeroUtils.getGrafiaNumeroCardinal(numero);
    }

}
