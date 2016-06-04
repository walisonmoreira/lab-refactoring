package lab.refactoring.web.exercicio;

public class Produto {
  private Long codigo;
  private String nome;
  //Quantidade
  private Long q;
  //Quantidade máxima.
  private Long qm;

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Long getQ() {
    return q;
  }

  public void setQ(Long q) {
    this.q = q;
  }

  public Long getQm() {
    return qm;
  }

  public void setQm(Long qm) {
    this.qm = qm;
  }
}