package lab.refactoring.web;

import static com.jayway.restassured.RestAssured.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.ws.rs.core.Response.Status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import lab.refactoring.web.venda.Venda;
import lab.refactoring.web.venda.VendaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebApplication.class)
@WebIntegrationTest("server.port:0")
public class WebApplicationTests {

  @Autowired
  VendaRepository vendaRepository;

  Venda arroz;
  Venda feijao;

  @Value("${local.server.port}")
  int port;

  @Before
  public void setUp() throws ParseException {
    vendaRepository.deleteAll();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    arroz = new Venda(1, "A_VISTA", "Arroz", 2, 24.0, dateFormat.parse("17/06/2016 08:00"));
    feijao = new Venda(2, "A_PRAZO", "Feijão", 4, 60.0, dateFormat.parse("18/06/2016 08:00"));
    vendaRepository.save(Arrays.asList(arroz, feijao));

    RestAssured.port = port;
  }

  @Test
  public void canFetchArroz() {
    Integer arrozCodigo = arroz.getCodigo();

    when().
      get("/api/vendas/{codigo}", arrozCodigo).
    then().
      statusCode(Status.OK.getStatusCode()).
      contentType(ContentType.JSON).
      body("codigo", Matchers.is(arrozCodigo)).
      body("produto", Matchers.is("Arroz"));
  }
}
