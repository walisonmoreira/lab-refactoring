package lab.refactoring.web.venda;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Venda {

  @Id
  private Integer codigo;

  private TIPO_VENDA tipo;
  
  private String produto;

  private Integer quantidade;

  private Double valor;

  private Date data;

  public Venda() {
  }

  public Venda(Integer codigo, String tipo, String produto, Integer quantidade, Double valor, Date data) {
    this.codigo = codigo;
    this.tipo = TIPO_VENDA.from(tipo);
    this.produto = produto;
    this.quantidade = quantidade;
    this.valor = valor;
    this.data = data;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public TIPO_VENDA getTipo() {
    return tipo;
  }

  public void setTipo(TIPO_VENDA tipo) {
    this.tipo = tipo;
  }

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

}
