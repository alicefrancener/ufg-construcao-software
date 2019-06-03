/**
 * Produz a quantidade de vezes que uma palavra ocorre em um vetor de
 * palavras.
 *
 * @param {String} palavra A palavra a ser contada
 * @param {Array} frase O array de palavras a ser comparado
 *
 * @returns {number} Quantidade de vezes que a palavra ocorre em uma Array
 *
 * @throws {TypeError} Se argumento for null ou undefined
 * @throws {TypeError} Se argumento não for String
 */
function contePalavra(palavra, frase) {
    if (palavra === null || palavra === undefined
        || frase === null || frase === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }
    if (typeof palavra !== "string") {
        throw new TypeError("Argumento deve ser String");
    }
    for (let i = 0; i < frase.length; i++) {
        if (typeof frase[i] !== "string") {
            throw new TypeError("Argumento deve ser String");
        }
    }

    let quantidade = 0;
    for (let i = 0; i < frase.length; i++) {
        if (palavra === frase[i]) {
            quantidade++;
        }
    }

    return quantidade;
}

module.exports = {contePalavra: contePalavra};
