const funcao = require("../Matematica.js");

test("3025 satisfaz (caso classico)", () => {
    expect(funcao.f1(3025)).toBe(true);
});

test("3024 nao satisfaz", () => {
    expect(funcao.f1(3024)).toBe(false);
});

test("argumento null/undefined", () => {
    expect(() => { funcao.f1(); }).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => { funcao.f1("abcd"); }).toThrow();
});


test("valor negativo fora da faixa", () => {
    expect(() => { funcao.f1(-1); }).toThrow(RangeError);
});

test("valor com mais de 4 digitos fora da faixa", () => {
    expect(() => funcao.f1(10000)).toThrow(RangeError);
});

test("valor deve ser inteiro", () => {
    expect(() => funcao.f1(10.3)).toThrow(RangeError);
});