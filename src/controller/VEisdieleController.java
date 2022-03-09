package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import model.Behaelter;
import model.Eis;
import model.EisToggleButton;
import model.Eiskreation;
import model.Toppings;
import model.VEisdielenModel;
import view.Eissorte;
import view.Fehlermeldung;
import view.Animation;
import view.GuiEisdiel;
import view.Waehlen;

/**
 * Controller Klasse für die Virtuelle Eisdiele, agiert zwischen den Views und
 * dem Model und bestimmt was durch die User Interaktion geschehen soll
 * 
 * @author Ronja Bergemann & Albina Sebold
 *
 */

public class VEisdieleController implements ActionListener {

	private Eissorte es;
	private GuiEisdiel ge;
	private Waehlen w;
	private Fehlermeldung f;

	private VEisdielenModel vem;

	/**
	 * Zuweisung der Views und des Models
	 * 
	 * @param s  Eissorte Objekt von der Virtuellen Eisdiele
	 * @param g  GuiEisdiele Objekt von der Virtuellen Eisdiele
	 * @param w  Waehlen Objekt von der Virtuellen Eisdiele
	 * @param fm Fehlermeldung Objekt von der Virtuellen Eisdiele
	 * @param m  VEisdielenModel Objekt von der Virtuellen Eisdiele
	 */
	public VEisdieleController(Eissorte s, GuiEisdiel g, Waehlen w, Fehlermeldung fm, VEisdielenModel m) {
		this.es = s;
		this.ge = g;
		this.w = w;
		this.f = fm;
		this.vem = m;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object react = e.getSource();

		if (react == ge.buttonStart) {
			ge.close(ge);
			Waehlen w = new Waehlen("Unsere Eisdiele");
		} else if (react == w.buttonAlle) {
			vem.setAlleEissorten();
			if (vem.getAlleEissorten()) {
				f.meldungeSorteAlle();
			}
		} else if (react == w.buttonFructosefrei) {
			vem.setFfEissorten();
			if (vem.getFfEissorten()) {
				f.meldungesorteFruktosefrei();
			}
		} else if (react == w.buttonVegan) {
			vem.setVeganeEissorten();
			if (vem.getVeganeEissorten()) {
				f.meldungesorteVegan();
			}
		} else if (react == w.buttonWeiter) {
			if (vem.getAlleEissorten() == false && vem.getFfEissorten() == false && vem.getVeganeEissorten() == false) {
				f.meldungEissorte();
			} else if (w.kreationName.getText().isEmpty()) {
				f.meldungEiskreation();
			} else {
				String n = w.kreationName.getText();
				Eissorte s = new Eissorte("Unsere Eisdiele");

				s.ae = w.vem.getAlleEissorten();
				s.ff = w.vem.getFfEissorten();
				s.ve = w.vem.getVeganeEissorten();
				if (w.getKunde() != null) {
					s.setKunde(w.getKunde());
				}
				ge.close(w);
				s.setKreationName(n);
			}
		} else if (react == es.buttonEisortedazufuegen) {
			es.dialogNeuesEis();
		} else if (react == es.buttonBehaelter) {
			es.dialogBehaelter();
		} else if (react == es.buttonEissorte) {
			es.dialogEissorte();
		} else if (react == es.buttonTopping) {
			es.dialogTopping();
		} else if (react == es.buttonBestellen) {
			if (vem.getBestellung().getBehaelter() == null) {
				f.meldungWaffel();
			} else {
				Eiskreation ek = new Eiskreation(es.getKrationenName(), vem.getBestellung().getEissorten(),
						vem.getBestellung().getBehaelter(), vem.getBestellung().getToppings());
				vem.getBestellung().hinzufuegenEiskreation(ek);
				es.getKunde().anlegen(ek);
				es.bestellungBestaetigen();
			}

		} else if (react == es.buttonZurueckende) {
			ge.close(es);
			Waehlen w = new Waehlen("Unsere Eisdiele");
		} else if (react == es.buttonWeiterBestellen) {
			if (vem.getBestellung().getBehaelter() == null) {
				f.meldungWaffel();
			} else if (es.getKunde().getBestellung().size() == 7 ) {
				f.meldungMaxBestellungen();
			} else {
				Eiskreation ek = new Eiskreation(es.getKrationenName(), vem.getBestellung().getEissorten(),
						vem.getBestellung().getBehaelter(), vem.getBestellung().getToppings());
				vem.getBestellung().hinzufuegenEiskreation(ek);
				es.getKunde().anlegen(ek);
				Waehlen w = new Waehlen("Unsere Eisdiele");
				w.setKunde(es.getKunde());
				ge.close(es);
			}
		} else if (react == es.buttonSpeichertBeh) {
			int count = 0;
			for (EisToggleButton et : es.getEtb()) {
				if (et.isSelected()) {
					count++;
				}
			}
			if (count > 1) {
				f.meldungZuVieleWaffeln();
			} else {
				for (EisToggleButton et : es.getEtb()) {
					if (et.isSelected()) {
						for (Behaelter beh : vem.getBehaelter()) {
							if (et.getName().equals(beh.getName())) {
								vem.getBestellung().setBehealter(beh);
							}
						}
					}
				}
				es.closeDialog(es.behaelter);
				es.update(es.labelTexteis, es.labelTextpreis);
			}
		} else if (react == es.buttonSpeichertEis) {
			for (EisToggleButton et : es.getEtb()) {
				if (et.isSelected()) {
					for (Eis eis : vem.getEissorten()) {
						if (et.getName().equals(eis.getName())) {
							vem.getBestellung().hinzufuegenEis(eis);
						}
					}
				}
			}
			es.closeDialog(es.eissorten);
			es.update(es.labelTexteis, es.labelTextpreis);
		} else if (react == es.buttonSpeichertTop) {
			for (EisToggleButton et : es.getEtb()) {
				if (et.isSelected()) {
					for (Toppings top : vem.getToppingts()) {
						if (et.getName().equals(top.getName())) {
							vem.getBestellung().hinzufuegenTopping(top);
						}
					}
				}
			}
			es.closeDialog(es.toppings);
			es.update(es.labelTexteis, es.labelTextpreis);
		} else if (react == es.buttonSpeichernneu) {
			if (es.fieldName.getText().isEmpty() || es.fieldPreis.getText().isEmpty()) {
				f.meldungKeineEingabe();
			} else {
				vem.checkEisValues(es.fieldName.getText(), es.radioVegan.isSelected(),
						es.radioFruktosefrei.isSelected(), es.fieldPreis.getText(), (ImageIcon) es.bildLabel.getIcon());
				if (vem.getCheckValues()) {
					es.closeDialog(es.neuesEis);
					f.meldungErfolgreich();
				} else {
					f.meldungFalscheEingabe();
				}
			}

		} else if (react == es.buttonBild) {
			es.uploadPic();
		} else if (react == es.buttonBestellungBestaetigen) {
			es.closeDialog(es.bestellungBestaetigen);
			ge.close(es);
			Animation ai = new Animation("Danke!");
		}
	}

}
