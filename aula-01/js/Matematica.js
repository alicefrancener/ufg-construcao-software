function restoDaDivisaoInteira(numerador, denominador) {
  if (numerador <= 0 || denominador < 0) {
    throw new RangeError("numerador ou denominador inválido: numerado = " + numerador + ", denominador = " + denominador);
  }
  var resto = numerador;
  while (resto >= denominador) {
    resto = resto - denominador;
  }
  return resto;
}

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

function estaDentroDoIntervalo(numero, intervaloInferior, intervaloSuperior) {
  if (numero >= intervaloInferior && numero <= intervaloSuperior) {
      return true;
  }
  return false;
}

function possuiPropriedade3025(numero) {
  if (!estaDentroDoIntervalo(numero, 0, 9999)) {
    throw new RangeError("numero inválido: " + numero);
  }
  var quociente = parseInt(numero / 100);
  var resto = restoDaDivisaoInteira(numero, 100);
  var resultado = potencia(quociente + resto, 2);
  return numero === resultado;
}

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

function pi(precisao) {
  if (precisao < 1) {
    throw new RangeError("n inválido: " + n);
  }
  var p = 0, s = -1, d = -1;
  for (var i = 1; i <= precisao; i++) {
    d += 2;
    s = -1 * s;
    pi += 4 * s / d;
  }
  return pi;
}

function logaritmoNatural(expoente, precisao) {
  if (expoente < 1 || precisao < 2) {
    throw new RangeError("expoente ou k inválido: expoente = " + expoente + ", precisao = " + precisao);
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

function razaoAurea(numeroA, numeroB, precisao) {
  if (x < 0 || x >= numeroB || precisao <= 0) {
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

function maiorDivisorComumMetodo2(numeroA, numeroB) {
  if (numeroB > numeroA || numeroB <= 0) {
    throw new RangeError("numeroA ou numeroB inválido: numeroA = " + numeroA + ", numeroB = " + numeroB);
  }
  while (numeroA !== numeroB) {
    if (numeroA > numeroB) {
      numeroA -= numeroB;
    } else {
      numeroB -= numeroA;
    }
  }
  return numeroA;
}

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