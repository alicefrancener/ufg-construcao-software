const funcao = require("../funcoes/palavraMaisFrequente.js");

test("argumento null/undefined", () => {
    expect(() => {
        funcao.palavraMaisFrequente();
    }).toThrow(TypeError);
});

test("argumento não é string", () => {
    expect(() => {
        funcao.palavraMaisFrequente(0);
    }).toThrow(TypeError);
});

test("satisfaz (caso classico)", () => {
    expect(funcao.palavraMaisFrequente("como você como como olá")
    ).toBe("como");
});
