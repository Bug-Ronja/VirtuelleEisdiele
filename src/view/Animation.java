package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animation Klasse hier wird von der GUI das letzte Fenster mit Animation angezeigt
 * 
 * @author Ronja Bergemann & Albina Sebold
 *
 */


@SuppressWarnings("serial")
public class Animation extends JFrame {

	public Animation(String title) {

		Ende en = new Ende();
		JFrame jf = new JFrame();
		jf.setTitle("Eisdiele");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(en);
		jf.setLocationRelativeTo(null); // Fenster wird in der mitte angezeigt
		jf.setVisible(true); 
	}

	/**
	 * @param ActionListener Timer und Geschwindigkeit
	 */	
	
	
	public class Ende extends JPanel implements ActionListener {
		Timer tm = new Timer(5, this);
		int y = 0, velX = 1;

		
		/**
		 * Erstellt Formen für die Animation
		 * @param Graphics g, hier wird der Text, Kreise und Dreieck gezeichnet
		 */	
		
		
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.setColor(new Color(113, 89, 72));
			g.setFont(new Font("Comic Sans", Font.PLAIN, 25));
			g.drawString("Vielen Dank für Ihre Bestellung!", 110, 340);

			g.setColor(new Color(155, 197, 213));
			g.fillOval(150, y, 60, 60);

			g.setColor(new Color(239, 159, 158));
			g.fillOval(250, y, 60, 60);

			g.setColor(new Color(163, 215, 192));
			g.fillOval(350, y, 60, 60);

			int[] x = { 150, 180, 210 };
			int[] y = { 180, 300, 180 };

			g.setColor(new Color(201, 174, 155));
			g.fillPolygon(x, y, 3);

			int[] x1 = { 250, 280, 310 };
			int[] y1 = { 180, 300, 180 };

			g.setColor(new Color(201, 174, 155));
			g.fillPolygon(x1, y1, 3);

			int[] x2 = { 350, 380, 410 };
			int[] y2 = { 180, 300, 180 };

			g.setColor(new Color(201, 174, 155));
			g.fillPolygon(x2, y2, 3);

			tm.start();

		}
		
		/**
		 * Bewegung der animation wird festegelegt
		 * @param ActionEvent e, die Bewegung der Kreise festgelegt
		 */	
		
		public void actionPerformed(ActionEvent e) {

			if (y < 0 || y > 145)
				velX = -velX;

			y = y + velX;
			repaint();
		}
	}
}
