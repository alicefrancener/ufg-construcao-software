const funcao = require("../Data.js");

test("mes fora da faixa", () => {
    expect(() => {
        funcao.f1(32);
    }).toThrow();
});

test("mes null/undefined", () => {
    expect(() => {
        funcao.f1();
    }).toThrow();
});

test("mes nao numerico", () => {
    expect(() => {
        funcao.f1("abcd");
    }).toThrow();
});


test("mes nao inteiro", () => {
    expect(() => {
        funcao.f1(10.5);
    }).toThrow();
});