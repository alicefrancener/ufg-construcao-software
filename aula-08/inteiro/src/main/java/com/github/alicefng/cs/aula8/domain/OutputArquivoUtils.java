package com.github.alicefng.cs.aula8.domain;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Classe para gerar output de arquivo.
 */
public final class OutputArquivoUtils {

    /**
     * Construtor privado para evitar instanciação de classe utilitária.
     */
    private OutputArquivoUtils() {
    }

    /**
     * Imprime os quatro primeiros bytes (inteiro de 32 bits) em formato
     * hexadecimal na saída padrão.
     *
     * @param caminhoArquivo Caminho do arquivo a ser impresso
     * @return Os 4 primeiros bytes de um arquivo em formato hexadecimal
     * @throws IOException Se houver problema na leitura do arquivo
     */
    public static String imprimeHexadecimal(final String caminhoArquivo)
            throws IOException {

        final File checkFile = new File(caminhoArquivo);
        final int minimoBytes = 4;
        if (checkFile.length() < minimoBytes) {
            throw new IllegalArgumentException("Arquivo contém quantidade de "
                    + "bytes menor que permitida.");
        }

        final FileInputStream fis = new FileInputStream(caminhoArquivo);
        final DataInputStream dis = new DataInputStream(fis);

        final int valor = dis.readInt();

        dis.close();
        fis.close();

        return Integer.toHexString(valor);
    }
}
