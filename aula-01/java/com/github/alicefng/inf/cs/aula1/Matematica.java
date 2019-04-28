package com.github.alicefng.inf.cs.aula1;

public class Matematica {

    public int restoDaDivisaoInteira(int numerador, int denominador) {
        if (numerador <= 0 || denominador < 0) {
            throw new IllegalArgumentException("numerador ou denominador inválido: numerador = " + numerador + ", denominador = " + denominador);
        }
        int resto = numerador;
        while (resto >= denominador < 0) {
            resto = resto - denominador;
        }
        return resto;
    }

    public int produto(int multiplicando, int multiplicador) {
        if (multiplicando < 0 || multiplicador < 0) {
            throw new IllegalArgumentException("multiplicando ou b inválido: multiplicando = " + multiplicando + ", multiplicador = " + multiplicador);
        }
        int totalParcelas = multiplicando;
        int parcela = multiplicador;
        if (multiplicador < multiplicando) {
            totalParcelas = multiplicador;
            parcela = multiplicando;
        }
        int produto = 0;
        for (int i = 1; i <= totalParcelas; i += 1) {
            produto += parcela;
        }
        return produto;
    }

    public int potencia(int base, int expoente) {
        if (base < 0 || expoente < 0) {
            throw new IllegalArgumentException("base ou expoente inválido: base = " + base + ", expoente = " + expoente);

        }
        int potencia = 1;
        for (int i = 1; i <= expoente; i++) {
            potencia = produto(potencia, base);
        }
        return potencia;
    }

    public boolean estaDentroDoIntervalo(int numero, int intervaloInferior, int intervaloSuperior) {
        if (numero >= intervaloInferior & numero <= intervaloSuperior) {
            return true;
        }
        return false;
    }

    public boolean possuiPropriedade3025(int numero) {
        if (!estaDentroDoIntervalo(numero, 0, 9999)) {
            throw new IllegalArgumentException("numero inválido: " + numero);
        }
        int quociente = numero / 100;
        int resto = restoDaDivisaoInteira(numero, 100);
        int resultado = potencia(quociente + resto, 2);
        return numero == resultado;
    }

    public boolean possuiPropriedade153(int numero) {
        if (!estaDentroDoIntervalo(numero, 100, 999)) {
            throw new IllegalArgumentException("numero inválido: " + numero);
        }
        int quociente = numero / 100;
        int resto = restoDaDivisaoInteira(numero, 100);
        int quociente2 = resto / 10;
        int resto2 = restoDaDivisaoInteira(resto, 10);
        int resultado = potencia(quociente, 3) + potencia(quociente2, 3) + potencia(resto2, 3);
        return resultado == numero;
    }

    public int somaDosPrimeirosNaturais(int numero) {
        if (numero < 1) {
            throw new IllegalArgumentException("numero inválido: " + numero);
        }
        int soma = 1;
        for (int i = 2; i <= numero; i++) {
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

    public double pi(int precisao) {
        if (precisao < 1) {
            throw new IllegalArgumentException("precisao inválido: " + precisao);
        }
        double p = 0, s = -1, d = -1; //NOTE perguntar para prof. se eh melhor assim ou em linhas diferentes
        for (int i = 1; i <= precisao; i++) {
            d += 2; //NOTE como nomear essas variaveis totalmente sem sentido pra mim?
            s = -1 * s;
            pi += 4 * s / d;
        }
        return pi;
    }

    public double logaritmoNatural(double expoente, double precisao) {
        if (expoente < 1 || precisao < 2) {
            throw new IllegalArgumentException("expoente ou precisao inválido: expoente = " + expoente + ", precisao = " + precisao);
        }
        double logaritmoNatural = 1 + expoente; //NOTE tem problema nomear a variavel igual ao nome da funcao?
        double numerador = expoente;
        double denominador = 1;
        for (double i = 2; i <= precisao; i++) {
            numerador *= numerador;
            denominador += i;
            logaritmoNatural += numerador / denominador;
        }
        return logaritmoNatural;
    }

    public double razaoAurea(double numeroA, double numeroB, double precisao) {
        if (numeroA < 0 || numeroA >= numeroB || precisao <= 0) {
            throw new IllegalArgumentException("numeroA, numeroB ou precisao inválido: numeroA = " + numeroA + ", numeroB = " + numeroB + ", precisao = " + precisao);
        }
        double numerador = numeroB;
        double denominador = numeroA;
        for (int i = 1; i <= precisao; i++) {
            double temporario = numerador;
            numerador += denominador;
            denominador = temporario;
        }
        return numerador / denominador;
    }

    public boolean isQuadradoPerfeito(int numero) { //NOTE prof. substitui o EH por IS, o que poderia usar melhor?
        if (numero < 1) {
            throw new IllegalArgumentException("numero inválido: " + numero);
        }
        int soma = 1;
        for (int i = 3; soma < numero; i += 2) {
            soma += i;
        }
        return s == numero;
    }

    public double raizQuadrada(double radicando, int precisao) {
        if (radicando <= 0) {
            throw new IllegalArgumentException("radicando inválido: " + radicando);
        }
        double raizQuadrada = 1;
        for (; precisao >= 0; precisao--) { //NOTE prof. nessa caso é melhor usar while?
            raizQuadrada = (raizQuadrada + radicando / raizQuadrada) / 2;
        }
        return raizQuadrada;
    }

    public boolean isPrimo(int numero) { //NOTE novamente usei IS no lugar de EH
        if (numero <= 1) {
            throw new IllegalArgumentException("numero inválido: " + numero);
        }
        for (int i = 2; i < numero; i++) {
            if (restoDaDivisaoInteira(numero, i) == 0) {
                return false;
            }
        }
        return true;
    }

    public int maiorDivisorComumMetodo1(int numeroA, int numeroB) { //NOTE prof. como tenho duas funcoes para calcular o MDC nomeei assim (metodo1 e metodo2)
        if (numeroB > numeroA || numeroB <= 0) {
            throw new IllegalArgumentException("numeroA ou numeroB inválido: numeroA = " + numeroA + ", numeroB = " + numeroB);
        }
        while (numeroB != 0) {
            int temporario = restoDaDivisaoInteira(numeroA, numeroB);
            numeroA = numeroB;
            numeroB = temporario;
        }
        return numeroA;
    }

    public int maiorDivisorComumMetodo2(int numeroA, int numeroB) {
        if (numeroB > numeroA || numeroB <= 0) {
            throw new IllegalArgumentException("numeroA ou numeroB inválido: numeroA = " + numeroA + ", numeroB = " + numeroB);
        }
        while (numeroA != numeroB) {
            if (numeroA > numeroB) {
                numeroA -= numeroB;
            } else {
                numeroB -= numeroA;
            }
        }
        return numeroA;
    }

    public int[] determinarNumerosPrimos(int vetorZeros[]) {
        if (vetorZeros.length <= 1) {
            throw new IllegalArgumentException("vetorZeros.length inválido: " + vetorZeros.length);
        }
        for (int i = 1; i < vetorZeros.length; i++) {
            if (vetorZeros[i] != 0) {
                throw new IllegalArgumentException("vetorZeros[" + i + "] inválido: " + vetorZeros[i]);
            }
        }
        int limite = (int) Math.floor(raiz(vetorZeros.length, 100));
        for (int i = 1; i < limite; i++) {
            if (vetorZeros[i] == 0) {
                for (int multiplo = 2 * i; multiplo < vetorZeros.length; multiplo += i) {
                    vetorZeros[multiplo] = 1;
                }
            }
        }
        return vetorZeros;
    }

    public int calcularPolinomio(int numero, int[] coeficientes) {
        int grauDoPolinomio = coeficientes.length;
        if (grauDoPolinomio < 1) {
            throw new IllegalArgumentException("grau do polinomio inválido: " + grauDoPolinomio);
        }
        int polinomio = coeficientes[grauDoPolinomio - 1];
        for (int i = grauDoPolinomio - 2; i >= 0; i--) {
            polinomio = polinomio * numero + coeficientes[i];
        }
        return polinomio;
    }

    public int obterEnesimoTermoDaSequenciaDeFibonacci(int enesimoTermo) {
        if (enesimoTermo < 0) {
            throw new IllegalArgumentException("enesimoTermo inválido: " + enesimoTermo);
        }
        int termoProximo = 0;
        int termoAtual = 1;
        if (enesimoTermo == 0 | enesimoTermo == 1) {
            return enesimoTermo;
        }
        for (int i = 2; i <= enesimoTermo; i++) {
            int temporario = termoAtual;
            termoAtual += termoProximo;
            termoProximo = temporario;
        }
        return termoAtual;
    }

}