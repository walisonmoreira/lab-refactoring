package lab.refactoring.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String produto;

  private Long quantidade;

  public Venda() {
  }

  public Venda(String produto, Long quantidade) {
    super();
    this.produto = produto;
    this.quantidade = quantidade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProduto() {
    return produto;
  }

  public Long getQuantidade() {
    return quantidade;
  }

}
