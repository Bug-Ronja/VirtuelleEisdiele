package model;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Model Klasse für Eis, definiert alle Attribute des Objektes
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class Eis {
	
	private String name;
	private boolean vegan;
	private boolean fruktosefrei;
	private double preis;
	private ImageIcon bild;
	
	/**
	 * Konstrutor des Eis Objektes definiert Werte des Objektes
	 * 
	 * @param n String welcher Wert des Namen setzt
	 * @param v boolean welcher Wert des boolean vegan bestimmt
	 * @param f boolean welcher Wert des boolean fruktosefrei bestimmt
	 * @param p double welcher Wert des Preises setzt
	 * @param b ImageIcon welches Wert des Bildes setzt
	 */
	public Eis(String n, boolean v, boolean f, double p, ImageIcon b) {
		this.name = n;
		this.vegan = v;
		this.fruktosefrei = f;
		this.preis = p;
		this.bild = b;
	}
	
	/**
	 * Wandelt eine URL in ein ImageIcon um
	 * 
	 * @param url URL als Ortsangabe für das Bild
	 * @return ImageIcon für das Objekt
	 */
	public ImageIcon parseImageIcon(URL url) {
		ImageIcon img = new ImageIcon(url);
		return img;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getVegan() {
		return vegan;
	}
	
	public boolean getFruktosefrei() {
		return fruktosefrei;
	}
	
	public double getPreis() {
		return preis;
	}
	
	public ImageIcon getBild() {
		return bild;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}
	
	public void setFruktosefrei(boolean fruktosefrei) {
		this.fruktosefrei = fruktosefrei;
	}
	
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public void setBild(ImageIcon bild) {
		this.bild = bild;
	}

}
