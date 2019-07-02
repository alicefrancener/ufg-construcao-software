const funcao = require("../funcoes/numeroMaisSorteado.js");

test("caso classico", () => {
    var myMap = funcao.numeroMaisSorteado();
    for (var [key, value] of myMap) {
        console.log(key + " = " + value);
    }
});