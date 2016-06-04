package lab.refactoring.web.exercicio;

public class Estoque {

  private BancoDeDados b;

  public Estoque(BancoDeDados b) {
    this.b = b;
  }

  private boolean verificaSeOParametroENulo(Object o) {
    return o == null;
  }

  public void processarProduto(Produto p) {
    //Obtém o produto completo do banco de dados.
    if (verificaSeOParametroENulo(p.getCodigo())) {
      throw new IllegalArgumentException("O código do produto não pode ser nulo.");
    }
    if (p.getCodigo().equals(0)) {
      throw new IllegalArgumentException("O código do produto não pode ser zero.");
    }
    b.obtem(p);
    //Atualiza o estoque de produtos.
    if (p.getQ().equals(p.getQm())) {
      throw new IllegalArgumentException("A capacidade máxima foi alcançada.");
    }
    p.setQ(p.getQ() + 1);
    b.grava(p);
  }
}