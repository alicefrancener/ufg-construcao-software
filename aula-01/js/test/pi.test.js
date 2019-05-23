const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.pi(1)).toBe(4);
});

test("valor fora da faixa", () => {
    expect(() => {
        funcao.pi(-1);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.pi();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.pi("abcd");
    }).toThrow(TypeError);
});