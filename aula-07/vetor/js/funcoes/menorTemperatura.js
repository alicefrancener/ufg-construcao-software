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

    let menorTemperatura = temperaturas[0];
    for (let i = 1; i < temperaturas.length; i++) {
        if (menorTemperatura > temperaturas[i]) {
            menorTemperatura = temperaturas[i];
        }
    }

    return menorTemperatura;
}

module.exports = {menorTemperatura};
