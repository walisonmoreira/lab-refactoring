package lab.refactoring.web.exercicio;

public class Estoque {

  private BancoDeDados bancoDeDados;

  public Estoque(BancoDeDados bancoDeDados) {
    this.bancoDeDados = bancoDeDados;
  }


  public void processarProduto(Produto produto) {
    produto.validar();
    bancoDeDados.obtem(produto);
    atualizarEstoque(produto);
    bancoDeDados.grava(produto);
  }

  private void atualizarEstoque(Produto produto) {
    produto.validarQuantidade();
    produto.incrementarQuantidade();
  }
}