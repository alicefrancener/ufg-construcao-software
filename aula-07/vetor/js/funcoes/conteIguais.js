/**
 * Produz a contagem em que determinado número ocorre em um vetor.
 *
 * @param {Array} numeros Vetor contendo números a serem comparados
 * @param {number} comparador Valor a ser comparado com vetor
 *
 * @returns {number} Quantidade de vezes que o valor comparado ocorre no vetor
 *
 * @throws {TypeError} Se argumento for null ou undefined
 * @throws {TypeError} Se argumento não for númerico
 */
function conteIguais(numeros, comparador) {
    if (numeros === null || numeros === undefined
        || comparador === null || comparador === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }
    if (isNaN(comparador)) {
        throw new TypeError("Argumento deve ser número");
    }
    for (let i = 0; i < numeros.length; i++) {
        if (isNaN(numeros[i])) {
            throw new TypeError("Argumento deve ser número");
        }
    }

    let quantidade = 0;
    for (let i = 0; i < numeros.length; i++) {
        if (numeros[i] === comparador) {
            quantidade++;
        }
    }

    return quantidade;
}

module.exports = {conteIguais};
