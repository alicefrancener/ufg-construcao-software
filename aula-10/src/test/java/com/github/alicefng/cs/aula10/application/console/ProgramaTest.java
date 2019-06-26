package com.github.alicefng.cs.aula10.application.console;

import org.junit.jupiter.api.Test;

public class ProgramaTest {

    @Test
    public void testMain() {
        String[] args = {"20190618", "2019", "20190617", "1"};
        Programa.main(args);

        String[] args2 = {"-2010", "2019", "20190617", "1"};
        Programa.main(args2);

        String[] args3 = {"2010", "2019", "20190617", "1"};
        Programa.main(args3);
    }

}
