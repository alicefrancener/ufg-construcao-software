package com.github.alicefng.cs.aula8.domain;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Classe utilitária para verificar se arquivo é de extensão jpeg.
 */
public final class IsJpeg {

    /**
     * Primeiros 2 bytes em hexadecimal de um aquivo jpeg.
     */
    public static final String JPEG_INICIO = "FF D8";

    /**
     * Dois últimos 2 bytes em hexadecimal de um aquivo jpeg.
     */
    public static final String JPEG_FIM = "FF D9";

    /**
     * Construtor privado para não permitir instanciação da classe.
     */
    private IsJpeg() {
    }

    /**
     * Transforma bytes em hexadecimal.
     *
     * @param bytes Vetor de bytes
     * @return String com dados de bytes convertidos para caracteres
     */
    public static String byteToHex(final byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    /**
     * Checa se determinado arquivo é de extensão jpeg.
     *
     * @param caminhoArquivo path do arquivo a ser avaliado
     * @return true, se arquivo for de extensão jpeg,
     * false, se não for um arquivo jpeg
     * @throws IOException se houver problema na leitura do caminho do arquivo
     */
    public static boolean isJpeg(final String caminhoArquivo)
            throws IOException {
        Path path = Paths.get(caminhoArquivo);
        final byte[] bytesArquivo = Files.readAllBytes(path);

        String hexArquivo = byteToHex(bytesArquivo);

        final int primeiroHex = 0;
        final int segundoHex = 5;
        final int penultimoHex = hexArquivo.length() - 6;
        final int ultimoHex = hexArquivo.length() - 1;


        return hexArquivo.substring(primeiroHex, segundoHex).equals(JPEG_INICIO)
               & hexArquivo.substring(penultimoHex, ultimoHex).equals(JPEG_FIM);
    }

}
