package view;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.VEisdieleController;
import model.Bestellung;
import model.Kunde;
import model.VEisdielenModel;

/**
 * Waehlen Klasse hier wird von der GUI das zweite Fenster angezeigt
 * 
 * @author Ronja Bergemann & Albina Sebold
 *
 */

@SuppressWarnings("serial")
public class Waehlen extends JFrame {

	private JLabel labeltext;
	private JLabel labelkreation;

	public JButton buttonAlle;
	public JButton buttonVegan;
	public JButton buttonFructosefrei;
	public JButton buttonWeiter;

	public JTextField kreationName;

	private Eissorte es;
	private GuiEisdiel ge = new GuiEisdiel("");
	private Fehlermeldung f = new Fehlermeldung();

	public VEisdielenModel vem = new VEisdielenModel();

	private VEisdieleController controller = new VEisdieleController(es, ge, this, f, vem);

	private Kunde kunde;

	public Waehlen(String title) {

		ge.close(ge);

		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(600, 400);
		setResizable(false);

		/**
		 * Hier kann man seine Vorlieben der Eissorte auswaehlen
		 */

		intiComponents();

		add(labeltext);
		add(buttonAlle); //
		add(buttonVegan);
		add(buttonFructosefrei);
		add(labelkreation);
		add(kreationName);
		add(buttonWeiter);

		buttonAlle.addActionListener(controller);
		buttonVegan.addActionListener(controller);
		buttonFructosefrei.addActionListener(controller);
		buttonWeiter.addActionListener(controller);

		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * Initialisiert die Komponenten die auf der Gui angezeigt werden
	 */
	private void intiComponents() {

		labeltext = new JLabel("Wählen Sie ihr Eis aus!   ");
		labeltext.setBounds(90, 35, 200, 40);
		buttonAlle = new JButton("Alle Sorten");
		buttonAlle.setBounds(90, 90, 110, 50);
		buttonVegan = new JButton("Vegan");
		buttonVegan.setBounds(240, 90, 110, 50);
		buttonFructosefrei = new JButton("Fructosefrei");
		buttonFructosefrei.setBounds(390, 90, 110, 50);
		labelkreation = new JLabel("Kreation Name vergeben:");
		labelkreation.setBounds(90, 200, 200, 40);
		kreationName = new JTextField(20);
		kreationName.setBounds(90, 250, 200, 40);
		buttonWeiter = new JButton("weiter");
		buttonWeiter.setBounds(390, 250, 110, 20);
	}

	public void setKunde(Kunde k) {
		this.kunde = k;
	}

	public Kunde getKunde() {
		return kunde;
	}
}
