import javax.swing.text.TableView.TableRow;

public class Data {

  private int dia;
  private int mes;
  private int ano;

  public Data(int dia, int mes, int ano) {
    setDia(dia);
    setMes(mes);
    setAno(ano);
  }

  public void setDia(int dia) {
    if (dia >= 1 & dia <= 31) {
      this.dia = dia;
      return;
    }
    throw new IllegalArgumentException("Argumento inválido: 1 <= dia <= 31");
  }

  public void setMes(int mes) {
    if (mes >= 1 & mes <= 12) {
      this.mes = mes;
      return;
    }
    throw new IllegalArgumentException("Argumento inválido: 1 <= mes <= 12");

  }

  public void setAno(int ano) {
    if (ano > 1753) {
      this.ano = ano;
      return;
    }
    throw new IllegalArgumentException("Argumento inválido: ano > 1753");
  }

  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  public String diaDaSemana() {
    int mes = getMes();
    int ano = getAno();
    if (getMes() == 1 | getMes() == 2) {
      mes = getMes() + 12;
      ano = getAno() - 1;
    }
    int soma = getDia() + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400;
    int resultado = soma % 7;
    return numeroEmDia(resultado);
  }

  public String numeroEmDia(int numero) {
    String semana = "";
    switch (numero) {
    case 0:
      semana = "segunda-feira";
      break;
    case 1:
      semana = "terça-feira";
      break;
    case 2:
      semana = "quarta-feira";
      break;
    case 3:
      semana = "quinta-feira";
      break;
    case 4:
      semana = "sexta-feira";
      break;
    case 5:
      semana = "sábado";
      break;
    case 6:
      semana = "domingo";
    }
    return semana;
  }

}