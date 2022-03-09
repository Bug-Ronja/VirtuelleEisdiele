package view;

import javax.swing.JOptionPane;

/**
 * Fehlermeldung und Meldungen, wenn die Ausfuehrung von Controller angefordert wird
 * 
 *  @author Ronja Bergemann & Albina Sebold
 */

public class Fehlermeldung extends JOptionPane {
	
	/**
	 * Leerer Konstrukter, welcher nur zum Zugriff von anderen Klassen dient
	 */
	public Fehlermeldung() {

	}

	public void meldungEissorte() {

		JOptionPane.showMessageDialog(null,
				"Bitte waehlen Sie ihre Eissorte  Alle Sorten, Vegan oder Fructosefrei aus !", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}

	public void meldungEiskreation() {

		JOptionPane.showMessageDialog(null, "Bitte vergeben Sie einen Eiskreation Namen !", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}

	public void meldungWaffel() {

		JOptionPane.showMessageDialog(null, "Bitte waehlen Sie eine Waffel, Deluxe Waffel oder Becher aus !", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}

	public void meldungErfolgreich() {

		JOptionPane.showMessageDialog(null, "Sie haben erfolgreich eine neue Eissorte erstellt !",
				"Erfolgreich erstellt", JOptionPane.INFORMATION_MESSAGE);
	}

	public void meldungeSorteAlle() {

		JOptionPane.showMessageDialog(null, "Sie haben sich für alle Eissorten entschieden!", "Alle Eisorten",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void meldungesorteVegan() {

		JOptionPane.showMessageDialog(null, "Sie haben sich für veganes Eis entschieden!", "Veganes Eis",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void meldungesorteFruktosefrei() {

		JOptionPane.showMessageDialog(null, "Sie haben sich für fructosefreies Eis entschieden!", "Fructosefreies Eis",
				JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void meldungMaxBestellungen() {
		
		JOptionPane.showMessageDialog(null, "Sie haben die maximale Anzahl von 8 Bestellungen erreicht.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void meldungZuVieleWaffeln() {
		
		JOptionPane.showMessageDialog(null, "Sie können nur einen Behälter auswählen!", "Fehler",
				JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void meldungKeineEingabe() {
		
		JOptionPane.showMessageDialog(null, "Sie haben nicht alle Felder ausgefüllt.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void meldungFalscheEingabe() {
		
		JOptionPane.showMessageDialog(null, "Sie haben nicht alle Felder korrekt ausgefüllt.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
		
	}
	
}