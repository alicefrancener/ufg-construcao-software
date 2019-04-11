
function validarDigitosCPF(cpf){
  if(cpf.length != 11){
    throw new Error("Argumento inválido, CPF deve ter 11 dígitos");
  }
  var j = parseInt(cpf.charAt(0));
  var k = parseInt(cpf.charAt(1));
  for(var i = 1; i < 9; i++){
    j += parseInt(cpf.charAt(i))*(i+1);
  }
  for(var i = 2; i < 10; i++){
    k += parseInt(cpf.charAt(i))*(i+1);
  }
  var dj = (j % 11) % 10;
  var dk = (k % 11) % 10;
  if(dj == parseInt(cpf.charAt(9)) && dk == parseInt(cpf.charAt(10))){
    return true;
  }
  return false;
}

function validarDigitosCPF2(cpf){
  if(cpf.length != 11){
    throw new Error("Argumento inválido, CPF deve ter 11 dígitos");
  }
  var p = parseInt(cpf.charAt(8));
  var s = p;
  for(var c = 7; c >=0; c--){
    p += parseInt(cpf.charAt(c));
    s += p;
  }
  var j = (s % 11) % 10;
  var k = ((s - p + 9*parseInt(cpf.charAt(9))) % 11) % 10;
  if(j === parseInt(cpf.charAt(9)) && k === parseInt(cpf.charAt(10))){
    return true;
  }
  return false;
}