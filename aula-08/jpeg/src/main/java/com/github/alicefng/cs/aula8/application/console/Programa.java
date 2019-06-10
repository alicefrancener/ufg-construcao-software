package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.IsJpeg;

import java.io.IOException;

public class Programa {

    public static void main(String[] args) {
        try {
            System.out.println(IsJpeg.isJpeg(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
