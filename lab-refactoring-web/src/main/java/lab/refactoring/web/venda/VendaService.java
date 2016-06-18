package lab.refactoring.web.venda;

import org.springframework.stereotype.Service;

@Service
public class VendaService {

  public void validarVenda(Venda novaVenda) {
    if (novaVenda.getTipo().equals("A_VISTA") && 
        novaVenda.getQuantidade() > 30) {
      throw new RuntimeException("Venda incorreta.");
    }
  }

}
