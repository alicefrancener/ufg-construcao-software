package com.github.alicefng.cs.aula8.domain;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public final class OutputArquivo {

    /**
     * Construtor privado para evitar instanciação de classe utilitária.
     */
    private OutputArquivo() {
    }

    /**
     * Imprime os quatro primeiros bytes (inteiro de 32 bits) em formato
     * hexadecimal na saída padrão.
     *
     * @param caminhoArquivo Caminho do arquivo a ser impresso
     * @throws IOException Se houver problema na leitura do arquivo
     */
    public static void imprimeHexadecimal(final String caminhoArquivo)
            throws IOException {
        FileInputStream fis = new FileInputStream(caminhoArquivo);
        DataInputStream dis = new DataInputStream(fis);

        int valor = dis.readInt();
        System.out.println(Integer.toHexString(valor));

        dis.close();
    }
}
