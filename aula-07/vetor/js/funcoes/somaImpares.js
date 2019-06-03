/**
 * Produz a soma dos números ímpares de um vetor.
 *
 * @param {Array} numeros Vetor contendo inteiros
 *
 * @returns {number} A soma dos ímpares do vetor
 *
 * @throws {TypeError} Se argumento for null ou undefined
 * @throws {TypeError} Se argumento não for inteiro
 */
function somaImpares(numeros) {
    if (numeros === null || numeros === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }
    for (let i = 0; i < numeros.length; i++) {
        if (!Number.isInteger(numeros[i])) {
            throw new TypeError("Argumento deve ser inteiro");
        }
    }

    let soma = 0;
    for (let i = 0; i < numeros.length; i++) {
        if (numeros[i] % 2 === 1) {
            soma = soma + numeros[i];
        }
    }

    return soma;
}

module.exports = {somaImpares: somaImpares};
