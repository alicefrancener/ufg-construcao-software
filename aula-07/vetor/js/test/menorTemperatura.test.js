const funcao = require("../funcoes/menorTemperatura.js");

test("temperatura null/undefined", () => {
    expect(() => {
        funcao.menorTemperatura();
    }).toThrow(TypeError);
});

test("temperatura nao numerica", () => {
    expect(() => {
        funcao.menorTemperatura([10.2, "a", 0]);
    }).toThrow(TypeError);
});

test("satisfaz (caso classico)", () => {
    expect(funcao.menorTemperatura([-55.5, -100, 0.8, 200])).toBe(-100);
});