package model;

import javax.swing.ImageIcon;

/**
 * Model Klasse für die Toppings
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class Toppings extends Vererbung{
	
	private boolean vegan;
	private boolean fruktosefrei;
	
	/**
	 * Konstruktor des Toppings Objekt welcher die Werte des Objekts definiert
	 * 
	 * @param n String welcher Wert des Namen setzt
	 * @param p double welcher Wert des Preises setzt
	 * @param b ImageIcon welches Wert des Bildes setzt
	 * @param v boolean der Wert von Vegan angibt
	 * @param ff boolean der Wert von Fruktosefrei angibt
	 */
	public Toppings(String n, double p, ImageIcon b, boolean v, boolean ff) {
		super(n, p, b);
		this.vegan = v;
		this.fruktosefrei = ff;
	}
	
	public boolean getVegan() {
		return vegan;
	}
	
	public boolean getFruktosefrei() {
		return fruktosefrei;
	}
	
}
