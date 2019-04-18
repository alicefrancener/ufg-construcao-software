function mod(x, y) {
  if (y < 0 || x <= 0) {
    throw new RangeError("x ou y inválido: x = " + x + ", y = " + y);
  }
  var resto = x;
  while (resto >= y) {
    resto = resto - y;
  }
  return resto;
}

function produto(a, b) {
  if (a < 0 || b < 0) {
    throw new RangeError("a ou b inválido: a = " + a + ", b = " + b);
  }
  var totalParcelas = a;
  var parcela = b;
  if (b < a) {
    totalParcelas = b;
    parcela = a;
  }
  var soma = 0;
  for (var i = 1; i <= totalParcelas; i += 1) {
    soma += parcela;
  }
  return soma;
}


function potencia(base, expoente) {
  if (base < 0 || expoente < 0) {
    throw new RangeError("base ou expoente inválido: base = " + base + ", expoente = " + expoente);
  }
  var potencia2 = 1;
  for (var i = 1; i <= expoente; i++) {
    potencia2 = produto(potencia2, base);
  }
  return potencia2;
}

function intervalo(numero, intervaloInferior, intervaloSuperior) {
  if (numero >= intervaloInferior && numero <= intervaloSuperior)
    return true;
  return false;
}

function propriedade3025(numero) {
  if (!intervalo(numero, 0, 9999)) {
    throw new RangeError("numero inválido: " + numero);
  }
  var quociente = parseInt(numero / 100);
  var resto = mod(numero, 100);
  var resultado = potencia(quociente + resto, 2);
  return numero === resultado;
}

function propriedade153(numero) {
  if (!intervalo(numero, 100, 999)) {
    throw new RangeError("numero inválido: " + numero);
  }
  var quociente = parseInt(numero / 100);
  var resto = mod(numero, 100);
  var quociente2 = parseInt(resto / 10);
  var resto2 = mod(resto, 10);
  var resultado = potencia(quociente, 3) + potencia(quociente2, 3) + potencia(resto2, 3);
  return resultado === numero;
}

function somaNaturais(numero) {
  if (numero < 1) {
    throw new RangeError("numero inválido: " + numero);
  }
  var soma = 1;
  for (var i = 2; numero >= i; i++) {
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

function pi(n) {
  if (n < 1) {
    throw new RangeError("n inválido: " + n);
  }
  var p = 0, s = -1, d = -1;
  for (var i = 1; i <= n; i++) {
    d += 2;
    s = -1 * s;
    p += 4 * s / d;
  }
  return p;
}

function logaritmoNatural(n, k) {
  if (n < 1 || k < 2) {
    throw new RangeError("n ou k inválido: n = " + n + ", k = " + k);
  }
  var e = 1 + n;
  var numerador = n;
  var denominador = 1;
  for (var i = 2; i <= k; i++) {
    numerador *= numerador;
    denominador += i;
    e += numerador / denominador;
  }
  return e;
}

function razaoAurea(x, y, k) {
  if (x < 0 || x >= y || k <= 0) {
    throw new RangeError("x, y ou k inválido: x = " + x + ", y = " + y + ", k = " + k);
  }
  var c = y;
  var a = x;
  for (var i = 1; i <= k; i++) {
    var t = c;
    c += a;
    a = t;
  }
  return c / a;
}


function quadradoPerfeito(numero) {
  if (numero < 1) {
    throw new RangeError("numero inválido: " + numero);
  }
  var s = 1;
  for (var i = 3; s < numero; i += 2) {
    s += i;
  }
  return s == numero;
}

function raiz(numero, i) {
  if (numero <= 0) {
    throw new RangeError("numero inválido: " + numero);
  }
  var r = 1;
  for (; i >= 0; i--) {
    r = (r + numero / r) / 2;
  }
  return r;
}

function primo(numero) {
  if (numero <= 1) {
    throw new RangeError("numero inválido: " + numero);
  }
  for (var i = 2; i < numero; i++) {
    if (mod(numero, i) == 0) {
      return false;
    }
  }
  return true;
}

function MDC(a, b) {
  if (b > a || b <= 0) {
    throw new RangeError("a ou b inválido: a = " + a + ", b = " + b);
  }
  while (b !== 0) {
    var m = mod(a, b);
    a = b;
    b = m;
  }
  return a;
}

function MDC2(a, b) {
  if (b > a || b <= 0) {
    throw new RangeError("a ou b inválido: a = " + a + ", b = " + b);
  }
  while (a !== b) {
    if (a > b) {
      a -= b;
    } else {
      b -= a;
    }
  }
  return a;
}

function crivoEratostenes(a) {
  if (a.length <= 1) {
    throw new Error("a.length inválido: " + a.length);
  }
  for (var i = 1; i < a.length; i++) {
    if (a[i] != 0) {
      throw new RangeError("a[" + i + "] inválido: " + a[i]);
    }
  }
  var limite = Math.floor(raiz(a.length, 100));
  for (var i = 1; i < limite; i++) {
    if (a[i] == 0) {
      for (var multiplo = 2 * i; multiplo < a.length; multiplo += i) {
        a[multiplo] = 1;
      }
    }
  }
  return a;
}

function horner(x, vetorNumeros) {
  if (vetorNumeros.length < 1) {
    throw new Error("vetorNumeros.length inválido: " + vetorNumeros.length);
  }
  var p = vetorNumeros[vetorNumeros.length - 1];
  for (var i = vetorNumeros.length - 2; i >= 0; i--) {
    p = p * x + vetorNumeros[i];
  }
  return p;
}

function fibonacci(n) {
  if (n < 0) {
    throw new RangeError("n inválido: " + n);
  }
  var a = 0;
  var c = 1;
  if (n === 0 | n === 1) {
    return n;
  }
  for (var i = 2; i <= n; i++) {
    var t = c;
    c += a;
    a = t;
  }
  return c;
}