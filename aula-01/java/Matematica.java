
public class Matematica {

  public int mod(int x, int y) {
    if (y < 0 || x <= 0) {
      throw new IllegalArgumentException("x ou y inválido: x = " + x + ", y = " + y);
    }
    int resto = x;
    while (resto >= y) {
      resto = resto - y;
    }
    return resto;
  }

  public int produto(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("a ou b inválido: a = " + a + ", b = " + b);
    }
    int totalParcelas = a;
    int parcela = b;
    if (b < a) {
      totalParcelas = b;
      parcela = a;
    }
    int soma = 0;
    for (int i = 1; i <= totalParcelas; i += 1) {
      soma += parcela;
    }
    return soma;
  }

  public int potencia(int base, int expoente) {
    if (base < 0 || expoente < 0) {
      throw new IllegalArgumentException("base ou expoente inválido: base = " + base + ", expoente = " + expoente);

    }
    int potencia2 = 1;
    for (int i = 1; i <= expoente; i++) {
      potencia2 = produto(potencia2, base);
    }
    return potencia2;
  }

  public boolean intervalo(int numero, int intervaloInferior, int intervaloSuperior) {
    if (numero >= intervaloInferior & numero <= intervaloSuperior)
      return true;
    return false;
  }

  public boolean propriedade3025(int numero) {
    if (!intervalo(numero, 0, 9999)) {
      throw new IllegalArgumentException("numero inválido: " + numero);
    }
    int quociente = numero / 100;
    int resto = mod(numero, 100);
    int resultado = potencia(quociente + resto, 2);
    return numero == resultado;
  }

  public boolean propriedade153(int numero) {
    if (!intervalo(numero, 100, 999)) {
      throw new IllegalArgumentException("numero inválido: " + numero);
    }
    int quociente = numero / 100;
    int resto = mod(numero, 100);
    int quociente2 = resto / 10;
    int resto2 = mod(resto, 10);
    int resultado = potencia(quociente, 3) + potencia(quociente2, 3) + potencia(resto2, 3);
    return resultado == numero;
  }

  public int somaNaturais(int numero) {
    if (numero < 1) {
      throw new IllegalArgumentException("numero inválido: " + numero);
    }
    int soma = 1;
    for (int i = 2; numero >= i; i++) {
      soma += i;
    }
    return soma;
  }

  public int fatorial(int numero) {
    if (numero < 1) {
      throw new IllegalArgumentException("numero inválido: " + numero);

    }
    int fatorial = 1;
    for (int i = 2; i <= numero; i++) {
      fatorial *= i;
    }
    return fatorial;
  }

  public double pi(int n) {
    if (n < 1) {
      throw new IllegalArgumentException("n inválido: " + n);
    }
    double p = 0, s = -1, d = -1;
    for (int i = 1; i <= n; i++) {
      d += 2;
      s = -1 * s;
      p += 4 * s / d;
    }
    return p;
  }

  public double logaritmoNatural(double n, double k) {
    if (n < 1 || k < 2) {
      throw new IllegalArgumentException("n ou k inválido: n = " + n + ", k = " + k);
    }
    double e = 1 + n;
    double numerador = n;
    double denominador = 1;
    for (double i = 2; i <= k; i++) {
      numerador *= numerador;
      denominador += i;
      e += numerador / denominador;
    }
    return e;
  }

  public double razaoAurea(double x, double y, double k) {
    if (x < 0 || x >= y || k <= 0) {
      throw new IllegalArgumentException("x, y ou k inválido: x = " + x + ", y = " + y + ", k = " + k);
    }
    double c = y;
    double a = x;
    for (int i = 1; i <= k; i++) {
      double t = c;
      c += a;
      a = t;
    }
    return c / a;
  }

  public boolean quadradoPerfeito(int numero) {
    if (numero < 1) {
      throw new IllegalArgumentException("numero inválido: " + numero);
    }
    int s = 1;
    for (int i = 3; s < numero; i += 2) {
      s += i;
    }
    return s == numero;
  }

  public double raiz(double numero, int i) {
    if (numero <= 0) {
      throw new IllegalArgumentException("numero inválido: " + numero);
    }
    double r = 1;
    for (; i >= 0; i--) {
      r = (r + numero / r) / 2;
    }
    return r;
  }

  public boolean primo(int numero) {
    if (numero <= 1) {
      throw new IllegalArgumentException("numero inválido: " + numero);
    }
    for (int i = 2; i < numero; i++) {
      if (mod(numero, i) == 0) {
        return false;
      }
    }
    return true;
  }

  public int MDC(int a, int b) {
    if (b > a || b <= 0) {
      throw new IllegalArgumentException("a ou b inválido: a = " + a + ", b = " + b);
    }
    while (b != 0) {
      int m = mod(a, b);
      a = b;
      b = m;
    }
    return a;
  }

  public int MDC2(int a, int b) {
    if (b > a || b <= 0) {
      throw new IllegalArgumentException("a ou b inválido: a = " + a + ", b = " + b);
    }
    while (a != b) {
      if (a > b) {
        a -= b;
      } else {
        b -= a;
      }
    }
    return a;
  }

  public int[] crivoEratostenes(int a[]) {
    if (a.length <= 1) {
      throw new IllegalArgumentException("a.length inválido: " + a.length);
    }
    for (int i = 1; i < a.length; i++) {
      if (a[i] != 0) {
        throw new IllegalArgumentException("a[" + i + "] inválido: " + a[i]);
      }
    }
    int limite = (int) Math.floor(raiz(a.length, 100));
    for (int i = 1; i < limite; i++) {
      if (a[i] == 0) {
        for (int multiplo = 2 * i; multiplo < a.length; multiplo += i) {
          a[multiplo] = 1;
        }
      }
    }
    return a;
  }

  public int horner(int x, int[] vetorNumeros) {
    if (vetorNumeros.length < 1) {
      throw new IllegalArgumentException("vetorNumeros.length inválido: " + vetorNumeros.length);
    }
    int p = vetorNumeros[vetorNumeros.length - 1];
    for (int i = vetorNumeros.length - 2; i >= 0; i--) {
      p = p * x + vetorNumeros[i];
    }
    return p;
  }

  public int fibonacci(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n inválido: " + n);
    }
    int a = 0;
    int c = 1;
    if (n == 0 | n == 1) {
      return n;
    }
    for (int i = 2; i <= n; i++) {
      int t = c;
      c += a;
      a = t;
    }
    return c;
  }

}
