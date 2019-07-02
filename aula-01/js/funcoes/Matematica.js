/**
 * Operações matemáticas básicas
 */


/**
 * Checa se argumento é null ou undefined
 *
 * @param argumento O argumento a ser checado
 * @throws {TypeError} Se argumento for null ou undefined
 */
function checkForNullUndefined(argumento) {
    if (argumento === null || argumento === undefined) {
        throw new TypeError("argumento null ou undefined");
    }
}

/**
 * Checa se argumento é inteiro
 *
 * @param argumento O argumento a ser checado
 * @throws {TypeError} Se argumento não for inteiro
 */
function checkForInteger(argumento) {
    if (!Number.isInteger(argumento)) {
        throw new TypeError("argumento não é inteiro");
    }
}

/**
 * Avalia se um número está dentro ou fora de um dado intervalo
 *
 * @param {number} numero O número a ser avaliado
 * @param {number} limiteInferior O Intervalo superior a ser considerado
 * @param {number} limiteSuperior O intervalo inferior a ser considerado
 *
 * @returns {boolean} Verdadeiro, se o número está dentro do intervalo
 * fornecido, e Falso, caso esteja fora do intervalo
 */
function contidoNoInvervalo(numero, limiteInferior, limiteSuperior) {
    return numero >= limiteInferior && numero <= limiteSuperior;
}

/**
 * Produz o resto da divisão entre dois números inteiros.
 *
 * @param {number} numerador O numerador da divisão
 * @param {number} denominador O denominador da divisão
 *
 * @returns {number} O resto obtido na divisão: numerador/denominador
 *
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeError}  Se o numerador for <= 0 ou se o denominador for <0
 */
function restoDaDivisaoInteira(numerador, denominador) {
    const argumentos = [numerador, denominador];
    argumentos.forEach(checkForNullUndefined);
    argumentos.forEach(checkForInteger);

    if (numerador <= 0 || denominador < 0) {
        throw new RangeError("numerador ou denominador inválido: numerado = "
            + numerador + ", denominador = " + denominador);
    }

    let resto = numerador;
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
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeError} Se o multiplicando ou multiplicador for menor que 0
 */
function produto(multiplicando, multiplicador) {
    const argumentos = [multiplicando, multiplicador];
    argumentos.forEach(checkForNullUndefined);
    argumentos.forEach(checkForInteger);

    if (multiplicando < 0 || multiplicador < 0) {
        throw new RangeError("multiplicando ou multiplicador inválido: "
            + "multiplicando = " + multiplicando + ", multiplicador = "
            + multiplicador);
    }

    let totalParcelas = multiplicando;
    let parcela = multiplicador;
    if (multiplicador < multiplicando) {
        totalParcelas = multiplicador;
        parcela = multiplicando;
    }

    let produto = 0;
    for (let i = 1; i <= totalParcelas; i++) {
        produto = produto + parcela;
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
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeError} Se base ou expoente forem menores que 0
 */
function potencia(base, expoente) {
    const argumentos = [base, expoente];
    argumentos.forEach(checkForNullUndefined);
    argumentos.forEach(checkForInteger);

    if (base < 0 || expoente < 0) {
        throw new RangeError("base ou expoente inválido: base = " + base
            + ", expoente = " + expoente);
    }

    let potencia = 1;
    for (let i = 1; i <= expoente; i++) {
        potencia = produto(potencia, base);
    }

    return potencia;
}



/**
 * Avalia se o argumento possui a propriedade matemática 3025
 *     Essa propriedade é tal que 30 + 25 = 55 e o quadrado desta soma resulta
 *     no próprio número, 55^2 = 3025
 *
 * @param {number} numero O número a ser avaliado
 *
 * @returns {boolean} Verdadeiro, se o número possui a propriedade, Falso,
 * caso não possua
 *
 *
 * @throws {TypeError} Se parâmetro for null ou undefined
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se parâmetro está fora do intervalo permitido [0,9999]
 */
function satisfazPropriedade3025(numero) {
    checkForNullUndefined(numero);
    checkForInteger(numero);

    if (!contidoNoInvervalo(numero, 0, 9999)) {
        throw new RangeError("numero inválido: " + numero);
    }

    const quociente = parseInt(numero / 100);
    const resto = restoDaDivisaoInteira(numero, 100);
    const resultado = potencia(quociente + resto, 2);

    return numero === resultado;
}

/**
 * Avalia se o argumento possuia a propriedade matemática 153
 *     Essa propriedade é tal que a soma do cubo dos dígidos do número
 *     resulta no próprio número
 *     Exemplo numero 153: 1^3 + 5^3 + 3^3 = 153
 *
 * @param {number} numero O número a ser avaliado
 *
 * @returns {boolean} Verdadeiro, se o número possui a propriedade,
 * Falso, caso não possua
 *
 * @throws {TypeError} Se parâmetro for null ou undefined
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se parâmetro está fora do intervalo permitido [100,999]
 */
function satisfazPropriedade153(numero) {
    checkForNullUndefined(numero);
    checkForInteger(numero);

    if (!contidoNoInvervalo(numero, 100, 999)) {
        throw new RangeError("numero inválido: " + numero);
    }

    const primeiroDigito = parseInt(numero / 100);
    const resto = restoDaDivisaoInteira(numero, 100);
    const segundoDigito = parseInt(resto / 10);
    const terceiroDigito = restoDaDivisaoInteira(resto, 10);
    const resultado = potencia(primeiroDigito, 3) + potencia(segundoDigito, 3)
        + potencia(terceiroDigito, 3);

    return resultado === numero;
}

/**
 * Produz a soma dos números naturais, iniciando em 0 até o argumento
 *
 * @param {number} numero O número até o qual deve-se produzir a soma dos
 * naturais
 *
 * @returns {number} A soma dos naturais
 *
 * @throws {TypeError} Se parâmetro for null ou undefined
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se parâmetro for menor que 1
 */
function somaDosPrimeirosNaturais(numero) {
    checkForNullUndefined(numero);
    checkForInteger(numero);

    if (numero < 1) {
        throw new RangeError("numero inválido: " + numero);
    }

    let soma = 1;
    for (let i = 2; i <= numero; i++) {
        soma = soma + i;
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
 * @throws {TypeError} Se parâmetro for null ou undefined
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se parâmetro for menor que 1
 */
function fatorial(numero) {
    checkForNullUndefined(numero);
    checkForInteger(numero);

    if (numero < 1) {
        throw new RangeError("numero inválido: " + numero);
    }

    let fatorial = 1;
    for (let i = 2; i <= numero; i++) {
        fatorial = fatorial * i;
    }

    return fatorial;
}

/**
 * Produz o valor de Pi de acordo com a precisão informada no argumento
 *
 * @param {number} precisao Valor que representa a precisão desejada
 * (quanto maior, maior a precisão de Pi)
 *
 * @returns {number} O valor de pi, dada a precisão
 *
 * @throws {TypeError} Se parâmetro for null ou undefined
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se precisao for menor que 1
 */
function pi(precisao) {
    checkForNullUndefined(precisao);
    checkForInteger(precisao);

    if (precisao < 1) {
        throw new RangeError("precisao inválido: " + precisao);
    }

    let pi = 0;
    let s = -1;
    let d = -1;
    for (let i = 1; i <= precisao; i++) {
        d = d + 2;
        s = -s;
        pi = pi + 4 * s / d;
    }

    return pi;
}

/**
 * Produz o logaritmo natural (base número de euler) de um expoente fornecido,
 * e a precisão desejada
 *
 * @param {number} expoente O expoente para o qual se quer calcular o logaritmo
 * natural
 * @param {number} precisao A precisão desejada no resultado do logaritmo
 * calculado
 *
 * @returns {number} Resultado do logaritmo natural, dado o expoente e precisão
 *
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeError} Se expoente for menor que 1 ou se precisao for menor
 * que 2
 */
function logaritmoNatural(expoente, precisao) {
    const argumentos = [expoente, precisao];
    argumentos.forEach(checkForNullUndefined);
    argumentos.forEach(checkForInteger);

    if (expoente < 1 || precisao < 2) {
        throw new RangeError("expoente ou precisao inválido: expoente = "
            + expoente + ", precisao = " + precisao);
    }

    let logaritmoNatural = 1 + expoente;
    let numerador = expoente;
    let denominador = 1;
    for (let i = 2; i <= precisao; i++) {
        numerador = numerador * numerador;
        denominador = denominador + i;
        logaritmoNatural = logaritmoNatural + numerador / denominador;
    }

    return logaritmoNatural;
}

/**
 * Produz a razão áurea considerando dois números inteiros positivos
 *
 * @param {number} numeroA O primero inteiro a ser considerado
 * @param {number} numeroB O segundo inteiro a ser considerado
 *
 * @param {number} precisao A precisão desejada do resultado retornado, quanto
 * maior o valor, maior a precisão
 *
 * @returns {number} A razão áurea de acordo com a precisão informada
 *
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeError} Se o numeroA for menor que 0 ou maior/igual ao numeroB
 * ou se a precisão é menor ou igual a 0
 */
function razaoAurea(numeroA, numeroB, precisao) {
    const argumentos = [numeroA, numeroB, precisao];
    argumentos.forEach(checkForNullUndefined);
    argumentos.forEach(checkForInteger);

    if (!contidoNoInvervalo(numeroA, 0, numeroB) || precisao <= 0) {
        throw new RangeError("numeroA, numeroB ou precisao inválido: numeroA = "
            + numeroA + ", numeroB = " + numeroB + ", precisao = " + precisao);
    }

    let numerador = numeroB;
    let denominador = numeroA;
    for (let i = 1; i <= precisao; i++) {
        let temporario = numerador;
        numerador = numerador + denominador;
        denominador = temporario;
    }

    return numerador / denominador;
}

/**
 * Avalia se o argumento é um quadrado perfeito
 *
 * @param {number} numero O argumento a ser avaliado
 *
 * @returns {boolean} Verdadeito, se o numero é um quadrado perfeito,
 * Falso, se não
 *
 * @throws {TypeError} Se parâmetro for null ou undefined
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se o argumento é menor que 1
 */
function isQuadradoPerfeito(numero) {
    checkForNullUndefined(numero);
    checkForInteger(numero);

    if (numero < 1) {
        throw new RangeError("numero inválido: " + numero);
    }

    let soma = 1;
    for (let i = 3; soma < numero; i = i + 2) {
        soma = soma + i;
    }

    return soma === numero;
}

/**
 * Produz a raiz quadrada de um número de acordo com a precisão fornecida
 *
 * @param {number} radicando O número que se deseja calcular a raiz quadrada
 * @param {number} precisao A precisão desejada do resultado retornado, quanto
 * maior o valor, maior a precisão
 *
 * @returns {number} O resultado da raiz quadrada do radicando dada a precisao
 *
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeError} Se radicando é menor ou igual a 0
 */
function raizQuadrada(radicando, precisao) {
    const argumentos = [radicando, precisao];
    argumentos.forEach(checkForNullUndefined);
    argumentos.forEach(checkForInteger);

    if (radicando <= 0) {
        throw new RangeError("radicando inválido: " + radicando);
    }

    let raizQuadrada = 1;
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
 * @throws {TypeError} Se parâmetro for null ou undefined
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se parâmetro é menor ou igual a 1
 */
function isPrimo(numero) {
    checkForNullUndefined(numero);
    checkForInteger(numero);

    if (numero <= 1) {
        throw new RangeError("numero inválido: " + numero);
    }

    for (let i = 2; i < numero; i++) {
        if (restoDaDivisaoInteira(numero, i) === 0) {
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
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeErros} Se o numeroB for maior que o numeroA,
 * ou se o numero B for menor que 1
 */
function maiorDivisorComumMetodo1(numeroA, numeroB) {
    const argumentos = [numeroA, numeroB];
    argumentos.forEach(checkForNullUndefined);
    argumentos.forEach(checkForInteger);

    if (numeroB > numeroA || numeroB <= 0) {
        throw new RangeError("numeroA ou numeroB inválido: numeroA = "
            + numeroA + ", numeroB = " + numeroB);
    }

    while (numeroB !== 0) {
        let temporario = restoDaDivisaoInteira(numeroA, numeroB);
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
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeErros} Se o numeroB for maior que o numeroA,
 * ou se o numero B for menor que 1
 */
function maiorDivisorComumMetodo2(numeroA, numeroB) {
    const argumentos = [numeroA, numeroB];
    argumentos.forEach(checkForNullUndefined);
    argumentos.forEach(checkForInteger);

    if (numeroB > numeroA || numeroB <= 0) {
        throw new RangeError("numeroA ou numeroB inválido: numeroA = "
            + numeroA + ", numeroB = " + numeroB);
    }

    while (numeroA !== numeroB) {
        (numeroA > numeroB) ? numeroA = numeroA - numeroB : numeroB -= numeroA;
    }

    return numeroA;
}

/**
 * Produz um vetor que indica quais número são primos (todos as posições do
 * vetor que possuem o valor 1 são primos)
 *
 * @param {number} vetorZeros O vetor com a quantidade de números a serem
 * avaliados (devem todos conter valor 0)
 *
 * @returns {Array} Vetor nos quais as posições com valor 1 são primos
 *
 * @throws {Error} Se vetor fornecido possuir menos do que 2 elementos
 * @throws {RangeError} Se números do vetor fornecido não for 0
 */
function determinarNumerosPrimos(vetorZeros) {
    checkForNullUndefined(vetorZeros);

    if (vetorZeros.length <= 1) {
        throw new Error("Vetor de tamanho inválido: " + vetorZeros.length);
    }

    for (let i = 1; i < vetorZeros.length; i++) {
        if (vetorZeros[i] !== 0) {
            throw new RangeError("vetorZeros[" + i + "] inválido: "
                + vetorZeros[i]);
        }
    }

    const limite = Math.floor(Math.sqrt(vetorZeros.length));
    for (let i = 1; i < limite; i++) {
        if (vetorZeros[i] === 0) {
            for (let multiplo = 2 * i; multiplo < vetorZeros.length; multiplo =
                multiplo + i) {
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
 * @throws {TypeError} Se parâmetros forem null ou undefined
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {Error} Se o grau do polinômio for menor que 1
 */
function calcularPolinomio(numero, coeficientes) {
    checkForNullUndefined(numero);
    checkForInteger(numero);

    const grauDoPolinomio = coeficientes.length;
    if (grauDoPolinomio < 1) {
        throw new Error("grau do polinomio inválido: " + grauDoPolinomio);
    }

    for (let i = 0; i < grauDoPolinomio; i++) {
        if (coeficientes[i] === null || coeficientes[i] === undefined) {
            throw new TypeError("argumento null ou undefined");
        }
        if (!Number.isInteger(coeficientes[i])) {
            throw new TypeError("argumento deve ser inteiro");
        }
    }

    let polinomio = coeficientes[grauDoPolinomio - 1];
    for (let i = grauDoPolinomio - 2; i >= 0; i--) {
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
 * @throws {TypeError} Se parâmetro for null ou undefined
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se o argumento for menor que 0
 */
function obterEnesimoTermoDeFibonacci(enesimoTermo) {
    checkForInteger(enesimoTermo);
    checkForNullUndefined(enesimoTermo);

    if (enesimoTermo < 0) {
        throw new RangeError("enesimoTermo inválido: " + enesimoTermo);
    }

    let termoProximo = 0;
    let termoAtual = 1;
    if (enesimoTermo === 0 | enesimoTermo === 1) {
        return enesimoTermo;
    }

    for (let i = 2; i <= enesimoTermo; i++) {
        const temporario = termoAtual;
        termoAtual = termoAtual + termoProximo;
        termoProximo = temporario;
    }

    return termoAtual;
}

module.exports = {
    satisfazPropriedade3025,
    restoDaDivisaoInteira,
    produto,
    potencia,
    contidoNoInvervalo,
    satisfazPropriedade153,
    somaDosPrimeirosNaturais,
    fatorial,
    pi,
    logaritmoNatural,
    razaoAurea,
    isQuadradoPerfeito,
    raizQuadrada,
    isPrimo,
    maiorDivisorComumMetodo1,
    maiorDivisorComumMetodo2,
    calcularPolinomio,
    obterEnesimoTermoDeFibonacci
};

