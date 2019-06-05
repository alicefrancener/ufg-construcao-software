package com.github.alicefng.cs.aula8.domain;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public final class LeituraArquivo {

    public static void lerArquivo(String nomeArquivo) throws IOException {
        FileInputStream fis = new FileInputStream(nomeArquivo);
        DataInputStream dis = new DataInputStream(fis);

        int valor = dis.readInt();
        System.out.println(Integer.toHexString(valor));

        dis.close();
    }
}
