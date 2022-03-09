package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BehaelterTest {

	@Test
	void test() {
		Vererbung waffel = new Behaelter("Waffel", 0.90, null);
		waffel.setBild(waffel.parseImageIcon(getClass().getResource("/image/Waffel.jpg")));
		
		assertEquals("Waffel", waffel.getName());
		assertEquals(0.90, waffel.getPreis());
		assertNotNull(waffel.getBild());
	}

}
