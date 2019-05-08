package com.github.alicefng.inf.cs.aula1;

public class CPF {

    private String cpf;

    public CPF(String cpf) {
        validarCPF(cpf);
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public static void validarCPF(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("argumento é null");
        }

        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos: " + cpf);
        }

        if (!sequenciaContemApenasDigitos(cpf)) {
            throw new IllegalArgumentException("CPF deve conter somente dígitos (0 a 9): " + cpf);
        }

        if (!validarDigitosCPF(cpf)) {
            throw new IllegalArgumentException("dígitos verificadores do CPF incorretos: " + cpf);
        }
    }

    private static boolean sequenciaContemApenasDigitos(final String cpf) {
        return cpf.chars().allMatch(c -> Character.isDigit(c));
    }

    public static int[] converteCaracteresEmInteiros(String cpf) {
        return cpf.chars().map(c -> Character.getNumericValue(c)).toArray();
    }

    public static boolean validarDigitosCPF(String cpf) {
        int[] digitosCpf = converteCaracteresEmInteiros(cpf);
        int calculoParcialDigito10 = digitosCpf[0];
        int calculoParcialDigito11 = digitosCpf[1];
        for (int i = 1; i < 9; i++) {
            calculoParcialDigito10 += digitosCpf[i] * (i + 1);
        }
        for (int i = 2; i < 10; i++) {
            calculoParcialDigito11 += digitosCpf[i] * i;
        }
        int calculoFinalDigito10 = (calculoParcialDigito10 % 11) % 10;
        int calculoFinalDigito11 = (calculoParcialDigito11 % 11) % 10;
        return calculoFinalDigito10 == digitosCpf[9] & calculoFinalDigito11 == digitosCpf[10];
    }

    public static boolean validarDigitosCPF2(String cpf) {
        int[] digitosCpf = converteCaracteresEmInteiros(cpf);
        int calculoParcialDigito11 = digitosCpf[8];
        int calculoParcialDigito10 = calculoParcialDigito11;
        for (int i = 7; i >= 0; i--) {
            calculoParcialDigito11 += digitosCpf[i];
            calculoParcialDigito10 += calculoParcialDigito11;
        }
        int calculoFinalDigito10 = (calculoParcialDigito10 % 11) % 10;
        int calculoFinalDigito11 = ((calculoParcialDigito10 - calculoParcialDigito11 + 9 * digitosCpf[9]) % 11) % 10;
        return calculoFinalDigito10 == digitosCpf[9] & calculoFinalDigito11 == digitosCpf[10];
    }

}
