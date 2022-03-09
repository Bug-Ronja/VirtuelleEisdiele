package model;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Model Klasse für die Vererbung
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class Vererbung {
	
	private String name;
	private double preis;
	private ImageIcon bild;
	
	/**
	 * Konstruktor definiert bestandteile des Vererbung Objekts
	 *  
	 * @param n String welcher Wert für den Namen setzt
	 * @param p double welcher Wert für den Preis setzt
	 * @param b ImageIcon welcher Wert für das Bild setzt
	 */
	public Vererbung(String n, double p, ImageIcon b) {
		this.name = n;
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
	
	public double getPreis() {
		return preis;
	}
	
	public ImageIcon getBild() {
		return bild;
	}
	
	public void setBild(ImageIcon bild) {
		this.bild = bild;
	}

}
