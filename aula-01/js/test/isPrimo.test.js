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