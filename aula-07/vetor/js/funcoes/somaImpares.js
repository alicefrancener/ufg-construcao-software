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

    return numeros.filter(n => n % 2 === 1).reduce((a, b) => a + b);
}

module.exports = {somaImpares};
