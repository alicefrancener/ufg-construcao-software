/**
 * Produz a quantidade de cada uma das letras do alfabeto em uma sequência
 * de caracteres (não distingue maiúsculas de minísculas).
 *
 * @param {string} frase A frase contendo a sequência de caracteres
 *
 * @returns {number[]} Quantidade de cada uma das letras na String (sendo a
 * posição 0 a letra a, a posição 1 a letra b, e assim sucessivamente)
 *
 * @throws {TypeError} Se argumento for null ou undefined
 * @throws {TypeError} Se argumento não for uma string
 */
function conteLetras(frase) {
    if (frase === null || frase === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }

    if (typeof frase != "string") {
        throw new TypeError("Argumento não é string");
    }

    const fraseMinuscula = frase.toLocaleLowerCase();
    const numeroLetrasAlfabeto = 26;
    const alfabeto = new Array(numeroLetrasAlfabeto).fill(0);

    for (let i = 0; i < fraseMinuscula.length; i++) {
        const caracter = fraseMinuscula.charCodeAt(i);
        if (caracter >= 97 && caracter <= 122) {
            alfabeto[caracter - 97]++;
        }
    }

    return alfabeto;
}

module.exports = {conteLetras};