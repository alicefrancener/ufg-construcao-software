/**
 * Encontra a menor temperatura em um vetor de valores.
 *
 * @param {Array} temperaturas Vetor contendo valores de temperaturas
 *
 * @returns {number} A menor temperatura registrada no vetor
 *
 * @throws {TypeError} Se argumento for null ou undefined
 * @throws {TypeError} Se argumento não for número
 */
function menorTemperatura(temperaturas) {
    if (temperaturas === null || temperaturas === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }
    for (let i = 0; i < temperaturas.length; i++) {
        if (isNaN(temperaturas[i])) {
            throw new TypeError("Argumento deve ser número");
        }
    }

    return Math.min.apply(Math, temperaturas);
}

module.exports = {menorTemperatura};
