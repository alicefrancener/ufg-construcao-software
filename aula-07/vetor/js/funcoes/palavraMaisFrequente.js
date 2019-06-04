const funcao = require("../funcoes/contePalavra.js");

/**
 * Retorna a palavra mais frequence em uma determinada sequêcia de
 * caracteres.
 *
 * @param {string} frase Frase a ser analisada
 *
 * @return {string} Palavra que ocorre com mais frequência na frase analisada
 *
 * @throws {TypeError} Se argumento for null ou undefined
 * @throws {TypeError} Se argumento não for string
 */
function palavraMaisFrequente(frase) {
    if (frase === null || frase === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }
    if (typeof frase !== "string") {
        throw new TypeError("Argumento deve ser String");
    }

    const palavras = frase.split(" ");

    let palavra = palavras[0];
    let frequenciaPalavra = funcao.contePalavra(palavra, palavras);

    for (let i = 0; i < palavras.length; i++) {
        let frequenciaProxPalavra = funcao.contePalavra(palavras[i], palavras);
        if (frequenciaPalavra < frequenciaProxPalavra) {
            palavra = palavras[i];
            frequenciaPalavra = frequenciaProxPalavra;
        }
    }

    return palavra;
}

module.exports = {palavraMaisFrequente};
