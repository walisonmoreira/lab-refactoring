package lab.refactoring.web.venda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Testes unitários do enum {@link TIPO_VENDA}.
 * 
 * @author Danilo Guimarães
 *
 */
public class TIPO_VENDATest {
	
	@Test
	public void testFromTipoVendaAVista() {
		TIPO_VENDA actual = TIPO_VENDA.from("A_VISTA");
		
		assertEquals(TIPO_VENDA.A_VISTA, actual);
	}
	
	@Test
	public void testFromTipoVendaAPrazo() {
		TIPO_VENDA actual = TIPO_VENDA.from("A_PRAZO");
		
		assertEquals(TIPO_VENDA.A_PRAZO, actual);
	}
	
	@Test
	public void testFromTipoVendaDesconhecido() {
		assertNull(TIPO_VENDA.from("DESCONHECIDO"));
	}

}
