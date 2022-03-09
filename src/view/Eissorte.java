package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.VEisdieleController;
import model.Behaelter;
import model.Eis;
import model.EisToggleButton;
import model.Eiskreation;
import model.Kunde;
import model.Toppings;
import model.VEisdielenModel;

/**
 * Eissorte Klasse erstellt GUI das dritte Fenster der Virtuellen Eisdiele
 * 
 * @author Ronja Bergemann & Albina Sebold
 *
 */

@SuppressWarnings("serial")
public class Eissorte extends JFrame {

	public JButton buttonSpeichertEis;
	public JButton buttonSpeichertTop;
	public JButton buttonSpeichertBeh;
	public JButton buttonSpeichernneu;
	public JButton buttonBestellungBestaetigen;

	private JLabel labelKration;
	private JLabel labelPreis;
	public JButton buttonBehaelter;
	public JButton buttonEissorte;
	public JButton buttonTopping;
	public JButton buttonWeiterBestellen;
	public JButton buttonEisortedazufuegen;
	public JButton buttonZurueckende;
	public JButton buttonBestellen;

	public JLabel labelTexteis;
	public JLabel labelTextpreis;

	private JLabel labelName;
	private JLabel labelPreisNeu;
	public JRadioButton radioVegan;
	public JRadioButton radioFruktosefrei;
	private JLabel labelUnver;
	private JLabel labelBild;
	public JTextField fieldName;
	public JTextField fieldPreis;
	public JLabel bildLabel;
	public JButton buttonBild;

	private JLabel platz = new JLabel();

	private JTextField kreationName;

	private List<EisToggleButton> etb = new ArrayList<EisToggleButton>();

	private GuiEisdiel ge = new GuiEisdiel("");
	private Waehlen w = new Waehlen("");
	private Fehlermeldung f = new Fehlermeldung();

	private VEisdielenModel vem = new VEisdielenModel();

	private GridLayout glEis = new GridLayout(6, 4, 20, 20);

	private GridLayout glTop = new GridLayout(6, 4, 20, 20);

	private GridLayout glBeh = new GridLayout(4, 2, 20, 20);

	private GridLayout glBes = new GridLayout(2, 2, 20, 20);

	private VEisdieleController controller = new VEisdieleController(this, ge, w, f, vem);

	private Kunde kunde = new Kunde();

	public boolean ae;
	public boolean ve;
	public boolean ff;

	public JDialog eissorten = new JDialog();
	public JDialog toppings = new JDialog();
	public JDialog behaelter = new JDialog();
	public JDialog neuesEis = new JDialog();
	public JDialog bestellungBestaetigen = new JDialog();

	private JTextPane neueseis = new JTextPane();
	private JTextPane hinztop = new JTextPane();
	private JTextPane hinzbeh = new JTextPane();
	private JTextPane neuesEisHinz = new JTextPane();
	private JTextPane bestellBestaetigung = new JTextPane();

	/**
	 * Erstellt Fenster, über welchem man sich eine Eiskreation erstellt
	 * @param title String, welcher den Titel des Fensters angibt
	 */
	public Eissorte(String title) {

		ge.close(ge);
		ge.close(w);

		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLayout(null);
		setSize(600, 400); 
		setResizable(false); 
		
		intiComponents();

		add(kreationName);
		add(buttonBehaelter);
		add(buttonEissorte);
		add(buttonTopping);
		add(labelKration);
		add(labelPreis);
		add(buttonWeiterBestellen);
		add(buttonEisortedazufuegen);
		add(buttonZurueckende);
		add(buttonBestellen);
		add(labelTexteis);
		add(labelTextpreis);

		buttonEisortedazufuegen.addActionListener(controller);
		buttonBehaelter.addActionListener(controller);
		buttonEissorte.addActionListener(controller);
		buttonTopping.addActionListener(controller);
		buttonBestellen.addActionListener(controller);
		buttonZurueckende.addActionListener(controller);
		buttonWeiterBestellen.addActionListener(controller);

		setLocationRelativeTo(null); // Fenster wird in der mitte angezeigt
		setVisible(true); // Fenster sichtbar

	}
	
/**
 * Initialisiert Komponente, welche auf der GUI angeziegt werden
 */
	private void intiComponents() {

		kreationName = new JTextField(20);
		kreationName.setBounds(30, 20, 200, 25);
		kreationName.setEditable(false);
		buttonBehaelter = new JButton("Behaelter");
		buttonBehaelter.setBounds(90, 70, 110, 40);
		buttonEissorte = new JButton("Eissorte");
		buttonEissorte.setBounds(230, 70, 110, 40);
		buttonTopping = new JButton("Toppings");
		buttonTopping.setBounds(370, 70, 110, 40);
		labelKration = new JLabel("Eiskreation");
		labelKration.setBounds(30, 120, 110, 40);
		labelPreis = new JLabel("Preis");
		labelPreis.setBounds(390, 120, 110, 40);
		buttonWeiterBestellen = new JButton("+ weitere Bestellung");
		buttonWeiterBestellen.setBounds(30, 300, 160, 20);
		buttonEisortedazufuegen = new JButton("Eissorte dazufuegen");
		buttonEisortedazufuegen.setBounds(30, 330, 160, 20);
		buttonZurueckende = new JButton("Bestellung abbrechen");
		buttonZurueckende.setBounds(390, 330, 160, 20);
		buttonBestellen = new JButton("Bestellen");
		buttonBestellen.setBounds(390, 290, 160, 30);
		buttonBestellen.setBackground(new Color(128, 128, 128));
		buttonBestellen.setForeground(new Color(255, 255, 255));
		labelTexteis = new JLabel("");
		labelTexteis.setBounds(30, 160, 330, 130);
		labelTextpreis = new JLabel("");
		labelTextpreis.setBounds(390, 160, 160, 130);

	}

	public void setKreationName(String kn) {
		kreationName.setText(kn);
	}

	public String getKrationenName() {
		return kreationName.getText();
	}

	/**
	 * Erstellt einen JDialog in welchem alle Eissorten angezeigt werden, je nach
	 * auswahl auch nur vegane oder fruktosefreie
	 */
	public void dialogEissorte() {

		etb.removeAll(etb);
		eissorten = new JDialog();

		eissorten.setTitle("Eissorte");
		eissorten.setResizable(false);
		eissorten.setLayout(glEis);
		eissorten.setModal(true);

		if (ae) {
			for (Eis eis1 : vem.getEissorten()) {
				writeIconEis(eis1);
				writeToggleEis(eis1);
			}
		} else if (ff) {
			for (Eis eis1 : vem.getEissorten()) {
				if (eis1.getFruktosefrei()) {
					writeIconEis(eis1);
					writeToggleEis(eis1);
				}
			}
		} else if (ve) {
			for (Eis eis1 : vem.getEissorten()) {
				if (eis1.getVegan()) {
					writeIconEis(eis1);
					writeToggleEis(eis1);
				}
			}
		}

		buttonSpeichertEis = new JButton("Speichern");
		buttonSpeichertEis.setBackground(new Color(128, 128, 128));
		buttonSpeichertEis.setForeground(new Color(255, 255, 255));
		buttonSpeichertEis.addActionListener(controller);

		eissorten.add(platz);
		eissorten.add(buttonSpeichertEis);

		eissorten.setSize(500, 300);
		neueseis.setBackground(getContentPane().getBackground());
		neueseis.setEditable(false);
		eissorten.add(neueseis);

		eissorten.pack();

		eissorten.setLocationRelativeTo(null);

		eissorten.setVisible(true);

	}

	/**
	 * Kreiert ein Icon in welchen das Bild zur jeweiligen Eissorte angezeigt wird
	 * 
	 * @param eis Eis von welchem Bild angezeigt werden soll
	 */
	private void writeIconEis(Eis eis) {

		JLabel icon = new JLabel();

		if (eis.getBild() != null) {
			icon.setIcon(eis.getBild());
		} else {
			icon.setText("Kein Bild");
		}
		eissorten.add(icon);
	}

	/**
	 * Kreiert einen EisToggleButton in welchen der Name zur jeweiligen Eissorte
	 * angezeigt wird
	 * 
	 * @param eis Eis zu welchem Button erstellt werden soll
	 */
	private void writeToggleEis(Eis eis) {
		EisToggleButton toggel = new EisToggleButton(eis.getName(), eis.getName());
		etb.add(toggel);
		eissorten.add(toggel);
	}

	public List<EisToggleButton> getEtb() {
		return etb;
	}

	public void setKunde(Kunde k) {
		this.kunde = k;
	}

	public Kunde getKunde() {
		return kunde;
	}

	/**
	 * Erstellt einen JDialog in welchem alle Toppings angezeigt werden, je nach
	 * auswahl auch nur vegane oder fruktosefreie
	 */
	public void dialogTopping() {

		etb.removeAll(etb);
		toppings = new JDialog();

		toppings.setTitle("Toppings");
		toppings.setResizable(false);
		toppings.setLayout(glTop);
		toppings.setModal(true);

		if (ae) {
			for (Toppings top : vem.getToppingts()) {
				writeIconTop(top);
				writeToggleTop(top);
			}
		} else if (ve) {
			glTop = new GridLayout(4, 2, 20, 20);
			toppings.setLayout(glTop);
			for (Toppings top : vem.getToppingts()) {
				if (top.getVegan()) {
					writeIconTop(top);
					writeToggleTop(top);
				}
			}
		} else if (ff) {
			glTop = new GridLayout(4, 2, 20, 20);
			toppings.setLayout(glTop);
			for (Toppings top : vem.getToppingts()) {
				if (top.getFruktosefrei()) {
					writeIconTop(top);
					writeToggleTop(top);
				}
			}
		}

		buttonSpeichertTop = new JButton("Speichern");
		buttonSpeichertTop.setBackground(new Color(128, 128, 128));
		buttonSpeichertTop.setForeground(new Color(255, 255, 255));
		buttonSpeichertTop.addActionListener(controller);

		toppings.add(platz);
		toppings.add(buttonSpeichertTop);

		toppings.setSize(500, 300);
		hinztop.setBackground(getContentPane().getBackground());
		hinztop.setEditable(false);
		toppings.add(hinztop);

		toppings.pack();

		toppings.setLocationRelativeTo(null);

		toppings.setVisible(true);

	}

	/**
	 * Kreiert ein Icon in welchen das Bild zum jeweiligen Topping angezeigt wird
	 * 
	 * @param top Toppings von welchem Bild angezeigt werden soll
	 */
	private void writeIconTop(Toppings top) {

		JLabel icon = new JLabel(top.getBild());
		toppings.add(icon);
	}

	/**
	 * Kreiert einen EisToggleButton in welchen der Name zum jeweiligen Topping
	 * angezeigt wird
	 * 
	 * @param top Topping zu welchem Button erstellt werden soll
	 */
	private void writeToggleTop(Toppings top) {
		EisToggleButton toggel = new EisToggleButton(top.getName(), top.getName());
		etb.add(toggel);
		toppings.add(toggel);
	}

	/**
	 * Erstellt einen JDialog in welchem alle Behaelter angezeigt werden
	 */
	public void dialogBehaelter() {

		etb.removeAll(etb);
		behaelter = new JDialog();

		behaelter.setTitle("Behälter");
		behaelter.setResizable(false);
		behaelter.setLayout(glBeh);
		behaelter.setModal(true);

		for (Behaelter beh : vem.getBehaelter()) {
			writeToggleBeh(beh);
			writeIconBeh(beh);
		}

		buttonSpeichertBeh = new JButton("Speichern");
		buttonSpeichertBeh.setBackground(new Color(128, 128, 128));
		buttonSpeichertBeh.setForeground(new Color(255, 255, 255));
		buttonSpeichertBeh.addActionListener(controller);

		behaelter.add(buttonSpeichertBeh);

		behaelter.setSize(500, 300);
		hinzbeh.setBackground(getContentPane().getBackground());
		hinzbeh.setEditable(false);
		behaelter.add(hinzbeh);

		behaelter.pack();

		behaelter.setLocationRelativeTo(null);

		behaelter.setVisible(true);

	}

	/**
	 * Kreiert ein Icon in welchen das Bild zum jeweiligen Behaelter angezeigt wird
	 * 
	 * @param b Behaelter von welchem Bild angezeigt werden soll
	 */
	private void writeIconBeh(Behaelter b) {
		JLabel icon = new JLabel();
		if (b.getBild() != null) {
			icon.setIcon(b.getBild());
		} else {
			icon.setText("Kein Bild vorhanden");
		}
		behaelter.add(icon);
	}

	/**
	 * Kreiert einen EisToggleButton in welchen der Name zum jeweiligen Behaelter
	 * angezeigt wird
	 * 
	 * @param beh Behaelter zu welchem Button erstellt werden soll
	 */
	private void writeToggleBeh(Behaelter b) {
		EisToggleButton toggel = new EisToggleButton(b.getName(), b.getName());
		etb.add(toggel);
		behaelter.add(toggel);
	}

	/**
	 * Ertsellt einen neuen JDialog, in welchem eine neue Eissorte angelegt werden
	 * kann
	 */
	public void dialogNeuesEis() {

		neuesEis.setTitle("Eissorte dazufügen");
		neuesEis.setResizable(false);
		neuesEis.setModal(true);

		neuesEis.setLayout(null);
		neuesEis.setSize(500, 300);
		neuesEisHinz.setBackground(getContentPane().getBackground());
		neuesEisHinz.setEditable(false);
		neuesEis.add(neuesEisHinz);

		labelName = new JLabel("Name Eissorte:");
		labelName.setBounds(70, 20, 200, 40);
		fieldName = new JTextField(30);
		fieldName.setBounds(190, 30, 200, 20);
		labelPreisNeu = new JLabel("Preis:");
		labelPreisNeu.setBounds(70, 50, 200, 40);
		fieldPreis = new JTextField(30);
		fieldPreis.setBounds(190, 60, 200, 20);
		labelUnver = new JLabel("Unverträglichkeit:");
		labelUnver.setBounds(70, 80, 200, 40);
		labelBild = new JLabel("Eis Bild:");
		labelBild.setBounds(70, 110, 100, 40);
		radioVegan = new JRadioButton("Vegan");
		radioVegan.setBounds(185, 85, 75, 30);
		radioFruktosefrei = new JRadioButton("Fruktosefrei");
		radioFruktosefrei.setBounds(260, 85, 100, 30);
		buttonSpeichernneu = new JButton("Speichern");
		buttonSpeichernneu.setBounds(170, 200, 150, 25);
		buttonSpeichernneu.setBackground(new Color(128, 128, 128));
		buttonSpeichernneu.setForeground(new Color(255, 255, 255));
		bildLabel = new JLabel();
		bildLabel.setBounds(330, 120, 60, 40);
		buttonBild = new JButton("Bild hochladen");
		buttonBild.setBounds(190, 120, 120, 40);

		neuesEis.add(labelName);
		neuesEis.add(labelPreisNeu);
		neuesEis.add(labelUnver);
		neuesEis.add(labelBild);
		neuesEis.add(radioVegan);
		neuesEis.add(radioFruktosefrei);
		neuesEis.add(fieldName);
		neuesEis.add(fieldPreis);
		neuesEis.add(buttonSpeichernneu);
		neuesEis.add(bildLabel);
		neuesEis.add(buttonBild);

		buttonSpeichernneu.addActionListener(controller);
		buttonBild.addActionListener(controller);

		neuesEis.setLocationRelativeTo(null);

		neuesEis.setVisible(true);

	}

	/**
	 * Schließt einen JDialog
	 * 
	 * @param d JDialog welcher geschlossen werden soll
	 */
	public void closeDialog(JDialog d) {
		d.dispose();
	}

	/**
	 * Erstellt einen JFileChooser, über welchem man ein Bild auswählen kann
	 */
	public void uploadPic() {
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "png");
		file.addChoosableFileFilter(filter);
		int result = file.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = file.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			bildLabel.setIcon(resizeImage(path));
		} else if (result == JFileChooser.CANCEL_OPTION) {
			bildLabel.setText("Kein Bild ausgewählt");
		}
	}
	
	/**
	 * Skalliert das Bild neu
	 * @param imagePath String, gibt den absoluten Pfad des Bildes an
	 * @return image, welches angezeigt wird
	 */
	private ImageIcon resizeImage(String imagePath) {
		ImageIcon myImage = new ImageIcon(imagePath);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(bildLabel.getWidth(), bildLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

	/**
	 * Updatet JPanel mit Preis und Name der gerade anzulegenden Kreation sowie
	 * schon vorhandenen Kreationen
	 * 
	 * @param t JLabel welches mit Kreationennamen beschrieben wird
	 * @param p JLabel welches mit Kreationenpreis beschrieben wird
	 */
	public void update(JLabel t, JLabel p) {
		t.setText("");
		p.setText("");

		String text = "<html><body>" + kreationName.getText();
		double tmp = vem.getBestellung().berechnen(vem.getBestellung().getToppings(),
				vem.getBestellung().getEissorten(), vem.getBestellung().getBehaelter());
		String preis = "<html><body>" + vem.getBestellung().doubleToString(tmp) + "€";

		if (kunde.getBestellung().size() > 0) {
			for (Eiskreation ek : kunde.getBestellung()) {
				text += "<br>" + ek.getName();
				double tmpek = ek.berechnen(ek.getToppings(), ek.getEissorten(), ek.getBehaelter());
				preis += "<br>" + ek.doubleToString(tmpek) + "€";
			}
		}
		t.setText(text + "</body></html>");
		p.setText(preis + "</body></html>");
	}

	/**
	 * Erstellt ein Fenster mit einer Übersicht über die Bestellung
	 */
	public void bestellungBestaetigen() {

		bestellungBestaetigen = new JDialog();

		bestellungBestaetigen.setTitle("Übersicht");
		bestellungBestaetigen.setResizable(false);
		bestellungBestaetigen.setModal(true);

		bestellungBestaetigen.setLayout(glBes);
		bestellungBestaetigen.setSize(500, 300);
		bestellBestaetigung.setBackground(getContentPane().getBackground());
		bestellBestaetigung.setEditable(false);
		bestellungBestaetigen.add(bestellBestaetigung);

		for (Eiskreation ek : kunde.getBestellung()) {

			JLabel anzeige = new JLabel();
			String text = "";

			text = "<html><body>" + ek.getName() + ": <br>";
			for (Eis e : ek.getEissorten()) {
				text += e.getName() + "<br>";
			}
			for (Toppings t : ek.getToppings()) {
				text += t.getName() + "<br>";
			}
			text += ek.getBehaelter().getName() + "<br>";
			text += ek.doubleToString(ek.berechnen(ek.getToppings(), ek.getEissorten(), ek.getBehaelter()))
					+ "</body></html>";

			anzeige.setText(text);
			bestellungBestaetigen.add(anzeige);
		}

		buttonBestellungBestaetigen = new JButton("Bestellung bestätigen");
		buttonBestellungBestaetigen.setBackground(new Color(128, 128, 128));
		buttonBestellungBestaetigen.setForeground(new Color(255, 255, 255));
		buttonBestellungBestaetigen.addActionListener(controller);

		bestellungBestaetigen.add(platz);
		bestellungBestaetigen.add(buttonBestellungBestaetigen);

		bestellungBestaetigen.pack();

		bestellungBestaetigen.setLocationRelativeTo(null);

		bestellungBestaetigen.setVisible(true);
	}

}
