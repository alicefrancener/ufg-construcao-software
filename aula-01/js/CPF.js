/**
 * Funções para verificar validade de CPFs
 */

module.exports = {
    f1: converteCaracteresEmInteiros,
    f2: validarDigitosCPF,
    f3: validarDigitosCPF2
};

/**
 * Transforma caracteres numéricos em inteiros
 *
 * @param {String} cpf String que contém CPF
 *
 * @returns {Array} Vetor contendo em cada posição um dígito do CPF como inteiro
 */
function converteCaracteresEmInteiros(cpf) {
    var digitosCpf = [];
    for (var i = 0; i < cpf.length; i++) {
        digitosCpf[i] = parseInt(cpf.charAt(i));
    }

    return digitosCpf;
}

/**
 * Avalia se CPF fornecido é válido dado seus dígitos verificados (dois últimos dígitos)
 *
 * @param {String} cpf String que contém CPF
 *
 * @returns {boolean} Verdadeiro, se dígitos verificadores do CPF estiverem corretos, Falso, se não
 *
 * @throws {RangeError} Se cpf tem mais que 11 caracteres
 * @throws {TypeError} Se cpf é null ou undefined
 */
function validarDigitosCPF(cpf) {
    if (cpf === null || cpf === undefined){
        throw new TypeError("Argumento null ou undefined");
    }
    if (cpf.length != 11) {
        throw new RangeError("CPF deve ter 11 dígitos: " + cpf);
    }

    var digitosCpf = converteCaracteresEmInteiros(cpf);
    var calculoParcialDigito10 = digitosCpf[0];
    var calculoParcialDigito11 = digitosCpf[1];
    ;
    for (var i = 1; i < 9; i++) {
        calculoParcialDigito10 += digitosCpf[i] * (i + 1);
    }

    for (var i = 2; i < 10; i++) {
        calculoParcialDigito11 += digitosCpf[i] * i;
    }

    var calculoFinalDigito10 = (calculoParcialDigito10 % 11) % 10;
    var calculoFinalDigito11 = (calculoParcialDigito11 % 11) % 10;

    return calculoFinalDigito10 == digitosCpf[9] && calculoFinalDigito11 == digitosCpf[10];
}

/**
 * Avalia se CPF fornecido é válido dado seus dígitos verificados (dois últimos dígitos)
 *
 * @param {String} cpf String que contém CPF
 *
 * @returns {boolean} Verdadeiro, se dígitos verificadores do CPF estiverem corretos, Falso, se não
 *
 * @throws {RangeError} Se cpf tem mais que 11 dígitos
 * @throws {TypeError} Se cpf é null ou undefined
 */
function validarDigitosCPF2(cpf) {
    if (cpf === null || cpf === undefined){
        throw new TypeError("Argumento null ou undefined");
    }
    if (cpf.length != 11) {
        throw new RangeError("CPF deve ter 11 dígitos: " + cpf);
    }

    var digitosCpf = converteCaracteresEmInteiros(cpf);
    var calculoParcialDigito11 = digitosCpf[8];
    var calculoParcialDigito10 = calculoParcialDigito11;
    for (var c = 7; c >= 0; c--) {
        calculoParcialDigito11 += digitosCpf[c];
        calculoParcialDigito10 += calculoParcialDigito11;
    }
    var calculoFinalDigito10 = (calculoParcialDigito10 % 11) % 10;
    var calculoFinalDigito11 = ((calculoParcialDigito10 - calculoParcialDigito11 + 9 * digitosCpf[9]) % 11) % 10;

    return calculoFinalDigito10 === digitosCpf[9] && calculoFinalDigito11 === digitosCpf[10];
}