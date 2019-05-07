const funcao = require("../Data.js");

test("mes fora da faixa", () => {
    expect(() => {
        funcao.f2(13);
    }).toThrow();
});

test("mes null/undefined", () => {
    expect(() => {
        funcao.f2();
    }).toThrow();
});

test("mes nao numerico", () => {
    expect(() => {
        funcao.f2("abcd");
    }).toThrow();
});

test("mes nao inteiro", () => {
    expect(() => {
        funcao.f2(10.5);
    }).toThrow();
});