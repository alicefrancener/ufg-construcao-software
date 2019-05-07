/**
 * Operações matemáticas básicas
 */

module.exports = {
    f1: possuiPropriedade3025,
    f2: restoDaDivisaoInteira,
    f3: produto,
    f4: potencia,
    f5: estaDentroDoIntervalo,
    f6: possuiPropriedade153,
    f7: somaDosPrimeirosNaturais,
    f8: fatorial,
    f9: pi,
    f10: logaritmoNatural,
    f11: razaoAurea,
    f12: isQuadradoPerfeito,
    f13: raizQuadrada,
    f14: isPrimo,
    f15: maiorDivisorComumMetodo1,
    f16: maiorDivisorComumMetodo2,
    f17: determinarNumerosPrimos,
    f18: calcularPolinomio,
    f19: obterEnesimoTermoDaSequenciaDeFibonacci
};

/**
 * Produz o resto da divisão entre dois numeros inteiros
 *
 * @param {number} numerador O numerador da divisão
 * @param {number} denominador O denominador da divisão
 *
 * @returns {number} O resto obtido na divisão: numerador/denominador
 *
 * @throws {RangeError}  Se o numerador for <= 0 ou se o denominador for <0
 */
function restoDaDivisaoInteira(numerador, denominador) {
    if (!Number.isInteger(numerador) || !Number.isInteger(denominador)) {
        throw new TypeError("argumentos devem ser inteiros");
    }
    if (numerador === undefined || numerador === null || denominador === null || denominador === undefined) {
        throw new TypeError("argumento null ou undefined");
    }
    if (numerador <= 0 || denominador < 0) {
        throw new RangeError("numerador ou denominador inválido: numerado = " + numerador + ", denominador = " + denominador);
    }

    var resto = numerador;
    while (resto >= denominador) {
        resto = resto - denominador;
    }

    return resto;
}

/**
 * Resulta no produto entre o primeiro e o segundo argumento
 *
 * @param {number} multiplicando
 * @param {number} multiplicador
 *
 * @returns {number} O produto de dois numeros: multiplicando*multiplicador
 *
 * @throws {RangeError} Se o multiplicando ou multiplicador for menor que 0
 */
function produto(multiplicando, multiplicador) {
    if (multiplicando < 0 || multiplicador < 0) {
        throw new RangeError("multiplicando ou multiplicador inválido: multiplicando = " + multiplicando + ", multiplicador = " + multiplicador);
    }
    var totalParcelas = multiplicando;
    var parcela = multiplicador;
    if (multiplicador < multiplicando) {
        totalParcelas = multiplicador;
        parcela = multiplicando;
    }
    var produto = 0;
    for (var i = 1; i <= totalParcelas; i += 1) {
        produto += parcela;
    }
    return produto;
}

/**
 * Produz o resultado da exponenciação, considerando base e expoente inteiros
 *
 * @param {number} base A base da exponenciação
 * @param {number} expoente O expoente da exponenciação
 *
 * @returns {number} O resultado da base elevada ao expoente
 *
 * @throws {RangeError} Se o base ou expoente forem menores que 0
 */
function potencia(base, expoente) {
    if (base < 0 || expoente < 0) {
        throw new RangeError("base ou expoente inválido: base = " + base + ", expoente = " + expoente);
    }
    var potencia = 1;
    for (var i = 1; i <= expoente; i++) {
        potencia = produto(potencia, base);
    }
    return potencia;
}

/**
 * Avalia se um número está dentro ou fora de um dado intervalo
 *
 * @param {number} numero O número a ser avaliado
 * @param {number} intervaloInferior O Intervalo superior a ser considerado
 * @param {number} intervaloSuperior O intervalo inferior a ser considerado
 *
 * @returns {boolean} Verdadeiro, se o número está dentro do intervalo fornecido, e Falso, caso esteja fora do intervalo
 */
function estaDentroDoIntervalo(numero, intervaloInferior, intervaloSuperior) {
    return (numero >= intervaloInferior && numero <= intervaloSuperior) ? true : false;
}

/**
 * Avalia se o argumento possui a propriedade matemática 3025
 *     Essa propriedade é tal que 30 + 25 = 55 e o quadrado desta soma resulta no próprio número, 55^2 = 3025
 *
 * @param {number} numero O número a ser avaliado
 *
 * @returns {boolean} Verdadeiro, se o número possui a propriedade, Falso, caso não possua
 *
 * @throws {RangeError} Se o argumento está fora do intervalo permitido [0,9999]
 *
 */
function possuiPropriedade3025(numero) {
    if (!estaDentroDoIntervalo(numero, 0, 9999)) {
        throw new RangeError("numero inválido: " + numero);
    }
    var quociente = parseInt(numero / 100);
    var resto = restoDaDivisaoInteira(numero, 100);
    var resultado = potencia(quociente + resto, 2);
    return numero === resultado;
}

/**
 * Avalia se o argumento possuia a propriedade matemática 153
 *     Essa propriedade é tal que a soma do cubo dos dígidos do número resulta no próprio número
 *     Exemplo numero 153: 1^3 + 5^3 + 3^3 = 153
 *
 * @param {number} numero O número a ser avaliado
 *
 * @returns {boolean} Verdadeiro, se o número possui a propriedade, Falso, caso não possua
 *
 * @throws {RangeError} Se o argumento está fora do intervalo permitido [100,999]
 *
 */
function possuiPropriedade153(numero) {
    if (!estaDentroDoIntervalo(numero, 100, 999)) {
        throw new RangeError("numero inválido: " + numero);
    }
    var quociente = parseInt(numero / 100);
    var resto = restoDaDivisaoInteira(numero, 100);
    var quociente2 = parseInt(resto / 10);
    var resto2 = restoDaDivisaoInteira(resto, 10);
    var resultado = potencia(quociente, 3) + potencia(quociente2, 3) + potencia(resto2, 3);
    return resultado === numero;
}

/**
 * Produz a soma dos números naturais, iniciando em 0 até o argumento
 *
 * @param {number} numero O número até o qual deve-se produzir a soma dos naturais
 *
 * @returns {number} A soma dos naturais
 *
 * @throws {RangeError} Se o argumento for menor que 1
 */
function somaDosPrimeirosNaturais(numero) {
    if (numero < 1) {
        throw new RangeError("numero inválido: " + numero);
    }
    var soma = 1;
    for (var i = 2; i <= numero; i++) {
        soma += i;
    }
    return soma;
}

/**
 * Produz o fatorial do argumento
 *
 * @param {number} numero O número que se quer calcular o fatorial
 *
 * @returns {number} A fatoração do argumento
 *
 * @throws {RangeError} Se o argumento for menor que 1
 */
function fatorial(numero) {
    if (numero < 1) {
        throw new RangeError("numero inválido: " + numero);
    }
    var fatorial = 1;
    for (var i = 2; i <= numero; i++) {
        fatorial *= i;
    }
    return fatorial;
}

/**
 * Produz o valor de Pi de acordo com a precisão informada no argumento
 *
 * @param {number} precisao Valor que representa a precisão desejada (quanto maior, maior a precisão de Pi)
 *
 * @returns {number} O valor de pi, dada a precisão
 *
 * @throws {RangeError} Se precisao for menor que 1
 */
function pi(precisao) {
    if (precisao < 1) {
        throw new RangeError("precisao inválido: " + precisao);
    }
    var pi = 0, s = -1, d = -1;
    for (var i = 1; i <= precisao; i++) {
        d += 2;
        s = -1 * s;
        pi += 4 * s / d;
    }
    return pi;
}

/**
 * Produz o logaritmo natural (base número de euler) de um expoente fornecido, e a precisão desejada
 *
 * @param {number} expoente O expoente para o qual se quer calcular o logaritmo natural
 * @param {number} precisao A precisão desejada no resultado do logaritmo calculado
 *
 * @returns {number} Resultado do logaritmo natural, dado o expoente e precisão informadas
 *
 * @throws {RangeError} Se expoente for menor que 1 ou se precisao for menor que 2
 */
function logaritmoNatural(expoente, precisao) {
    if (expoente < 1 || precisao < 2) {
        throw new RangeError("expoente ou precisao inválido: expoente = " + expoente + ", precisao = " + precisao);
    }
    var logaritmoNatural = 1 + expoente;
    var numerador = expoente;
    var denominador = 1;
    for (var i = 2; i <= precisao; i++) {
        numerador *= numerador;
        denominador += i;
        logaritmoNatural += numerador / denominador;
    }
    return logaritmoNatural;
}

/**
 * Produz a razão áurea considerando dois números inteiros positivos
 *
 * @param {number} numeroA O primero inteiro a ser considerado
 * @param {number} numeroB O segundo inteiro a ser considerado
 *
 * @param {number} precisao A precisão desejada do resultado retornado, quanto maior o valor, maior a precisão
 *
 * @returns {number} A razão áurea de acordo com a precisão informada
 *
 * @throws {RangeError} Se o numeroA for menor que 0 ou maior/igual ao numeroB ou se a precisão é menor ou igual a 0
 */
function razaoAurea(numeroA, numeroB, precisao) {
    if (numeroA < 0 || numeroA >= numeroB || precisao <= 0) {
        throw new RangeError("numeroA, numeroB ou precisao inválido: numeroA = " + numeroA + ", numeroB = " + numeroB + ", precisao = " + precisao);
    }
    var numerador = numeroB;
    var denominador = numeroA;
    for (var i = 1; i <= precisao; i++) {
        var temporario = numerador;
        numerador += denominador;
        denominador = temporario;
    }
    return numerador / denominador;
}

/**
 * Avalia se o argumento é um quadrado perfeito
 *
 * @param {number} numero O argumento a ser avaliado
 *
 * @returns {boolean} Verdadeito, se o numero é um quadrado perfeito, Falso, se não
 *
 * @throws {RangeError} Se o argumento é menor que 1
 */
function isQuadradoPerfeito(numero) {
    if (numero < 1) {
        throw new RangeError("numero inválido: " + numero);
    }
    var soma = 1;
    for (var i = 3; soma < numero; i += 2) {
        soma += i;
    }
    return soma == numero;
}

/**
 * Produz o resultado de um número elevado ao quadrado, de acordo com a precisão fornecida
 *
 * @param {number} radicando O número que se deseja calcular a raiz quadrada
 * @param {number} precisao A precisão desejada do resultado retornado, quanto maior o valor, maior a precisão
 *
 * @returns {number} O resultado da raiz quadrada do radicando dada a precisao fornecida
 *
 * @throws {RangeError} Se o argumento é menor ou igual a 0
 */
function raizQuadrada(radicando, precisao) {
    if (radicando <= 0) {
        throw new RangeError("radicando inválido: " + radicando);
    }
    var raizQuadrada = 1;
    for (; precisao >= 0; precisao--) {
        raizQuadrada = (raizQuadrada + radicando / raizQuadrada) / 2;
    }
    return raizQuadrada;
}

/**
 * Avalia se o argumento é um número primo
 *
 * @param {number} numero O número a ser avaliado se é primo
 *
 * @returns {boolean} Verdadeiro, se o argumento é primo; Falso, se não é primo
 *
 * @throws {RangeError} Se o argumento é menor ou igual a 1
 */
function isPrimo(numero) {
    if (numero <= 1) {
        throw new RangeError("numero inválido: " + numero);
    }
    for (var i = 2; i < numero; i++) {
        if (restoDaDivisaoInteira(numero, i) == 0) {
            return false;
        }
    }
    return true;
}

/**
 * Calcula o maior divisor comum entre dois números inteiros
 *
 * @param {number} numeroA O primeiro número a ser avaliado
 * @param {number} numeroB O segundo número a ser avaliado
 *
 * @returns {number} O maior divisor comum entre os argumentos fornecidos
 *
 * @throws {RangeErros} Se o numeroB for maior que o numeroA, ou se o numero B for menor que 1
 */
function maiorDivisorComumMetodo1(numeroA, numeroB) {
    if (numeroB > numeroA || numeroB <= 0) {
        throw new RangeError("numeroA ou numeroB inválido: numeroA = " + numeroA + ", numeroB = " + numeroB);
    }
    while (numeroB !== 0) {
        var temporario = restoDaDivisaoInteira(numeroA, numeroB);
        numeroA = numeroB;
        numeroB = temporario;
    }
    return numeroA;
}

/**
 * Calcula o maior divisor comum entre dois números inteiros
 *
 * @param {number} numeroA O primeiro número a ser avaliado
 * @param {number} numeroB O segundo número a ser avaliado
 *
 * @returns {number} O maior divisor comum entre os argumentos fornecidos
 *
 * @throws {RangeErros} Se o numeroB for maior que o numeroA, ou se o numero B for menor que 1
 */
function maiorDivisorComumMetodo2(numeroA, numeroB) {
    if (numeroB > numeroA || numeroB <= 0) {
        throw new RangeError("numeroA ou numeroB inválido: numeroA = " + numeroA + ", numeroB = " + numeroB);
    }
    while (numeroA !== numeroB) {
        (numeroA > numeroB) ? numeroA -= numeroB : numeroB -= numeroA;
    }
    return numeroA;
}

/**
 * Produz um vetor que indica quais número são primos (todos as posições do vetor que possuem o valor 1 são primos)
 *
 * @param {number} vetorZeros O vetor com a quantidade de números a serem avaliados (devem todos conter valor 0)
 *
 * @returns {Array} Vetor nos quais as posições com valor 1 são primos
 */
function determinarNumerosPrimos(vetorZeros) {
    if (vetorZeros.length <= 1) {
        throw new Error("vetorZeros.length inválido: " + vetorZeros.length);
    }
    for (var i = 1; i < vetorZeros.length; i++) {
        if (vetorZeros[i] != 0) {
            throw new RangeError("vetorZeros[" + i + "] inválido: " + vetorZeros[i]);
        }
    }
    var limite = Math.floor(raiz(vetorZeros.length, 100));
    for (var i = 1; i < limite; i++) {
        if (vetorZeros[i] == 0) {
            for (var multiplo = 2 * i; multiplo < vetorZeros.length; multiplo += i) {
                vetorZeros[multiplo] = 1;
            }
        }
    }
    return vetorZeros;
}

/**
 * Produz o resultado do polinômio fornecido
 *
 * @param {number} numero A constante do polinômio
 * @param {number} coeficientes Os coeficientes da constante do polinômio
 *
 * @returns {number} O valor final do polinômio
 *
 * @throws {Error} Se o grau do polinômio for menor que 1
 */
function calcularPolinomio(numero, coeficientes) {
    const grauDoPolinomio = coeficientes.length;
    if (grauDoPolinomio < 1) {
        throw new Error("grau do polinomio inválido: " + grauDoPolinomio);
    }
    var polinomio = coeficientes[grauDoPolinomio - 1];
    for (var i = grauDoPolinomio - 2; i >= 0; i--) {
        polinomio = polinomio * numero + coeficientes[i];
    }
    return polinomio;
}

/**
 * Produz o enésimo termo da sequência de Fibonacci
 *
 * @param enesimoTermo O número da sequência de Fibonacci que se deseja obter
 *
 * @returns {number} O valor do enésimo termo da sequência de Fibonnaci
 *
 * @throws {RangeError} Se o argumento for menor que 0
 */
function obterEnesimoTermoDaSequenciaDeFibonacci(enesimoTermo) {
    if (enesimoTermo < 0) {
        throw new RangeError("enesimoTermo inválido: " + enesimoTermo);
    }
    var termoProximo = 0;
    var termoAtual = 1;
    if (enesimoTermo === 0 | enesimoTermo === 1) {
        return enesimoTermo;
    }
    for (var i = 2; i <= enesimoTermo; i++) {
        var temporario = termoAtual;
        termoAtual = termoAtual + termoProximo;
        termoProximo = temporario;
    }
    return termoAtual;
}