package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Model Klasse der Eiskreation beinhaltet alle informationen über die 
 * Eiskreation des Users und berechnet den Preis
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class Eiskreation {
	
	private String name;
	private List<Eis> eissorten = new ArrayList<Eis>();
	private Behaelter behaelter;
	private List<Toppings> toppings = new ArrayList<Toppings>();
	
	private double kreationPreis;
	
	/**
	 * Konstruktor des Eiskreation Objekts, definiert Werte des Objekts
	 * 
	 * @param n String welcher Wert Name bestimmt
	 * @param e List welche die ausgewählten Eissorten beinhaltet 
 	 * @param b Behaelter welcher ausgewählten Behälter beinhaltet
	 * @param t List welche die ausgewählten toppings beinhaltet
	 */
	public Eiskreation(String n, List<Eis> e, Behaelter b, List<Toppings> t) {
		this.name = n;
		this.eissorten = e;
		this.behaelter = b;
		this.toppings = t;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Eis> getEissorten() {
		return eissorten;
	}
	
	public Behaelter getBehaelter() {
		return behaelter;
	}
	
	public List<Toppings> getToppings() {
		return toppings;
	}
	
	public void setBehaelter(Behaelter behaelter) {
		this.behaelter = behaelter;
	}
	
	/**
	 * Wandelt den double preis in einen Lesbaren String um
	 * 
	 * @param kp double welcher den Preis der Kreation beinhaltet
	 * @return lesbaren Preis
	 */
	public String doubleToString(double kp) {
		DecimalFormat df = new DecimalFormat("#.##");
		String tmp = df.format(kp);
		if(tmp.length() == 1) {
			tmp += ",";
		}
		while(tmp.length() <= 3) {
			tmp += "0";
		}
		return tmp;
	}
	
	/**
	 * Berechnet den Preis der Eiskreation
	 * 
	 * @return Gesammtpreis der Kration
	 */
	public double berechnen(List<Toppings> top, List<Eis> eis, Behaelter beh) {
		kreationPreis = 0;
		if (top == null) {
			kreationPreis += 0;
		} else {
			for (Toppings t : top) {
				kreationPreis += t.getPreis();
			}
		}
		if (eis == null) {
			kreationPreis += 0;
		} else {
			for (Eis e : eis) {
				kreationPreis += e.getPreis();
			}
		}
		if (beh == null) {
			kreationPreis += 0;
		} else {
			kreationPreis += beh.getPreis();
		}

		return kreationPreis;
	}

	public double getKreationPreis() {
		return kreationPreis;
	}
	
}
