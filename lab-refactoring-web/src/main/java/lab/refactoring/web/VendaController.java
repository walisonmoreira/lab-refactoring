package lab.refactoring.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController {

  @RequestMapping("/vender")
  public String vender() {
    return "Vendido!";
  }
}
