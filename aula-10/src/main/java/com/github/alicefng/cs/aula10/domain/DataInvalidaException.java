package com.github.alicefng.cs.aula10.domain;

/**
 * Exceção para datas inválidas.
 */
public class DataInvalidaException extends RuntimeException implements
        java.io.Serializable {

    /**
     * Serial para resolver MissingSerialVersionUID.
     */
    private static final long serialVersionUID = 1;

    /**
     * Constroi uma exceção sem mensagem.
     */
    public DataInvalidaException() {
        super();
    }

    /**
     * Constroi uma exceção somente com mensagem.
     *
     * @param mensagem A mensagem a ser enviada quanto a exceção é lançada.
     */
    public DataInvalidaException(final String mensagem) {
        super(mensagem);
    }

    /**
     * Constroi uma exceção com mensagem e causa.
     *
     * @param mensagem A mensagem a ser enviada quanto a exceção é lançada.
     * @param causa    Causa raiz da exceção (root case)
     */
    public DataInvalidaException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
    }
}
