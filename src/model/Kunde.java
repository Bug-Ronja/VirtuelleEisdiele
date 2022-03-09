package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model Klasse des Kunden Objektes, enthält alle Eiskretionen, welcher der
 * User erstellt hat
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class Kunde {
	
	private List<Eiskreation> bestellung = new ArrayList<Eiskreation>();
	
	/**
	 * Fügt Eiskreation der Bestellung hinzu
	 * @param kreation Eiskreation welche der Liste hinzugefügt wird
	 */
	public void anlegen(Eiskreation kreation) {
		bestellung.add(kreation);
	}
	
	public List<Eiskreation> getBestellung() {
		return bestellung;
	}

}
