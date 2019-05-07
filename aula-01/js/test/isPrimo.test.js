const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f14(7)).toBe(true);
});

test("nao satisfaz ", () => {
    expect(funcao.f14(4)).toBe(false);
});

test("valor fora da faixa", () => {
    expect(() => { funcao.f14(1); }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.f14();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f14("abcd");
    }).toThrow(TypeError);
});