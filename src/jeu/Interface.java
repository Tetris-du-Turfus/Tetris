package jeu;

import java.awt.BorderLayout;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jeu.MonPanel;

import javax.swing.JLabel;

import java.awt.Image;


public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonPanel contentPane;
	int a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void dessiner(Graphics g)
	{
		/*
		
		//�criture 5
		a=5;
		JLabel lblNewLabel = new JLabel(Integer.toString(a));
		lblNewLabel.setBounds(185, 118, 45, 13);
		contentPane.add(lblNewLabel);
		
		*/
			
		Graphics bufferGraphics;
		Image offscreen;

		ObjetGraphique o;
		
		//objet graphique coordonn�es : 10,10 et taille de la case : 5
		o = new ObjetGraphique(10,10,5);
		
		System.out.println(this.getContentPane().getWidth()); // retourne 0, je comprends pas pourquoi
		
		// On cr�e une image en m�moire de la taille du ContentPane
		//Le probl�me est ici : createImage retourne null, cel� signifie que l'image n'est pas affichable
		offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
		
		// On r�cup�re l'objet de type Graphics permettant de dessiner dans cette image
		bufferGraphics = offscreen.getGraphics();
		// On colore le fond de l'image en blanc
		bufferGraphics.setColor(Color.WHITE);
		bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight());
		
		// On dessine les objets graphiques de la liste dans l'image en m�moire pour �viter les
		// probl�mes de scintillements

		o.Afficher(bufferGraphics);
		// On afficher l'image m�moire � l'�cran
		g.drawImage(offscreen,0,getContentPane().getWidth(),null);
		
		
		
		
	} 

	/**
	 * Create the frame.
	 */
	public Interface() {
		
		contentPane = new MonPanel(this);

		
		contentPane.setFocusable(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		this.getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);

		
		//�criture 5
		a=5;
		JLabel lblNewLabel = new JLabel(Integer.toString(a));
		lblNewLabel.setBounds(185, 118, 45, 13);
		contentPane.add(lblNewLabel);
		
		//appelle dessiner pour dessiner une case
		dessiner(this.getContentPane().getGraphics());
		
		//this.fillRect (10, 10, 200, 200);  
		
	}
	
	// comment test

}
