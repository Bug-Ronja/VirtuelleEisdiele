package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ToppingsTest {

	@Test
	void test() {
		Vererbung streusel = new Toppings("Streusel", 0.10, null, false, true);
		streusel.setBild(streusel.parseImageIcon(getClass().getResource("/image/Schokostreuﬂel.jpg")));
		
		assertEquals("Streusel", streusel.getName());
		assertEquals(0.10, streusel.getPreis());
		assertNotNull(streusel.getBild());
	}

}
