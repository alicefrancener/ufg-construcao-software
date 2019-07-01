/**
 * Funções relativas a datas e dias da semana
 */

// TODO considere a possibilidade de colocar esta classe em arquivo próprio. Imagine dezenas delas, ...
/**
 * Erro para uma data inválida
 */
class DataInvalidaError extends Error {
    constructor(msg) {
        super(msg);
        this.name = "DataInvalidaError";
    }
}

/**
 * Lança erro se o dia informado for inválido
 *
 * @param {number} dia Inteiro que informa o dia do mês
 *
 * @throws {DataInvalidaError} Se dia for null ou undefined
 * @throws {DataInvalidaError} Se dia não for inteiro
 * @throws {DataInvalidaError} Se dia for menor que 1 ou maior que 31
 */
function diaValido(dia) {
    if (dia === null || dia === undefined) {
        throw new DataInvalidaError("argumento null ou undefined");
    }
    
    if (!Number.isInteger(dia)) {
        throw new DataInvalidaError("argumento deve ser inteiro");
    }
    
    if (dia < 1 || dia > 31) {
        throw new DataInvalidaError("dia invalido: " + dia);
    }
}

/**
 * Lança erro se o mes informado for inválido
 *
 * @param {number} mes Inteiro que informa mes do ano
 *
 * @throws {DataInvalidaError} Se mes for null ou undefined
 * @throws {DataInvalidaError} Se mes não for inteiro
 * @throws {DataInvalidaError} Se mes for menor que 1 ou maior que 12
 */
function mesValido(mes) {
    if (mes === null || mes === undefined) {
        throw new DataInvalidaError("argumento null ou undefined");
    }
    
    if (!Number.isInteger(mes)) {
        throw new DataInvalidaError("argumento deve ser inteiro");
    }
    
    if (mes < 1 || mes > 12) {
        throw new DataInvalidaError("mes invalido: " + mes);
    }
}

/**
 * Lança erro se o ano informado for inválido
 *
 * @param {number} ano Inteiro que informa ano
 *
 * @throws {DataInvalidaError} Se ano for null ou undefined
 * @throws {DataInvalidaError} Se ano não for inteiro
 * @throws {DataInvalidaError} Se ano for menor ou igual a 1753
 */
function anoValido(ano) {
    if (ano === null || ano === undefined) {
        throw new DataInvalidaError("argumento null ou undefined");
    }
    
    if (!Number.isInteger(ano)) {
        throw new DataInvalidaError("argumento deve ser inteiro");
    }
    
    if (ano <= 1753) {
        throw new DataInvalidaError("ano invalido: " + ano);
    }
}

/**
 * Avalia data, chamando outras funções que lançam exceçõe se o dia, mes ou ano
 * forem inválidos
 *
 * @param {number} dia Inteiro que informa dia do mês
 * @param {number} mes Inteiro que informa mes do ano (varia de 1 até 12, inclusive).
 * @param {number} ano Inteiro que informa ano
 *
 * @see {Data#diaValido}
 * @see {Data#mesValido}
 * @see {Data#anoValido}
 */
function validaData(dia, mes, ano) {
    diaValido(dia);
    mesValido(mes);
    anoValido(ano);
}

/**
 * Transforma inteiros (0 a 6) em strings correspondetes aos dias da semana
 *
 * @param {number} dia Inteiro que representa o dia da semana (0 = segunda,
 * 1 = terça, e assim sucessivamente)
 *
 * @returns {string} String que representa o dia da semana
 */
function diaDaSemanaToString(dia) {
    const nomesDiasDaSemana = ["segunda-feira", "terça-feira", "quarta-feira",
        "quinta-feira", "sexta-feira", "sábado", "domingo"];
    return nomesDiasDaSemana[dia].toString;
}

/**
 * Calcula o dia da semana equivalente a data fornecida
 *
 * @param {number} dia Inteiro que informa dia do mês
 * @param {number} mes Inteiro que informa mes do ano
 * @param {number} ano Inteiro que informa ano
 *
 * @see {Data#validaData}
 *
 * @returns {string} O dia da semana correspondente a data fornecida
 */
function diaDaSemana(dia, mes, ano) {
    validaData(dia, mes, ano);
    if (mes === 1 || mes === 2) {
        mes = mes + 12;
        ano = ano - 1;
    }
    // FIXME observe que ano / 400, por exemplo, é sempre "real", enquanto o algoritmo, salvo engano, é div. 
    // Noutras palavras, a expressão abaixo supostamente não é aquela fornecida pelo algoritmo. A alternativa
    // especulada é Math.floor(ano / 400), por exemplo, e não para toda a expressão. 
    const calculoDiaDaSemanaParcial = parseInt(dia + 2 * mes + 3
        * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400);
    const calculoDiaDaSemanaFinal = calculoDiaDaSemanaParcial % 7;

    return diaDaSemanaToString(calculoDiaDaSemanaFinal);
}

module.export = {
    diaDaSemanaToString,
    diaValido,
    mesValido,
    anoValido,
    validaData,
    diaDaSemana
};
