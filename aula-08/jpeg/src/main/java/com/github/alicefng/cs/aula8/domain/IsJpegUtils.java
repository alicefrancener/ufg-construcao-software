package com.github.alicefng.cs.aula8.domain;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
            throw new IllegalArgumentException("Arquivo não contém dados "
                    + "suficientes.");
        }

        final InputStream is = Files.newInputStream(Paths.get(caminhoArquivo));
        final String primeiroByteHex = String.format("%02x", is.read());
        final String segundoByteHex = String.format("%02x", is.read());

        if (primeiroByteHex.equals(PRIMEIRO_BYTE)
                & segundoByteHex.equals(SEGUNDO_BYTE)) {

            String penultimoByteHex = "";
            String ultimoByteHex = "";
            int auxiliar = 0;

            while ((auxiliar = is.read()) != -1) {
                penultimoByteHex = ultimoByteHex;
                ultimoByteHex = String.format("%02x", auxiliar);
            }

            if (penultimoByteHex.equals(PENULTIMO_BYTE)
                    & ultimoByteHex.equals(ULTIMO_BYTE)) {

                is.close();
                return true;

            }
        }

        is.close();
        return false;
    }

}
