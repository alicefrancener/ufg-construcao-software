public class Aplicacao{
  public static void main(String[] args) {
    Matematica mat = new Matematica();
    //System.out.println( mat.intervalo(10, 0, 9) ); 
    //System.out.println( mat.mod(19, 5) );
    //System.out.println( mat.produto(10, 10) );
    //System.out.println( mat.potencia(3, 2) );
    //System.out.println( mat.propriedade3025(3025) );
    //System.out.println( mat.propriedade153(200) );    
    System.out.println( mat.somaNaturais(10) );
    System.out.println( mat.logaritmoNatural(5,5) );
    System.out.println( mat.razaoAurea(1, 3, 30) );

  }
}