package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.IsJpeg;

import java.io.IOException;

public final class Programa {

    /**
     * Construtor privado para evitar instanciação.
     */
    private Programa() {
    }

    public static void main(String[] args) {
        try {
            System.out.println(IsJpeg.isJpeg(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
