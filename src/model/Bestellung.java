package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Model Klasse für die Bestellung, enthällt die Informationen über die
 * ausgewählten Objekte des Users
 * 
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class Bestellung {

	private List<Toppings> toppings = new ArrayList<Toppings>();
	private List<Eis> eissorten = new ArrayList<Eis>();
	private List<Eiskreation> eiskreationen = new ArrayList<Eiskreation>();

	private Behaelter behaelter;
	private String name;

	private double kreationPreis;

	/**
	 * Fügt Toppings Objekt der Liste toppings hinzu
	 * 
	 * @param top Toppings Objekt welches der Liste hinzugefügt wird
	 */
	public void hinzufuegenTopping(Toppings top) {
		toppings.add(top);
	}

	/**
	 * Fügt Eis Objekt der Liste eissorten hinzu
	 * 
	 * @param eis Eis Objekt welches der Liste hinzugefügt wird
	 */
	public void hinzufuegenEis(Eis eis) {
		eissorten.add(eis);
	}

	/**
	 * Fügt Eiskreation Objekt der Liste eiskreationen hinzu
	 * 
	 * @param ek Eiskreationen Objekt welches der Liste hinzugefügt wird
	 */
	public void hinzufuegenEiskreation(Eiskreation ek) {
		eiskreationen.add(ek);
	}

	public void setBehealter(Behaelter b) {
		this.behaelter = b;
	}

	public void setName(String n) {
		this.name = n;
	}

	public List<Toppings> getToppings() {
		return toppings;
	}

	public List<Eis> getEissorten() {
		return eissorten;
	}

	public List<Eiskreation> getEiskreationen() {
		return eiskreationen;
	}

	public Behaelter getBehaelter() {
		return behaelter;
	}

	public String getName() {
		return name;
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
		if (tmp.length() == 1) {
			tmp += ",";
		}
		while (tmp.length() <= 3) {
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
