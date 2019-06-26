package com.github.alicefng.cs.aula10.application.console;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.jupiter.api.Test;

public class ProgramaTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void exitsWithStatusCode2() {
        String[] args = {"20190618", "2019", "20190617", "1"};
        exit.expectSystemExitWithStatus(2);
        Programa.main(args);
    }

    @Test
    public void exitsWithStatusCode1Minus() {
        String[] args = {"-2010", "2019", "20190617", "1"};
        exit.expectSystemExitWithStatus(-1);
        Programa.main(args);
    }

}
