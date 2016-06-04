package lab.refactoring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController {
  
  @Autowired
  private VendaRepository vendaRepository;

  @RequestMapping("/vender")
  public Venda vender(
      @RequestParam String pro,
      @RequestParam Long qt) {

    Venda v = new Venda();
    v.setPro(pro);
    v.setQt(qt);
    
    vendaRepository.save(v);
    
    return v;
  }

  @RequestMapping("/lista")
  public Iterable<Venda> lista() {
    return vendaRepository.findAll();
  }
  
}
