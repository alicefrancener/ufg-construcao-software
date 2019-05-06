/**
 * Funções relavitas a datas e dias da semana
 */


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
 * @throws {DataInvalidaError} Se o dia for menor que 1 ou maior que 31
 */
function diaValido(dia) {
    if (dia < 1 || dia > 31) {
        throw new DataInvalidaError("dia invalido: " + dia);
    }
}

/**
 * Lança erro se o mes informado for inválido
 *
 * @param {number} mes Inteiro que informa mes do ano
 *
 * @throws {DataInvalidaError} Se o mes for menor que 1 ou maior que 12
 */
function mesValido(mes) {
    if (mes < 1 || mes > 12) {
        throw new DataInvalidaError("mes invalido: " + mes);
    }
}

/**
 * Lança erro se o ano informado for inválido
 *
 * @param {number} ano Inteiro que informa ano
 *
 * @throws {DataInvalidaError} Se o ano for menor ou igual a 1753
 */
function anoValido(ano) {
    if (ano <= 1753) {
        throw new DataInvalidaError("ano invalido: " + ano);
    }
}

/**
 * Avalia data, chamando outras funções que lançam exceçõe se o dia, mes ou ano forem inválidos
 *
 * @param {number} dia Inteiro que informa dia do mês
 * @param {number} mes Inteiro que informa mes do ano
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
 * @param {number} dia Inteiro que representa o dia da semana (0 = segunda, 1 = terça, e assim sucessivamente)
 *
 * @returns {string} String que representa o dia da semana
 */
function diaDaSemanaToString(dia) {
    const nomesDiasDaSemana = ["segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado", "domingo"];
    return nomesDiasDaSemana[dia];
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
        mes += 12;
        ano -= 1;
    }
    var calculoDiaDaSemanaParcial = parseInt(dia + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400);
    var calculoDiaDaSemanaFinal = calculoDiaDaSemanaParcial % 7;
    return diaDaSemanaToString(calculoDiaDaSemanaFinal);
}