
public class Matematica {

  public int mod(int x, int y) {
    if (y >= 0 & x > 0) {
      int resto = x;
      
      // Em defesa da legibilidade => manutenibilidade
      // (remova estes comentários)
      // for (; y <= resto; resto -= y)
      // ;
      while (y <= resto) {
        resto = resto - y;
      }
      
      return resto;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: y >=0 & x > 0");
  }

  public int produto(int a, int b) {
    if (a >= 0 & b >= 0) {
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
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: a>=0 & b>=0");
  }

  public int potencia(int base, int expoente) {
    if (base >= 0 & expoente >= 0) {
      int potencia2 = 1;
      for (int i = 1; i <= expoente; i++) {
        potencia2 = produto(potencia2, base);
      }
      return potencia2;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: base>=0 & expoente>=0");
  }

  public boolean intervalo(int numero, int intervaloInferior, int intervaloSuperior) {
    if (numero >= intervaloInferior & numero <= intervaloSuperior)
      return true;
    return false;
  }

  public boolean propriedade3025(int numero) {
    if (intervalo(numero, 0, 9999)) {
      int quociente = numero / 100;
      int resto = mod(numero, 100);
      int resultado = potencia(quociente + resto, 2);
      return numero == resultado;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: 0 <= numero <= 9999");
  }

  public boolean propriedade153(int numero) {
    if (intervalo(numero, 100, 999)) {
      int quociente = numero / 100;
      int resto = mod(numero, 100);
      int quociente2 = resto / 10;
      int resto2 = mod(resto, 10);
      int resultado = potencia(quociente, 3) + potencia(quociente2, 3) + potencia(resto2, 3);
      return resultado == numero;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: 100 <= numero <= 999");
  }

  public int somaNaturais(int numero) {
    if (numero >= 1) {
      int soma = 1;
      for (int i = 2; numero >= i; i++) {
        soma += i;
      }
      return soma;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: numero >= 1");
  }

  public int fatorial(int numero) {
    if (numero >= 1) {
      int fatorial = 1;
      for (int i = 2; i <= numero; i++) {
        fatorial *= i;
      }
      return fatorial;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: numero >= 1");
  }

  public double pi(int n) {
    if (n >= 1) {
      double p = 0, s = -1, d = -1;
      for (int i = 1; i <= n; i++) {
        d += 2;
        s = -1 * s;
        p += 4 * s / d;
      }
      return p;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: n >= 1");
  }

  public double logaritmoNatural(double n, double k) {
    if (n >= 1 & k >= 2) {
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
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: n >= 1 & k >= 2");
  }

  public double razaoAurea(double x, double y, double k) {
    if (x >= 0 & x < y & k > 0) {
      double c = y;
      double a = x;
      for (int i = 1; i <= k; i++) {
        double t = c;
        c += a;
        a = t;
      }
      return c / a;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: x >= 0 & x < y & k > 0");
  }

  public boolean quadradoPerfeito(int numero) {
    if (numero >= 1) {
      int s = 1;
      for (int i = 3; s < numero; i += 2) {
        s += i;
      }
      return s == numero;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: numero >= 1");
  }

  public double raiz(double numero, int i) {
    if (numero > 0) {
      double r = 1;
      for (; i >= 0; i--) {
        r = (r + numero / r) / 2;
      }
      return r;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: numero > 0");
  }

  public boolean primo(int numero) {
    if (numero > 1) {
      for (int i = 2; i < numero; i++) {
        if (mod(numero, i) == 0) {
          return false;
        }
      }
      return true;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: numero > 1");
  }

  public int MDC(int a, int b) {
    if (b <= a & b > 0) {
      while (b != 0) {
        int m = mod(a, b);
        a = b;
        b = m;
      }
      return a;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: b <= a & b > 0");
  }

  public int MDC2(int a, int b) {
    if (b <= a & b > 0) {
      while (a != b) {
        if (a > b) {
          a -= b;
        } else {
          b -= a;
        }
      }
      return a;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: b <= a & b > 0");
  }

  public int[] crivoEratostenes(int a[]) {
    if (a.length > 1) {
      for (int i = 1; i < a.length; i++) {
        if (a[i] != 0) {
          throw new IllegalArgumentException("Argumento fora do intervalo permitido: a[" + i + "] != 0 ");
        }
      }

      int limite = (int) Math.floor(raiz(a.length, 100));
      for (int i = 1; i < limite; i++) {
        if (a[i] == 0) {
          for(int multiplo = 2*i; multiplo < a.length; multiplo += i) {
            a[multiplo] = 1;
          }
        }
      }
      return a;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: a.length > 1");
  }

  public int horner(int x, int[] vetorNumeros){
    if(vetorNumeros.length >= 1){
      int p = vetorNumeros[vetorNumeros.length-1];
      for(int i = vetorNumeros.length-2; i >= 0; i--){
        p = p * x + vetorNumeros[i];
      }
      return p;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: vetorNumeros.lenght >= 1");
  }

  public int fibonacci(int n){
    if(n >=0){
      int a = 0;
      int c = 1;
      if(n == 0 | n ==1){
        return n;
      }
      for(int i =2; i<= n; i++){
        int t = c;
        c += a;
        a = t;
      }
      return c;
    }
    throw new IllegalArgumentException("Argumento fora do intervalo permitido: n >= 0");
  }

}
