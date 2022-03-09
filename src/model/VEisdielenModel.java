package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * Model Klasse für die Virtuelle Eisdiele, enthält die Übersicht über 
 * Toppings, Behaelter und Eissorten, überprüft User eingaben auf ihre Richtigkeit
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class VEisdielenModel {

	private List<Eis> eissorten = new ArrayList<Eis>();
	private List<Behaelter> alleBehaelter = new ArrayList<Behaelter>();
	private List<Toppings> alleToppings = new ArrayList<Toppings>();
	
	private Bestellung bestellung = new Bestellung();
	private Kunde kunde = new Kunde();

	private boolean alleEissorten = false;
	private boolean veganeEissorten = false;
	private boolean ffEissorten = false;
	
	private boolean checkValues = false;

	Eis erdbeere = new Eis("Erdbeere", true, false, 0.20, null);
	Eis himbeere = new Eis("Himbeere", true, false, 0.20, null);
	Eis heidelbeere = new Eis("Heidelbeere", true, false, 0.20, null);
	Eis apfel = new Eis("Apfel", true, false, 0.20, null);
	Eis zitrone = new Eis("Zitrone", true, false, 0.20, null);
	Eis banane = new Eis("Banane", true, false, 0.20, null);
	Eis mango = new Eis("Mango", true, false, 0.20, null);
	Eis maracuja = new Eis("Maracuja", true, false, 0.20, null);
	Eis kiwi = new Eis("Kiwi", true, false, 0.20, null);
	Eis kokos = new Eis("Kokos", true, false, 0.20, null);
	
	Eis cookies = new Eis("Cookies", false, true, 0.20, null);
	Eis snickers = new Eis("Snickers", false, true, 0.20, null);
	Eis karamell = new Eis("Karamell", false, true, 0.20, null);
	Eis tiramisu = new Eis("Tiramisu", false, true, 0.20, null);
	Eis stracciatella = new Eis("Stracciatella", false, true, 0.20, null);
	Eis schoko = new Eis("Schoko", false, true, 0.20, null);
	Eis weisseschoko = new Eis("Weißeschoko", false, true, 0.20, null);
	Eis vanille = new Eis("Vanille", false, true, 0.20, null);
	Eis walnuss = new Eis("Walnuss", false, true, 0.20, null);
	Eis haselnuss = new Eis("Haselnuss", false, true, 0.20, null);
	
	Toppings erdbeersosse = new Toppings("Erdbeersoße", 0.10, null, true, false);
	Toppings heissekirsche = new Toppings("Heißekirsche", 0.10, null, true, false);
	Toppings obst = new Toppings("Obst", 0.10, null, true, false);
	Toppings kokosstreussel = new Toppings("Kokosstreußel", 0.10, null, true, false);
	Toppings sahne = new Toppings("Sahne", 0.10, null, false, true);
	Toppings karamelsosse = new Toppings("Karamellsoße", 0.10, null, true, false);
	Toppings schokososse = new Toppings("Schokosoße", 0.10, null, false, true);
	Toppings schokostreussel = new Toppings("Schokostreußel", 0.10, null, false, true);
	Toppings buntestreussel = new Toppings("Buntestreußel", 0.10, null, true, true);
	Toppings smarties = new Toppings("Smarties", 0.10, null, false, true);
	
	Behaelter waffel = new Behaelter("Waffel", 0.30, null);
	Behaelter deluxeWaffel = new Behaelter("Deluxe Waffel", 0.50, null);
	Behaelter becher = new Behaelter("Becher", 0.20, null);
	
	/**
	 * Konstruktor fügt alle erstellten Eis-, Topping- und Behealter-Objekte
	 * den Listen hinzu, legt außerdem Bilder fest
	 */
	public VEisdielenModel() {
		// alle veganen Eissorten
		erdbeere.setBild(erdbeere.parseImageIcon(getClass().getResource("/image/Erdbeer.jpg")));
		hinzufuegenEissorte(erdbeere);
		himbeere.setBild(himbeere.parseImageIcon(getClass().getResource("/image/Himbeer.jpg")));
		hinzufuegenEissorte(himbeere);
		heidelbeere.setBild(heidelbeere.parseImageIcon(getClass().getResource("/image/Heidelbeer.jpg")));
		hinzufuegenEissorte(heidelbeere);
		apfel.setBild(apfel.parseImageIcon(getClass().getResource("/image/Apfel.jpg")));
		hinzufuegenEissorte(apfel);
		zitrone.setBild(zitrone.parseImageIcon(getClass().getResource("/image/Zitrone.jpg")));
		hinzufuegenEissorte(zitrone);
		banane.setBild(banane.parseImageIcon(getClass().getResource("/image/Banane.jpg")));
		hinzufuegenEissorte(banane);
		mango.setBild(mango.parseImageIcon(getClass().getResource("/image/Mango.jpg")));
		hinzufuegenEissorte(mango);
		maracuja.setBild(maracuja.parseImageIcon(getClass().getResource("/image/Maracuja.jpg")));
		hinzufuegenEissorte(maracuja);
		kiwi.setBild(kiwi.parseImageIcon(getClass().getResource("/image/Kiwi.jpg")));
		hinzufuegenEissorte(kiwi);
		kokos.setBild(kokos.parseImageIcon(getClass().getResource("/image/Kokos.jpg")));
		hinzufuegenEissorte(kokos);
		// alle fruktosefreien Eissorten
		cookies.setBild(cookies.parseImageIcon(getClass().getResource("/image/Cookies.jpg")));
		hinzufuegenEissorte(cookies);
		snickers.setBild(snickers.parseImageIcon(getClass().getResource("/image/Snickers.jpg")));
		hinzufuegenEissorte(snickers);
		karamell.setBild(karamell.parseImageIcon(getClass().getResource("/image/Karamell.jpg")));
		hinzufuegenEissorte(karamell);
		tiramisu.setBild(tiramisu.parseImageIcon(getClass().getResource("/image/Tiramisu.jpg")));
		hinzufuegenEissorte(tiramisu);
		stracciatella.setBild(stracciatella.parseImageIcon(getClass().getResource("/image/Stracciatella.jpg")));
		hinzufuegenEissorte(stracciatella);
		schoko.setBild(schoko.parseImageIcon(getClass().getResource("/image/Schokolade.jpg")));
		hinzufuegenEissorte(schoko);
		weisseschoko.setBild(weisseschoko.parseImageIcon(getClass().getResource("/image/Weißeschokolade.jpg")));
		hinzufuegenEissorte(weisseschoko);
		vanille.setBild(vanille.parseImageIcon(getClass().getResource("/image/Vanillee.jpg")));
		hinzufuegenEissorte(vanille);
		walnuss.setBild(walnuss.parseImageIcon(getClass().getResource("/image/Walnuss.jpg")));
		hinzufuegenEissorte(walnuss);
		haselnuss.setBild(haselnuss.parseImageIcon(getClass().getResource("/image/Haselnuss.jpg")));
		hinzufuegenEissorte(haselnuss);
		// alle Toppings 
		erdbeersosse.setBild(erdbeersosse.parseImageIcon(getClass().getResource("/image/Erdbeersoße.jpg")));
		hinzufuegenTopping(erdbeersosse);
		heissekirsche.setBild(heissekirsche.parseImageIcon(getClass().getResource("/image/Heißekirsche.jpg")));
		hinzufuegenTopping(heissekirsche);
		obst.setBild(obst.parseImageIcon(getClass().getResource("/image/Frischesobst.jpg")));
		hinzufuegenTopping(obst);
		kokosstreussel.setBild(kokosstreussel.parseImageIcon(getClass().getResource("/image/Kokosstreußel.jpg")));
		hinzufuegenTopping(kokosstreussel);
		sahne.setBild(sahne.parseImageIcon(getClass().getResource("/image/Sahne.jpg")));
		hinzufuegenTopping(sahne);
		karamelsosse.setBild(karamelsosse.parseImageIcon(getClass().getResource("/image/Karamellsoße.jpg")));
		hinzufuegenTopping(karamelsosse);
		schokososse.setBild(schokososse.parseImageIcon(getClass().getResource("/image/Schokosoße.jpg")));
		hinzufuegenTopping(schokososse);
		smarties.setBild(smarties.parseImageIcon(getClass().getResource("/image/Smarties.jpg")));
		hinzufuegenTopping(smarties);
		schokostreussel.setBild(schokostreussel.parseImageIcon(getClass().getResource("/image/Schokostreußel.jpg")));
		hinzufuegenTopping(schokostreussel);
		buntestreussel.setBild(buntestreussel.parseImageIcon(getClass().getResource("/image/Streußel.jpg")));
		hinzufuegenTopping(buntestreussel);
		// alle Behaelter
		waffel.setBild(waffel.parseImageIcon(getClass().getResource("/image/Waffel.jpg")));
		hinzufuegenBehaelter(waffel);
		deluxeWaffel.setBild(deluxeWaffel.parseImageIcon(getClass().getResource("/image/WaffelDelux.jpg")));
		hinzufuegenBehaelter(deluxeWaffel);
		becher.setBild(becher.parseImageIcon(getClass().getResource("/image/Becher.jpg")));
		hinzufuegenBehaelter(becher);
	}
	
	/**
	 * Fügt Eis der Liste eissorten hinzu
	 * @param eissorte Eis Objekt welches der Liste hinzugefügt wird
	 */
	public void hinzufuegenEissorte(Eis eissorte) {
		eissorten.add(eissorte);
	}
	
	/**
	 * Fügt Behaelter der Liste alleBehaelter hinzu
	 * @param behaelter Behaelter Objekt welches der Liste hinzugefügt wird
	 */
	public void hinzufuegenBehaelter(Behaelter behaelter) {
		alleBehaelter.add(behaelter);
	}
	
	/**
	 * Fügt Topping der Liste alleToppings hinzu
	 * @param topping Tpoppings Objekt welches der Liste hinzugefügt wird
	 */
	public void hinzufuegenTopping(Toppings topping) {
		alleToppings.add(topping);
	}
	
	public List<Eis> getEissorten() {
		return eissorten;
	}

	public List<Behaelter> getBehaelter() {
		return alleBehaelter;
	}

	public List<Toppings> getToppingts() {
		return alleToppings;
	}
	
	public boolean getAlleEissorten() {
		return alleEissorten;
	}
	
	public boolean getVeganeEissorten() {
		return veganeEissorten;
	}
	
	public boolean getFfEissorten() {
		return ffEissorten;
	}
	
	public boolean getCheckValues() {
		return checkValues;
	}
	
	public Bestellung getBestellung() {
		return bestellung;
	}
	
	public Kunde getKunde() {
		return kunde;
	}
	
	/**
	 * Setzt Wert des boolean alleEissorten
	 */
	public void setAlleEissorten() {
		if(alleEissorten) {
			alleEissorten = false;
		} else {
			alleEissorten = true;
			veganeEissorten = false;
			ffEissorten = false;
		}
	}
	
	/**
	 * Setzt Wert des boolean veganeEissorten
	 */
	public void setVeganeEissorten() {
		if(veganeEissorten) {
			veganeEissorten = false;
		} else {
			veganeEissorten = true;
			alleEissorten = false;
			ffEissorten = false;
		}
	}
	
	/**
	 * Setzt Wert des boolean ffEissorten
	 */
	public void setFfEissorten() {
		if(ffEissorten) {
			ffEissorten = false;
		} else {
			ffEissorten = true;
			alleEissorten = false;
			veganeEissorten = false;
		}
	}
	
	public void setKunde(Kunde k) {
		this.kunde = k;
	}
	
	/**
	 * Überprüft, ob die Eingaben des Useres funktionieren
	 * 
	 * @param n String welcher den Namen des Eises bestimmt
	 * @param v boolean welcher Wert des boolean vegan bestimmt
	 * @param ff boolean welcher Wert des boolean fruktosefrei bestimmt
	 * @param p String welcher in einen double gecastet wird um Wert des Preises zu bestimmen
	 * @param i ImageIcon welches Bild der neuen Eissorte hinzufügt
	 * @return boolean für die korrekte bzw. unkorrekte Eingabe
	 */
	public boolean checkEisValues(String n, boolean v, boolean ff, String p, ImageIcon i) {
		try {
			double preis = Double.valueOf(p);
			if(preis > 0) {
				Eis neuesEis = new Eis(n, v, ff, preis, i);
			hinzufuegenEissorte(neuesEis);
			checkValues = true;
			} else {
				checkValues = false;
			}
		} catch (Exception e) {
			checkValues = false;
		}
		return checkValues;
	}

}
