const funcao = require("../funcoes/contePalavra.js");

test("argumento null/undefined", () => {
    expect(() => {
        funcao.contePalavra();
    }).toThrow(TypeError);
});

test("argumento não é String", () => {
    expect(() => {
        funcao.contePalavra("como", ["como", "você", 0]);
    }).toThrow(TypeError);
});

test("argumento não é String", () => {
    expect(() => {
        funcao.contePalavra(0, ["como", "você", "como"]);
    }).toThrow(TypeError);
});

test("satisfaz (caso classico)", () => {
    expect(funcao.contePalavra("como",
        ["como", "você", "hello", "como"])).toBe(2);
    expect(funcao.contePalavra("hello",
        ["como", "você", "hello", "como"])).toBe(1);
    expect(funcao.contePalavra("nenhuma",
        ["como", "você", "hello", "como"])).toBe(0);

});
