package com.github.alicefng.cs.aula8.domain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe utilizada para encontrar palavras em arquivos.
 */
public final class EncontraPalavraUtils {

    /**
     * Construtor privado para não haver instanciação da classe.
     */
    private EncontraPalavraUtils() {
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

        // TODO Apenas para expandir horizontes, ... observe a alternativa abaixo
        // Charset utf8 = Charset.forName("UTF-8");
        // BufferedReader br = Files.newBufferedReader(Paths.get(caminhoArquivo), utf8);
        final FileInputStream fis = new FileInputStream(caminhoArquivo);
        final InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        final BufferedReader br = new BufferedReader(isr);

        String linha;
        StringBuilder sb = new StringBuilder();
        int numeroLinha = 1;
        int ocorrenciaTotal = 0;

        while ((linha = br.readLine()) != null) {
            // TODO Você pode usar indexOf nesta linha e eliminar a chamada a contains
            if (linha.contains(palavraProcurada)) {
                // TODO criação de Strings desnecessárias. Usar String.format
                // (ja comentei o uso de String.format em outra issue ou pull request) conforme ilustrado no fim do método
                sb.append("L" + numeroLinha
                        + " C" + linha.indexOf(palavraProcurada) + ": "
                        + linha + "\n");
            }
            numeroLinha++;

            ocorrenciaTotal = ocorrenciaTotal
                    + conteOcorrencias(palavraProcurada, linha);
        }

        br.close();
        isr.close();
        fis.close();

        return String.format("Encontradas: %d\n%s", ocorrenciaTotal, sb.toString());
        //return "Encontradas: " + ocorrenciaTotal + "\n" + sb.toString();
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
        final Pattern p = Pattern.compile(palavraProcurada);
        final Matcher m = p.matcher(texto);

        int ocorrencias = 0;
        while (m.find()) {
            ocorrencias++;
        }

        return ocorrencias;
    }

}
