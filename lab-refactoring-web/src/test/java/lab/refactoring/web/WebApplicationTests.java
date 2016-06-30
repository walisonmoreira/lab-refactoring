package lab.refactoring.web;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

import java.util.Date;

import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import lab.refactoring.web.venda.Venda;
import lab.refactoring.web.venda.VendaRepository;
import lab.refactoring.web.venda.VendaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebApplication.class)
@WebIntegrationTest("server.port:0")
public class WebApplicationTests {

  /**
   * ID da venda utilizada para teste.
   */
  private static final int VENDA_ID_TESTE = -1;

  @Autowired
  VendaRepository vendaRepository;

  @Value("${local.server.port}")
  int port;

  @Before
  public void setUp() {
    RestAssured.port = port;
    try {
      vendaRepository.delete(VENDA_ID_TESTE);
    } catch (EmptyResultDataAccessException e) {
      //Não precisa fazer nada.
    }
  }

  @Test
  public void quantidadeMaximaDeProdutosParaVendaAVista() {
    int quantidade = VendaService.QTDE_MAX_PROD_VENDA_A_VISTA + 1;
    Venda venda = new Venda(VENDA_ID_TESTE, Venda.A_VISTA, "Arroz", quantidade, 400.0, new Date());

    given().
      contentType(ContentType.JSON).
      body(venda).
    when().
      post("/api/vendas").
    then().
      statusCode(Status.INTERNAL_SERVER_ERROR.getStatusCode()).
      body(containsString(VendaService.MSG_FALHA_QTDE_MAX_PROD_VENDA_A_VISTA));
  }
}
