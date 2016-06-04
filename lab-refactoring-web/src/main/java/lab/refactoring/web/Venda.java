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

  private String pro;

  private Long qt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPro() {
    return pro;
  }

  public void setPro(String pro) {
    this.pro = pro;
  }

  public Long getQt() {
    return qt;
  }

  public void setQt(Long qt) {
    this.qt = qt;
  }

}
