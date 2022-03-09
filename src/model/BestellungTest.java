package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BestellungTest {

	@Test
	void test() {
		Bestellung best = new Bestellung();
		
		Eis eis = new Eis("Erdbeereis", false, false, 0.20, null);
		eis.setBild(eis.parseImageIcon(getClass().getResource("/image/Erdbeer.jpg")));
		best.hinzufuegenEis(eis);
		
		Toppings streusel = new Toppings("Streusel", 0.10, null, false, true);
		streusel.setBild(streusel.parseImageIcon(getClass().getResource("/image/Schokostreuﬂel.jpg")));
		best.hinzufuegenTopping(streusel);
		
		assertEquals(1, best.getEissorten().size());
		assertEquals(1, best.getToppings().size());
	}

}
