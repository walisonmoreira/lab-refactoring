package lab.refactoring.web.venda;

import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class VendaService {

  /**
   * Quantidade máxima de produtos para venda à vista.
   */
  public static final int QTDE_MAX_PROD_VENDA_A_VISTA = 30;
  public static final String MSG_FALHA_QTDE_MAX_PROD_VENDA_A_VISTA = "A quanticade máxima de produtos para uma venda à vista foi excedida.";

  /**
   * Quantidade de dias para vendas realizadas que são consideradas "recentes".
   */
  public static final int QTDE_DIAS_VENDAS_RECENTES = 7;

  @Inject
  private VendaRepository vendaRepository;

  private void validarVenda(Venda venda) {
    if (!venda.getProduto().equals("Caneta")
        && venda.getTipo().equals(TIPO_VENDA.A_VISTA)
        && venda.getQuantidade() > QTDE_MAX_PROD_VENDA_A_VISTA) {
      throw new RuntimeException(MSG_FALHA_QTDE_MAX_PROD_VENDA_A_VISTA);
    }
  }

  public void realizarVenda(Venda venda) {
    validarVenda(venda);
    vendaRepository.save(venda);
  }

  public Iterable<Venda> obterVendasRecentes() {
    Calendar agora = Calendar.getInstance();
    agora.add(Calendar.DATE, - QTDE_DIAS_VENDAS_RECENTES);
    return vendaRepository.findByDataGreaterThan(agora.getTime());
  }
}
