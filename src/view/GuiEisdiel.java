package view;

import java.awt.GridBagLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import controller.VEisdieleController;
import model.VEisdielenModel;

/**
 * GuiEisdiel Klasse erstellt GUI das Start Fenster 
 * 
 * @author Ronja Bergemann & Albina Sebold
 *
 */

@SuppressWarnings("serial")
public class GuiEisdiel extends JFrame {

	private JLabel labelErstesfenster;

	public JButton buttonStart;

	private Icon startbild;

	private Eissorte es;
	private Waehlen w;
	private Fehlermeldung f;

	private VEisdielenModel vem;

	private VEisdieleController controller = new VEisdieleController(es, this, w, f, vem);

	public GuiEisdiel(String title) {

		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLayout(new GridBagLayout());
		setSize(600, 400); 
		setResizable(false); 
		startbild = new ImageIcon(getClass().getResource("/image/Eis.jpg"));

		
		/**
		 * Ein Bild wird angezeigt und Start Button für das nächste Fenster
		 */	
		
		intiComponents();

		add(labelErstesfenster);
		add(buttonStart); 

		buttonStart.addActionListener(controller);

		setLocationRelativeTo(null); 
		setVisible(true); // 
	}
	
	/**
	 * Initialisiert Komponente, welche auf der GUI angezeigt werden
	 */
	private void intiComponents() {

		labelErstesfenster = new JLabel(startbild);
		buttonStart = new JButton("Start");

	}
	
	/**
	 * Schließt ein JFrame
	 * @param frame JFrame welches geschlossen werden soll
	 */
	public void close(JFrame frame) {
		frame.dispose();
	}

}
