package model;

import javax.swing.ImageIcon;

/**
 * Model Klasse für die Beahaelter
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class Behaelter extends Vererbung{
	
	/**
	 * Konstruktor des Behaelter Objekts definiert die Werte des Objektes
	 * 
	 * @param n String welcher Wert des Namen setzt
	 * @param p double welcher Wert des Preises setzt
	 * @param b ImageIcon welches Wert des Bildes setzt
	 */
	public Behaelter(String n, double p, ImageIcon b) {
		super(n, p, b);
	}
		
}
