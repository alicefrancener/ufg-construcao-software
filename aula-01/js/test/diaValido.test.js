const funcao = require("../funcoes/Data.js");

test("mes fora da faixa", () => {
    expect(() => {
        funcao.diaValido(32);
    }).toThrow();
});

test("mes null/undefined", () => {
    expect(() => {
        funcao.diaValido();
    }).toThrow();
});

test("mes nao numerico", () => {
    expect(() => {
        funcao.diaValido("abcd");
    }).toThrow();
});


test("mes nao inteiro", () => {
    expect(() => {
        funcao.diaValido(10.5);
    }).toThrow();
});