package lab.refactoring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaController {
  
  @Autowired
  private VendaRepository vendaRepository;

  @RequestMapping("/vender")
  public Venda vender(
      @RequestParam String produto,
      @RequestParam Long quantidade) {

    return vendaRepository.save(new Venda(produto, quantidade));
  }

  @RequestMapping("/listar")
  public Iterable<Venda> listar() {
    return vendaRepository.findAll();
  }
  
}
