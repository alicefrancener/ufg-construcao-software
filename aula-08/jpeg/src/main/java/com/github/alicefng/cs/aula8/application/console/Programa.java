package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.IsJpegUtils;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Para execução da classe IsJpegUtils.
 */
public final class Programa {

    /**
     * Log uso para registrar mensagens para usuário.
     */
    private static final Logger LOG =
            Logger.getLogger(Programa.class.getName());

    /**
     * Construtor privado para evitar instanciação.
     */
    private Programa() {
    }

    /**
     * Programa para executar pelo terminal e checar se arquivo é jpeg.
     *
     * @param args Caminho do arquivo a ser informado pelo usuário no terminal
     * @throws IOException              se houver problema na leitura do caminho
     *                                  do arquivo
     * @throws IllegalArgumentException se não for passado nenhum argumento
     *                                  pela linha de comando
     */
    public static void main(final String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Nenhum argumento foi "
                    + "fornecido.");
        }

        LOG.info("Checando se arquivo é jpeg");
        System.out.println(IsJpegUtils.isJpeg(args[0]));
    }

}
