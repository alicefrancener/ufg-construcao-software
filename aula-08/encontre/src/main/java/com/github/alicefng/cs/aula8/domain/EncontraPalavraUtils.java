package com.github.alicefng.cs.aula8.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;

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
     * @throws IOException              Se houver problema na leitura do arquivo
     * @throws IllegalArgumentException Se arquivo estiver vazio
     */
    public static String encontraPalavra(final String caminhoArquivo,
                                         final String palavraProcurada) {

        final File checkFile =
                new File(FilenameUtils.getFullPath(caminhoArquivo),
                        FilenameUtils.getName(caminhoArquivo));

        if (!checkFile.exists()) {
            throw new IllegalArgumentException("Arquivo não existe");
        }

        if (checkFile.length() == 0) {
            throw new IllegalArgumentException("Arquivo está vazio.");
        }

        BufferedReader br = null;
        final StringBuilder sb = new StringBuilder();

        try {
            final Charset utf8 = Charset.forName("UTF-8");
            br = Files.newBufferedReader(Paths.get(caminhoArquivo), utf8);

            String conteudoLinha;
            int numeroLinha = 1;
            int ocorrenciaTotal = 0;

            while ((conteudoLinha = br.readLine()) != null) {
                int numeroColuna = conteudoLinha.indexOf(palavraProcurada);
                if (numeroColuna != -1) {
                    sb.append(String.format("L%d C%d: %s%n",
                            numeroLinha, numeroColuna, conteudoLinha));
                }
                numeroLinha++;

                ocorrenciaTotal = ocorrenciaTotal
                        + conteOcorrencias(palavraProcurada, conteudoLinha);

            }

            sb.insert(0, String.format("Encontradas: %d%n", ocorrenciaTotal));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
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
