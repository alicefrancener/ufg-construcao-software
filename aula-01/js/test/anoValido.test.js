const funcao = require("../Data.js");

test("ano fora da faixa", () => {
    expect(() => {
        funcao.f3(350);
    }).toThrow();
});

test("ano null/undefined", () => {
    expect(() => {
        funcao.f3();
    }).toThrow();
});

test("ano nao numerico", () => {
    expect(() => {
        funcao.f3("abcd");
    }).toThrow();
});

test("ano nao inteiro", () => {
    expect(() => {
        funcao.f3(10.5);
    }).toThrow();
});