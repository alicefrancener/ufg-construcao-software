const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f12(9)).toBe(true);
});

test("nao satisfaz ", () => {
    expect(funcao.f12(7)).toBe(false);
});

test("valor fora da faixa", () => {
    expect(() => { funcao.f12(0); }).toThrow(RangeError);
});