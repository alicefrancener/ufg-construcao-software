function mod(x, y) {
  if (y >= 0 && x > 0) {
    var resto = x;
    for (; y <= resto; resto -= y);
    return resto;
  }
  throw new Error("Argumento fora do intervalo permitido: y >=0 & x > 0");
}

function produto(a, b) {
  if (a >= 0 && b >= 0) {
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
  throw new Error("Argumento fora do intervalo permitido: a>=0 & b>=0");
}


function potencia(base, expoente) {
  if (base >= 0 && expoente >= 0) {
    var potencia2 = 1;
    for (var i = 1; i <= expoente; i++) {
      potencia2 = produto(potencia2, base);
    }
    return potencia2;
  }
  throw new Error("Argumento fora do intervalo permitido: base>=0 & expoente>=0");
}

function intervalo(numero, intervaloInferior, intervaloSuperior) {
  if (numero >= intervaloInferior && numero <= intervaloSuperior)
    return true;
  return false;
}

function propriedade3025(numero) {
  if (intervalo(numero, 0, 9999)) {
    var quociente = parseInt(numero / 100);
    var resto = mod(numero, 100);
    var resultado = potencia(quociente + resto, 2);
    return numero === resultado;
  }
  throw new Error("Argumento fora do intervalo permitido: 0 <= numero <= 9999");
}

function propriedade153(numero) {
  if (intervalo(numero, 100, 999)) {
    var quociente = parseInt(numero / 100);
    var resto = mod(numero, 100);
    var quociente2 = parseInt(resto / 10);
    var resto2 = mod(resto, 10);
    var resultado = potencia(quociente, 3) + potencia(quociente2, 3) + potencia(resto2, 3);
    return resultado === numero;
  }
  throw new Error("Argumento fora do intervalo permitido: 100 <= numero <= 999");
}

function somaNaturais(numero) {
  if (numero >= 1) {
    var soma = 1;
    for (var i = 2; numero >= i; i++) {
      soma += i;
    }
    return soma;
  }
  throw new Error("Argumento fora do intervalo permitido: numero >= 1");
}

function fatorial(numero) {
  if (numero >= 1) {
    var fatorial = 1;
    for (var i = 2; i <= numero; i++) {
      fatorial *= i;
    }
    return fatorial;
  }
  throw new Error("Argumento fora do intervalo permitido: numero >= 1");
}

function pi(n) {
  if (n >= 1) {
    var p = 0, s = -1, d = -1;
    for (var i = 1; i <= n; i++) {
      d += 2;
      s = -1 * s;
      p += 4 * s / d;
    }
    return p;
  }
  throw new Error("Argumento fora do intervalo permitido: n >= 1");
}

function logaritmoNatural(n, k) {
  if (n >= 1 && k >= 2) {
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
  throw new Error("Argumento fora do intervalo permitido: n >= 1 & k >= 2");
}

function razaoAurea(x, y, k) {
  if (x >= 0 && x < y && k > 0) {
    var c = y;
    var a = x;
    for (var i = 1; i <= k; i++) {
      var t = c;
      c += a;
      a = t;
    }
    return c / a;
  }
  throw new Error("Argumento fora do intervalo permitido: x >= 0 & x < y & k > 0");
}


function quadradoPerfeito(numero) {
  if (numero >= 1) {
    var s = 1;
    for (var i = 3; s < numero; i += 2) {
      s += i;
    }
    return s == numero;
  }
  throw new Error("Argumento fora do intervalo permitido: numero >= 1");
}

function raiz(numero, i) {
  if (numero > 0) {
    var r = 1;
    for (; i >= 0; i--) {
      r = (r + numero / r) / 2;
    }
    return r;
  }
  throw new Error("Argumento fora do intervalo permitido: numero > 0");
}

function primo(numero) {
  if (numero > 1) {
    for (var i = 2; i < numero; i++) {
      if (mod(numero, i) == 0) {
        return false;
      }
    }
    return true;
  }
  throw new Error("Argumento fora do intervalo permitido: numero > 1");
}

function MDC(a, b) {
  if (b <= a && b > 0) {
    while (b !== 0) {
      var m = mod(a, b);
      a = b;
      b = m;
    }
    return a;
  }
  throw new Error("Argumento fora do intervalo permitido: b <= a & b > 0");
}

function MDC2(a, b) {
  if (b <= a && b > 0) {
    while (a !== b) {
      if (a > b) {
        a -= b;
      } else {
        b -= a;
      }
    }
    return a;
  }
  throw new Error("Argumento fora do intervalo permitido: b <= a & b > 0");
}

function crivoEratostenes(a) {
  if (a.length > 1) {
    for (var i = 1; i < a.length; i++) {
      if (a[i] != 0) {
        throw new Error("Argumento fora do intervalo permitido: a[" + i + "] != 0 ");
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
  throw new Error("Argumento fora do intervalo permitido: a.length > 1");
}

function horner(x, vetorNumeros) {
  if (vetorNumeros.length >= 1) {
    var p = vetorNumeros[vetorNumeros.length - 1];
    for (var i = vetorNumeros.length - 2; i >= 0; i--) {
      p = p * x + vetorNumeros[i];
    }
    return p;
  }
  throw new Error("Argumento fora do intervalo permitido: vetorNumeros.lenght >= 1");
}

function fibonacci(n) {
  if (n >= 0) {
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
  throw new Error("Argumento fora do intervalo permitido: n >= 0");
}