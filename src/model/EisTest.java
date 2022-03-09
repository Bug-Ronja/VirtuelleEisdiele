package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EisTest {

	@Test
	void test() {
		Eis eis = new Eis("Erdbeereis", false, false, 0.20, null);
		eis.setBild(eis.parseImageIcon(getClass().getResource("/image/Erdbeer.jpg")));
		
		assertEquals("Erdbeereis", eis.getName());
		assertFalse(eis.getVegan());
		assertFalse(eis.getFruktosefrei());
		assertEquals(0.20, eis.getPreis());
		assertNotNull(eis.getBild());	
	}

}
