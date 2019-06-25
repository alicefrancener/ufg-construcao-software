package com.github.alicefng.cs.aula10.domain;

import java.util.Vector;

public class AnoBissexto {

    public static void obtemAnosBissextos(int anoBissexto,
                                                       int anoAvaliado) {

        Vector<Integer> anosBissextos = new Vector<>();
        if (anoBissexto <= anoAvaliado) {
            for (int ano = anoBissexto; ano <= anoAvaliado; ano = ano + 4) {
                if(isMultiplo(ano, 100)){
                    if(isMultiplo(ano, 400)){
                        anosBissextos.add(ano);
                    }
                } else {
                    anosBissextos.add(ano);
                }
            }
        } else {
            for (int ano = anoBissexto; ano >= anoAvaliado; ano = ano - 4) {
                if(isMultiplo(ano, 100)){
                    if(isMultiplo(ano, 400)){
                        anosBissextos.add(ano);
                    }
                } else {
                    anosBissextos.add(ano);
                }
            }
        }
        anosBissextos.forEach(System.out::println);
    }

    public static boolean isMultiplo(int num1, int num2) {
        return !(num1 % num2 != 0);
    }

}
