const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.isPrimo(7)).toBe(true);
});

test("nao satisfaz ", () => {
    expect(funcao.isPrimo(4)).toBe(false);
});

test("valor fora da faixa", () => {
    expect(() => { funcao.isPrimo(1); }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.isPrimo();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.isPrimo("abcd");
    }).toThrow(TypeError);
});