package model;

import javax.swing.JToggleButton;

/**
 * Model für den EisToggleButton, erbt von der Klasse JToggleButton,
 * fügt einen String zur identifizierung hinzu
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class EisToggleButton extends JToggleButton{
	
	private String name;
	private String toggelName;
	
	/**
	 * Konstruktor des EisToggleButton, definiert dessen Werte
	 * @param n String der Wert namen bestimmt
	 */
	public EisToggleButton(String n, String tn) {
		super(tn);
		this.name = n;
	}
	
	public String getName() {
		return name;
	}

}
