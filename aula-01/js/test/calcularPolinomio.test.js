const funcao = require("../funcoes/Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.calcularPolinomio(3, [10, 5, 6])).toBe(79);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.calcularPolinomio();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.calcularPolinomio("abcd", "cc");
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.calcularPolinomio(10, [10, 5, "ab"]);
    }).toThrow(TypeError);
});