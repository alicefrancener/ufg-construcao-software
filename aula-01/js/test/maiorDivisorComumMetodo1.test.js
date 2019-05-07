const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f15(10, 5)).toBe(5);
});

test("numeroB fora da faixa", () => {
    expect(() => {
        funcao.f15(10, 100);
    }).toThrow(RangeError);
});

test("numeroB fora da faixa", () => {
    expect(() => {
        funcao.f15(10, -1);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.f15();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f15("abcd", "cc");
    }).toThrow(TypeError);
});