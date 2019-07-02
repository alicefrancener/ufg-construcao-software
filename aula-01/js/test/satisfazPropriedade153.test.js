const funcao = require("../funcoes/Matematica.js");

test("153 satisfaz (caso classico)", () => {
    expect(funcao.satisfazPropriedade153(153)).toBe(true);
});

test("157 nao satisfaz", () => {
    expect(funcao.satisfazPropriedade153(157)).toBe(false);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.satisfazPropriedade153();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.satisfazPropriedade153("abcd");
    }).toThrow(TypeError);
});

test("valor negativo fora da faixa", () => {
    expect(() => {
        funcao.satisfazPropriedade153(-1);
    }).toThrow(RangeError);
});

test("valor de 4 digitos fora da faixa", () => {
    expect(() => funcao.satisfazPropriedade153(1000)).toThrow(RangeError);
});
