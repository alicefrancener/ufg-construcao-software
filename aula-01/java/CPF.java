public class CPF{

  private String cpf;

  public CPF(String cpf){
    setCpf(cpf);
  }

  public void setCpf(String cpf){
    if(validarCPF(cpf)){
      this.cpf = cpf;
    }
  }

  public String getCpf(){
    return this.cpf;
  }

  public boolean validarCPF(String cpf){
    if(cpf.length() != 11){
      throw new IllegalArgumentException("Argumento inválido, CPF deve ter 11 dígitos");
    }
    if(!cpfNumerico(cpf)){
      throw new IllegalArgumentException("Argumento inválido, CPF deve conter somente dígitos (0 a 9)");
    }
    
    // FIXME: uso nao recomendado de exceção para indicar resultado de operação
    if(!validarDigitosCPF2(cpf)){
      throw new IllegalArgumentException("Argumento inválido, dígitos verificadores do CPF incorretos");
    }
    
    // FIXME retorno irrelevante, pois se exceção não é gerada, sempre retorna true.
    return true;
  }

  public boolean cpfNumerico(String cpf){
    for(int i = 0; i < cpf.length(); i++){
      if(!Character.isDigit(cpf.charAt(i))){
        return false;
      }
    }
    return true;
  }
  
  // TODO: Character.getNumericValue está espalhado pelo código, sugiro uma funcao charToValue
  // int[] converteCaracteresEmInteiros(String cpf)

  public boolean validarDigitosCPF(String cpf){
    int j = Character.getNumericValue(cpf.charAt(0));
    int k = Character.getNumericValue(cpf.charAt(1));
    for(int i = 1; i < 9; i++){
      j += Character.getNumericValue(cpf.charAt(i)*(i+1));
    }
    for(int i = 2; i < 10; i++){
      k += Character.getNumericValue(cpf.charAt(i)*(i+1));
    }
    int dj = (j % 11) % 10;
    int dk = (k % 11) % 10;
    if(dj == Character.getNumericValue(cpf.charAt(9)) & dk == Character.getNumericValue(cpf.charAt(10))){
      return true;
    }
    return false;
  }

  public boolean validarDigitosCPF2(String cpf){
    int p = Character.getNumericValue(cpf.charAt(8));
    int s = p;
    for(int c = 7; c >=0; c--){
      p += Character.getNumericValue(cpf.charAt(c));
      s += p;
    }
    int j = (s % 11) % 10;
    int k = ((s - p + 9*Character.getNumericValue(cpf.charAt(9))) % 11) % 10;
    if(j == Character.getNumericValue(cpf.charAt(9)) & k == Character.getNumericValue(cpf.charAt(10))){
      return true;
    }
    return false;
  }

}
