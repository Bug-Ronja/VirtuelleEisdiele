package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VEisdielenModelTest {

	@Test
	void test() {
		VEisdielenModel model = new VEisdielenModel();
		
		Eis eis = new Eis("Erdbeereis", false, false, 0.20, null);
		eis.setBild(eis.parseImageIcon(getClass().getResource("/image/Erdbeer.jpg")));
		Behaelter waffel = new Behaelter("Waffel", 0.90, null);
		waffel.setBild(waffel.parseImageIcon(getClass().getResource("/image/Waffel.jpg")));
		Toppings streusel = new Toppings("Streusel", 0.10, null, false, true);
		streusel.setBild(streusel.parseImageIcon(getClass().getResource("/image/Schokostreuﬂel.jpg")));
		
		model.hinzufuegenEissorte(eis);
		model.hinzufuegenBehaelter(waffel);
		model.hinzufuegenTopping(streusel);
		
		assertEquals(21, model.getEissorten().size());
		assertEquals(4, model.getBehaelter().size());
		assertEquals(11, model.getToppingts().size());
	}

}
