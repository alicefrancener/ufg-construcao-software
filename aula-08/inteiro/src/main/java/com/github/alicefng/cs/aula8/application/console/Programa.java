package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.OutputArquivo;

import java.io.IOException;

public class Programa {

    public static void main(final String[] args) {
        try {
            OutputArquivo.imprimeHexadecimal(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
