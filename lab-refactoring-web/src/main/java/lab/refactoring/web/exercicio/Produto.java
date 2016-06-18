package lab.refactoring.web.exercicio;

import static lab.refactoring.web.exercicio.Validadores.validarIgual;
import static lab.refactoring.web.exercicio.Validadores.validarNulo;

public class Produto {

  private Long codigo;
  
  private String nome;
  
  private Long quantidade;
  
  private Long quantidadeMaxima;

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

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
  }

  public Long getQuantidadeMaxima() {
    return quantidadeMaxima;
  }

  public void setQuantidadeMaxima(Long quantidadeMaxima) {
    this.quantidadeMaxima = quantidadeMaxima;
  }

  public void validar() {
    validarNulo(codigo,
        "O código do produto não pode ser nulo.");
    validarIgual(codigo, 0L,
        "O código do produto não pode ser zero.");
  }

  public void validarQuantidade() {
    validarIgual(quantidade, quantidadeMaxima,
        "A capacidade máxima foi alcançada.");
  }

  public void incrementarQuantidade() {
    quantidade++;
  }
}