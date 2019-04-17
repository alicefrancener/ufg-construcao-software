function converteCaracteresEmInteiros(cpf) {
  var cpfVetor = [];
  for (var i = 0; i < cpf.length; i++) {
    cpfVetor[i] = parseInt(cpf.charAt(i));
  }
  return cpfVetor;
}

function validarDigitosCPF(cpf) {
  if (cpf.length != 11) {
    throw new RangeError("CPF deve ter 11 dígitos: " + cpf);
  }
  var cpfVetor = converteCaracteresEmInteiros(cpf);
  var j = cpfVetor[0];
  var k = cpfVetor[1];;
  for (var i = 1; i < 9; i++) {
    j += cpfVetor[i] * (i + 1);
  }
  for (var i = 2; i < 10; i++) {
    k += cpfVetor[i] * i;
  }
  var dj = (j % 11) % 10;
  var dk = (k % 11) % 10;
  return (dj == cpfVetor[9] && dk == cpfVetor[10]);
}

function validarDigitosCPF2(cpf) {
  if (cpf.length != 11) {
    throw new RangeError("CPF deve ter 11 dígitos: " + cpf);
  }
  var cpfVetor = converteCaracteresEmInteiros(cpf);
  var p = cpfVetor[8];
  var s = p;
  for (var c = 7; c >= 0; c--) {
    p += cpfVetor[c];
    s += p;
  }
  var j = (s % 11) % 10;
  var k = ((s - p + 9 * cpfVetor[9]) % 11) % 10;
  return j === cpfVetor[9] && k === cpfVetor[10];
}