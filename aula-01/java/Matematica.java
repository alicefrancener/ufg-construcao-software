
public class Matematica{
  
  public int mod(int x, int y){
    if(y >= 0 & x > 0){
      int resto = x;
      while(y <= resto){
        resto = resto - y;
      }
      return resto;
    }
    return 0;
  }

  public int produto(int a, int b){
    if(a >= 0 & b>=0){
      int totalParcelas = a;
      int parcela = b;
      if(b<a){
        totalParcelas = b;
        parcela = a;
      }
      int soma = 0, i = 1;
      while(i <= totalParcelas){
        soma+= parcela;
        i+= 1;
      }
      return soma;
    }
    System.out.println("Valor não permitido: a>=0 & b>=0");
    return 0;
  }

  public int potencia(int base, int expoente){
    if(base >= 0 & expoente >= 0){
      int potencia2 = 1;
      for(int i=1; i<=expoente; i++){
        potencia2 = produto(potencia2, base);
      }
      return potencia2;
    }
    System.out.println("Valor não permitido: base>=0 & expoente>=0");
    return 0;
  }

  public boolean intervalo(int numero, int intervaloInferior, int intervaloSuperior){
    if (numero >= intervaloInferior & numero <= intervaloSuperior)
      return true;
    return false;
  }
  
  public boolean propriedade3025(int numero){
    if(intervalo(numero, 0, 9999)){
      int quociente = numero / 100;
      int resto = mod(numero, 100);
      int resultado = potencia(quociente + resto, 2);
      return numero == resultado;
    }
    return false;
  }

  public boolean propriedade153(int numero){
    if(intervalo(numero, 100, 999)){
      int quociente = numero/100;
      int resto = mod(numero, 100);
      int quociente2 = resto/10;
      int resto2 = mod(resto, 10);
      int resultado = potencia(quociente, 3) + potencia(quociente2, 3) + potencia(resto2, 3);
      return resultado == numero;

    }
    System.out.println("Fora do intervalo permitido: 100 <= numero <= 999");
    return false;
  }

  public int somaNaturais(int numero){
    if(numero >= 1){
      int i = 2;
      int soma = 1;
      while(numero >= i){
        soma = soma + i;
        i = i + 1;
      }
      return soma;
    }
    System.out.println("Valor não permitido: numero>=1");
    return 0;
  }

  public int fatorial(int numero){
    if(numero >= 1){
      int i = 2;
      int fatorial = 1;
      while(i <= numero){
        fatorial= fatorial*i;
        i = i + 1;
      }
      return fatorial;
    }
    System.out.println("Valor não permitido: numero>=1"); 
    return 0;
  }

  public double pi(int n){
    if(n >= 1){
      double s = -1, d = -1, p = 0;
      for(int i =1; i <= n; i++){
        d = d + 2;
        s = -1 * s;
        p = p + 4 * s/d;
      }
      return p;
    }
    System.out.println("Valor não permitido: n>=1"); 
    return 0;
  }

  public double logaritmoNatural(double n, double k){
    if(n >=1 & k>=2){
      double e = 1 + n;
      double numerador = n;
      double denominador = 1;
      for(double i =2; i<=k; i++){
        numerador = numerador*numerador;
        denominador = denominador + i;
        e = e + numerador/denominador;
      }
      return e;
    }
    System.out.println("Valor não permitido: n>=1 e k>=2"); 
    return 0;
  }

  public double razaoAurea(double x, double y, double k){
    if(x>=0 & x<y & k>0){
      double c = y;
      double a = x;
      for(int i = 1; i<=k; i++){
        double t = c;
        c = c + a;
        a = t;
      }
      return c/a;
    }
    System.out.println("Valor não permitido: x>=0, x<y, k>0"); 
    return 0;
  }


  

}