package com.github.alicefng.cs.aula8.domain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EncontraPalavra {

    /**
     * Construtor privado para não haver instanciação da classe.
     */
    private EncontraPalavra() {
    }

    /**
     * Produz relatório sobre em que linhas e colunas determinada palavra
     * ocorre em um arquivo texto.
     *
     * @param caminhoArquivo   O path do arquivo a ser utilizado para buscar a
     *                         palavra
     * @param palavraProcurada A palavra a ser procurada no arquivo texto
     * @return Relatório do número de ocorrências total da palavra procurada
     * no arquivo, bem como de cada linha e coluna em que a palavra ocorre
     * @throws IOException Se houver problema na leitura do arquivo
     */
    public static String encontraPalavra(final String caminhoArquivo,
                                         final String palavraProcurada)
            throws IOException {

        FileInputStream fis = new FileInputStream(caminhoArquivo);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String linha;
        StringBuilder sb = new StringBuilder();
        int numeroLinha = 1;
        int ocorrenciaTotal = 0;

        while ((linha = br.readLine()) != null) {
            if (linha.contains(palavraProcurada)) {
                sb.append("L" + numeroLinha
                        + " C" + linha.indexOf(palavraProcurada) + ": "
                        + linha + "\n");
            }
            numeroLinha++;

            ocorrenciaTotal = ocorrenciaTotal
                    + conteOcorrencias(palavraProcurada, linha);
        }

        br.close();

        return "Encontradas: " + ocorrenciaTotal + "\n" + sb.toString();
    }

    /**
     * Produz número de ocorrências de uma palavra em um texto (String).
     *
     * @param palavraProcurada A palavra a ser procurada no texto
     * @param texto            O texto no qual a palavra deve ser procurada
     * @return O número de ocorrências da palavra no texto
     */
    public static int conteOcorrencias(final String palavraProcurada,
                                       final String texto) {
        Pattern p = Pattern.compile(palavraProcurada);
        Matcher m = p.matcher(texto);
        int ocorrencias = 0;
        while (m.find()) {
            ocorrencias++;
        }
        return ocorrencias;
    }

}
