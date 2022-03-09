package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EiskreationTest {

	@Test
	void test() {
		Eis eis = new Eis("Erdbeereis", false, false, 0.20, null);
		Toppings streusel = new Toppings("Streusel", 0.10, null, false, true);
		streusel.setBild(streusel.parseImageIcon(getClass().getResource("/image/Schokostreuﬂel.jpg")));
		String name = "TestEis";
		
		Behaelter waffel = new Behaelter("Waffel", 0.90, null);
		waffel.setBild(waffel.parseImageIcon(getClass().getResource("/image/Waffel.jpg")));
		Bestellung testB = new Bestellung();
		
		testB.hinzufuegenEis(eis);
		testB.hinzufuegenTopping(streusel);
		
		Eiskreation test = new Eiskreation(name, testB.getEissorten(), waffel, testB.getToppings());
		
		assertEquals("TestEis", test.getName());
		assertEquals(1, test.getEissorten().size());
		assertEquals("Waffel", test.getBehaelter().getName());
		assertEquals(1, test.getToppings().size());
		assertEquals("1,20", test.doubleToString(test.berechnen(test.getToppings(), test.getEissorten(), test.getBehaelter())));
	}

}
