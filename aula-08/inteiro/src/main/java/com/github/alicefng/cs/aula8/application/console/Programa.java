package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.LeituraArquivo;

import java.io.IOException;

public class Programa {

    public static void main(String[] args) {
        try {
            LeituraArquivo.lerArquivo(args[0]);
            //LeituraArquivo.lerArquivo("C:\\Users\\alice\\Desktop\\test\\LeituraArquivo.class");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
