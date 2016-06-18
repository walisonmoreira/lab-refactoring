package lab.refactoring.web.exercicio1;

public class Validadores {

  private Validadores() {
  }
  
  public static void validarIgual(Object valor1, Object valor2, String mensagemErro) {
    if (valor1.equals(valor2)) {
      throw new IllegalArgumentException(mensagemErro);
    }
  }

  public static void validarNulo(Object valor, String mensagemErro) {
    if (valor == null) {
      throw new IllegalArgumentException(mensagemErro);
    }
  }

}
