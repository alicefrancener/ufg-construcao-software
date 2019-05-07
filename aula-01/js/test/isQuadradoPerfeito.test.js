const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f12(9)).toBe(true);
});

test("nao satisfaz ", () => {
    expect(funcao.f12(7)).toBe(false);
});

test("valor fora da faixa", () => {
    expect(() => {
        funcao.f12(0);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.f12();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f12("abcd");
    }).toThrow(TypeError);
});