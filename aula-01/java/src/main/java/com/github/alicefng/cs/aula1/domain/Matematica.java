/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

/**
 * Implementação de várias operações matemáticas básicas
 */
public class Matematica {

    /**
     * Produz o resto da divisão entre dois numeros inteiros
     *
     * @param numerador   O numerador da divisão
     * @param denominador O denominador da divisão
     * @return O resto obtido na divisão: numerador/denominador
     * @throws IllegalArgumentException Se o numerador for menor ou igual 0 ou se o denominador for menor que 0
     */
    public static int restoDaDivisaoInteira(int numerador, int denominador) {
        if (numerador <= 0 || denominador < 0) {
            throw new IllegalArgumentException("numerador ou denominador inválido: numerador = " + numerador + ", " +
                    "denominador = " + denominador);
        }

        int resto = numerador;
        while (resto >= denominador) {
            resto = resto - denominador;
        }

        return resto;
    }

    /**
     * Resulta no produto entre o primeiro e o segundo argumento
     *
     * @param multiplicando O número a ser multiplicado
     * @param multiplicador O número a multiplicar
     * @return O produto de dois numeros: multiplicando*multiplicador
     * @throws IllegalArgumentException Se o multiplicando ou multiplicador for menor que 0
     */
    public static int produto(int multiplicando, int multiplicador) {
        if (multiplicando < 0 || multiplicador < 0) {
            throw new IllegalArgumentException("multiplicando ou b inválido: multiplicando = " + multiplicando + ", " +
                    "multiplicador = " + multiplicador);
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

    /**
     * Produz o resultado da exponenciação, considerando base e expoente inteiros
     *
     * @param base     A base da exponenciação
     * @param expoente O expoente da exponenciação
     * @return O resultado da base elevada ao expoente
     * @throws IllegalArgumentException Se base ou expoente forem menores que 0
     */
    public static int potencia(int base, int expoente) {
        if (base < 0 || expoente < 0) {
            throw new IllegalArgumentException("base ou expoente inválido: base = " + base +
                    ", expoente = " + expoente);
        }

        int potencia = 1;
        for (int i = 1; i <= expoente; i++) {
            potencia = produto(potencia, base);
        }

        return potencia;
    }

    /**
     * Avalia se um número está dentro ou fora de um dado intervalo
     *
     * @param numero            O número a ser avaliado
     * @param intervaloInferior O Intervalo inferior a ser considerado
     * @param intervaloSuperior O Intervalo superior a ser considerado
     * @return Verdadeiro, se o número está dentro do intervalo fornecido, e Falso, caso esteja fora do intervalo
     */
    private static boolean estaDentroDoIntervalo(int numero, int intervaloInferior, int intervaloSuperior) {
        return (numero >= intervaloInferior & numero <= intervaloSuperior) ? true : false;
    }

    /**
     * Avalia se o argumento possui a propriedade matemática 3025
     * Essa propriedade é tal que 30 + 25 = 55 e o quadrado desta soma resulta no próprio número, 55^2 = 3025
     *
     * @param numero O número a ser avaliado
     * @return Verdadeiro, se o número possui a propriedade, Falso, caso não possua
     * @throws IllegalArgumentException Se parâmetro está fora do intervalo permitido [0,9999]
     */
    public static boolean possuiPropriedade3025(int numero) {
        if (!estaDentroDoIntervalo(numero, 0, 9999)) {
            throw new IllegalArgumentException("numero inválido: " + numero);
        }

        int quociente = numero / 100;
        int resto = restoDaDivisaoInteira(numero, 100);
        int resultado = potencia(quociente + resto, 2);

        return numero == resultado;
    }

    /**
     * Avalia se o argumento possuia a propriedade matemática 153
     * Essa propriedade é tal que a soma do cubo dos dígidos do número resulta no próprio número
     * Exemplo numero 153: 1^3 + 5^3 + 3^3 = 153
     *
     * @param numero O número a ser avaliado
     * @return Verdadeiro, se o número possui a propriedade, Falso, caso não possua
     * @throws IllegalArgumentException Se parâmetro está fora do intervalo permitido [100,999]
     */
    public static boolean possuiPropriedade153(int numero) {
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

    /**
     * Produz a soma dos números naturais, iniciando em 0 até o argumento
     *
     * @param numero O número até o qual deve-se produzir a soma dos naturais
     * @return A soma dos naturais
     * @throws IllegalArgumentException Se parâmetro for menor que 1
     */
    public static int somaDosPrimeirosNaturais(int numero) {
        if (numero < 1) {
            throw new IllegalArgumentException("numero inválido: " + numero);
        }

        int soma = 1;
        for (int i = 2; i <= numero; i++) {
            soma += i;
        }

        return soma;
    }

    /**
     * Produz o fatorial do argumento
     *
     * @param numero O número que se quer calcular o fatorial
     * @return A fatoração do argumento
     * @throws IllegalArgumentException Se parâmetro for menor que 1
     */
    public static int fatorial(int numero) {
        if (numero < 1) {
            throw new IllegalArgumentException("numero inválido: " + numero);

        }

        int fatorial = 1;
        for (int i = 2; i <= numero; i++) {
            fatorial *= i;
        }

        return fatorial;
    }

    /**
     * Produz o valor de Pi de acordo com a precisão informada no argumento
     *
     * @param precisao Valor que representa a precisão desejada (quanto maior, maior a precisão de Pi)
     * @return O valor de pi, dada a precisão
     * @throws IllegalArgumentException Se precisao for menor que 1
     */
    public static double pi(int precisao) {
        if (precisao < 1) {
            throw new IllegalArgumentException("precisao inválido: " + precisao);
        }

        double pi = 0;
        double s = -1;
        double d = -1;

        for (int i = 1; i <= precisao; i++) {
            d += 2;
            s = -1 * s;
            pi += 4 * s / d;
        }

        return pi;
    }

    /**
     * Produz o logaritmo natural (base número de euler) de um expoente fornecido, e a precisão desejada
     *
     * @param expoente O expoente para o qual se quer calcular o logaritmo natural
     * @param precisao A precisão desejada no resultado do logaritmo calculado (quanto maior o valor, maior a precisão)
     * @return Resultado do logaritmo natural, dado o expoente e precisão informadas
     * @throws IllegalArgumentException Se expoente for menor que 1 ou se precisao for menor que 2
     */
    public static double logaritmoNatural(double expoente, double precisao) {
        if (expoente < 1 || precisao < 2) {
            throw new IllegalArgumentException("expoente ou precisao inválido: expoente = " + expoente + ", " +
                    "precisao = " + precisao);
        }

        double logaritmoNatural = 1 + expoente;
        double numerador = expoente;
        double denominador = 1;

        for (double i = 2; i <= precisao; i++) {
            numerador *= numerador;
            denominador += i;
            logaritmoNatural += numerador / denominador;
        }

        return logaritmoNatural;
    }

    /**
     * Produz a razão áurea considerando dois números inteiros positivos
     *
     * @param numeroA  O primero inteiro a ser considerado
     * @param numeroB  O segundo inteiro a ser considerado
     * @param precisao A precisão desejada do resultado retornado, quanto maior o valor, maior a precisão
     * @return A razão áurea de acordo com a precisão informada
     * @throws IllegalArgumentException Se o numeroA for menor que 0 ou maior/igual ao numeroB ou se a precisão
     *                                  é menor ou igual a 0
     */
    public static double razaoAurea(double numeroA, double numeroB, double precisao) {
        if (numeroA < 0 || numeroA >= numeroB || precisao <= 0) {
            throw new IllegalArgumentException("numeroA, numeroB ou precisao inválido: numeroA = " + numeroA +
                    ", numeroB = " + numeroB + ", precisao = " + precisao);
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

    /**
     * Avalia se o argumento é um quadrado perfeito
     *
     * @param numero O argumento a ser avaliado
     * @return Verdadeito, se o numero é um quadrado perfeito, Falso, se não
     * @throws IllegalArgumentException Se o argumento é menor que 1
     */
    public static boolean isQuadradoPerfeito(int numero) {
        if (numero < 1) {
            throw new IllegalArgumentException("numero inválido: " + numero);
        }

        int soma = 1;
        for (int i = 3; soma < numero; i += 2) {
            soma += i;
        }

        return soma == numero;
    }

    /**
     * Produz a raiz quadrada de um número de acordo com a precisão fornecida
     *
     * @param radicando O número que se deseja calcular a raiz quadrada
     * @param precisao  A precisão desejada do resultado retornado, quanto maior o valor, maior a precisão
     * @return O resultado da raiz quadrada do radicando dada a precisao fornecida
     * @throws IllegalArgumentException Se radicando é menor ou igual a 0
     */
    public static double raizQuadrada(double radicando, int precisao) {
        if (radicando <= 0) {
            throw new IllegalArgumentException("radicando inválido: " + radicando);
        }

        double raizQuadrada = 1;
        for (; precisao >= 0; precisao--) {
            raizQuadrada = (raizQuadrada + radicando / raizQuadrada) / 2;
        }

        return raizQuadrada;
    }

    /**
     * Avalia se o argumento é um número primo
     *
     * @param numero O número a ser avaliado se é primo
     * @return Verdadeiro, se o argumento é primo; Falso, se não é primo
     * @throws IllegalArgumentException Se parâmetro é menor ou igual a 1
     */
    public static boolean isPrimo(int numero) {
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

    /**
     * Calcula o maior divisor comum entre dois números inteiros
     *
     * @param numeroA O primeiro número a ser avaliado
     * @param numeroB O segundo número a ser avaliado
     * @return O maior divisor comum entre os argumentos fornecidos
     * @throws IllegalArgumentException Se o numeroB for maior que o numeroA, ou se o numero B for menor que 1
     */
    public static int maiorDivisorComumMetodo1(int numeroA, int numeroB) {
        if (numeroB > numeroA || numeroB <= 0) {
            throw new IllegalArgumentException("numeroA ou numeroB inválido: numeroA = " + numeroA +
                    ", numeroB = " + numeroB);
        }

        while (numeroB != 0) {
            int temporario = restoDaDivisaoInteira(numeroA, numeroB);
            numeroA = numeroB;
            numeroB = temporario;
        }

        return numeroA;
    }

    /**
     * Calcula o maior divisor comum entre dois números inteiros
     *
     * @param numeroA O primeiro número a ser avaliado
     * @param numeroB O segundo número a ser avaliado
     * @return O maior divisor comum entre os argumentos fornecidos
     * @throws IllegalArgumentException Se o numeroB for maior que o numeroA, ou se o numero B for menor que 1
     */
    public static int maiorDivisorComumMetodo2(int numeroA, int numeroB) {
        if (numeroB > numeroA || numeroB <= 0) {
            throw new IllegalArgumentException("numeroA ou numeroB inválido: numeroA = " + numeroA +
                    ", numeroB = " + numeroB);
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

    /**
     * Produz um vetor que indica quais número são primos (todos as posições do vetor que possuem o valor 1 são primos)
     *
     * @param vetorZeros O vetor com a quantidade de números a serem avaliados (devem todos conter valor 0)
     * @return Vetor nos quais as posições com valor 1 são primos
     * @throws IllegalArgumentException Se vetor fornecido possuir menos do que 2 elementos
     * @throws IllegalArgumentException Se números do vetor fornecido não for 0
     */
    public static int[] determinarNumerosPrimos(int[] vetorZeros) {
        if (vetorZeros.length <= 1) {
            throw new IllegalArgumentException("vetorZeros.length inválido: " + vetorZeros.length);
        }
        for (int i = 1; i < vetorZeros.length; i++) {
            if (vetorZeros[i] != 0) {
                throw new IllegalArgumentException("vetorZeros[" + i + "] inválido: " + vetorZeros[i]);
            }
        }

        int limite = (int) Math.floor(raizQuadrada(vetorZeros.length, 100));
        for (int i = 1; i < limite; i++) {
            if (vetorZeros[i] == 0) {
                for (int multiplo = 2 * i; multiplo < vetorZeros.length; multiplo += i) {
                    vetorZeros[multiplo] = 1;
                }
            }
        }

        return vetorZeros;
    }

    /**
     * Produz o resultado do polinômio fornecido
     *
     * @param numero       A constante do polinômio
     * @param coeficientes Os coeficientes da constante do polinômio
     * @return O valor final do polinômio
     * @throws IllegalArgumentException Se o grau do polinômio for menor que 1
     */
    public static int calcularPolinomio(int numero, int[] coeficientes) {
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

    /**
     * Produz o enésimo termo da sequência de Fibonacci
     *
     * @param enesimoTermo O número da sequência de Fibonacci que se deseja obter
     * @return O valor do enésimo termo da sequência de Fibonnaci
     * @throws IllegalArgumentException Se o argumento for menor que 0
     */
    public static int obterEnesimoTermoDaSequenciaDeFibonacci(int enesimoTermo) {
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