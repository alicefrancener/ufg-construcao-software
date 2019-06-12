package com.github.alicefng.cs.aula8.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Classe utilitária para verificar se arquivo é de extensão jpeg.
 */
public final class IsJpegUtils {

    /**
     * Primeiros 2 bytes em hexadecimal de um aquivo jpeg.
     */
    // FIXME por que nao PRIMEIRO_BYTE = 0xFF e assim por diante, bem mais eficiente e mais claro!
    public static final String JPEG_INICIO = "FF D8";

    /**
     * Dois últimos 2 bytes em hexadecimal de um aquivo jpeg.
     */
    public static final String JPEG_FIM = "FF D9";

    /**
     * Construtor privado para não permitir instanciação da classe.
     */
    private IsJpegUtils() {
    }

    /**
     * Transforma bytes em hexadecimal.
     *
     * @param bytes Vetor de bytes
     * @return String com dados de bytes convertidos para caracteres
     */
    public static String byteToHex(final byte[] bytes) {
        final StringBuilder sb = new StringBuilder();
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
        final Path path = Paths.get(caminhoArquivo);
        
        // FIXME Estamos aprendendo, mas não esqueça, a sentença abaixo é imperdoável!
        // Precisamos ler apenas 4 bytes, e você lê todo o arquivo? Memória, CPU, ...
        final byte[] bytesArquivo = Files.readAllBytes(path);

        // FIXME operacao ineficiente byteToHex é relevante para exibição, não para comparação!
        final String hexArquivo = byteToHex(bytesArquivo);

        final int primeiroHex = 0;
        final int segundoHex = 5;
        final int penultimoHex = hexArquivo.length() - 6;
        final int ultimoHex = hexArquivo.length() - 1;

        return hexArquivo.substring(primeiroHex, segundoHex).equals(JPEG_INICIO)
                && hexArquivo.substring(penultimoHex, ultimoHex)
                .equals(JPEG_FIM);
    }

}
