package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KundeTest {

	@Test
	void test() {
		
		Bestellung testB = new Bestellung();
		
		Eis eis = new Eis("Erdbeereis", false, false, 0.20, null);
		Toppings streusel = new Toppings("Streusel", 0.10, null, false, true);
		
		String name = "TestEis";
		Behaelter waffel = new Behaelter("Waffel", 0.90, null);
		
		testB.hinzufuegenEis(eis);
		testB.hinzufuegenTopping(streusel);
		
		Eiskreation test = new Eiskreation(name, testB.getEissorten(), waffel, testB.getToppings());
		
		testB.hinzufuegenEiskreation(test);
		
		Kunde testK = new Kunde();
		testK.anlegen(test);
		
		assertEquals(1, testK.getBestellung().size());
	}

}
