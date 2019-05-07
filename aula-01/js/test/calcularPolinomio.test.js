const funcao = require("../Matematica.js");

test("satisfaz (caso classico)", () => {
    expect(funcao.f18(3, [10, 5, 6])).toBe(79);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao.f18();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f18("abcd", "cc");
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao.f18(10, [10, 5, "ab"]);
    }).toThrow(TypeError);
});