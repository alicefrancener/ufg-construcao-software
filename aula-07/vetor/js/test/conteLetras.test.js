const funcao = require("../funcoes/conteLetras.js");

test("argumento null/undefined", () => {
    expect(() => {
        funcao.conteLetras();
    }).toThrow(TypeError);
});

test("argumento não é String", () => {
    expect(() => {
        funcao.conteLetras([1,2,3]);
    }).toThrow(TypeError);
});

const esperado = [6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 3];
test("caso classico", () => {
    expect(funcao.conteLetras("Aaaaaa  Zzz!!!")).toStrictEqual(esperado);
});

const esperado2 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0];
test("caso classico", () => {
    expect(funcao.conteLetras("{1231564879###$|}")).toStrictEqual(esperado2);
});