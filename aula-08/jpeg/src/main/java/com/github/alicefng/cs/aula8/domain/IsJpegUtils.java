package com.github.alicefng.cs.aula8.domain;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Classe utilitária para verificar se arquivo é de extensão jpeg.
 */
public final class IsJpegUtils {

    /**
     * Primeiro byte em hexadecimal de um aquivo jpeg.
     */
    public static final String PRIMEIRO_BYTE = "ff";

    /**
     * Segundo byte em hexadecimal de um arquivo jpeg.
     */
    public static final String SEGUNDO_BYTE = "d8";

    /**
     * Penúltimo byte em hexadecimal de um aquivo jpeg.
     */
    public static final String PENULTIMO_BYTE = "ff";

    /**
     * Último byte em hexadecimal de um aquivo jpeg.
     */
    public static final String ULTIMO_BYTE = "d9";


    /**
     * Construtor privado para não permitir instanciação da classe.
     */
    private IsJpegUtils() {
    }

    /**
     * Checa se determinado arquivo é de extensão jpeg.
     *
     * @param caminhoArquivo path do arquivo a ser avaliado
     * @return true, se arquivo for de extensão jpeg,
     * false, se não for um arquivo jpeg
     * @throws IOException              se houver problema na leitura do caminho
     *                                  do arquivo
     * @throws IllegalArgumentException se o arquivo não contiver dados para
     *                                  leitura.
     */
    public static boolean isJpeg(final String caminhoArquivo)
            throws IOException {

        final File checkFile = new File(caminhoArquivo);
        if (checkFile.length() == 0) {
            throw new IllegalArgumentException("Arquivo não contém dados " +
                    "suficientes.");
        }

        final FileInputStream fis = new FileInputStream(caminhoArquivo);
        final String primeiroHex = String.format("%02x", fis.read());
        final String segundoHex = String.format("%02x", fis.read());

        if (primeiroHex.equals(PRIMEIRO_BYTE)
                & segundoHex.equals(SEGUNDO_BYTE)) {

            String penultimoHex = "";
            String ultimoHex = "";
            int auxiliar = 0;

            while ((auxiliar = fis.read()) != -1) {
                penultimoHex = ultimoHex;
                ultimoHex = String.format("%02x", auxiliar);
            }

            if (penultimoHex.equals(PENULTIMO_BYTE)
                    & ultimoHex.equals(ULTIMO_BYTE)) {

                fis.close();
                return true;

            }
        }

        fis.close();
        return false;
    }

}
