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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Interface extends JFrame {


	private JPanel contentPane;
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
	 Graphics bufferGraphics;
	 Image offscreen;
	 // On crée une image en mémoire de la taille du ContentPane, on peut choisir la taille que l'on souhaite
	 offscreen = createImage(100,100);
	 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
	 bufferGraphics = offscreen.getGraphics();
	 // On colore le fond de l'image en blanc
	 bufferGraphics.setColor(Color.WHITE);
	 bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight());
	 
	 // on dessine notre objet au sein de notre image
	 bufferGraphics.setColor(Color.YELLOW);
	 bufferGraphics.fillRect(0,0,50,50);
	 bufferGraphics.setColor(Color.GREEN);
	 bufferGraphics.fillRect(50,50,50,50);
	 ObjetGraphique Objt1=new ObjetGraphique(0, 1, 50);
	 Objt1.Afficher(bufferGraphics);
	 ObjetGraphique Objt2=new ObjetGraphique(1, 0, 50);
	 Objt2.Afficher(bufferGraphics);
	 // On afficher l'image mémoire à l'écran, on choisit où afficher l'image 
	 g.drawImage(offscreen,50,50,null);
	}
	
	/**
	 * Create the frame.
	 */
	public Interface() {
		
		this.getContentPane().setBackground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		//écriture 5
		a=5;
		JLabel lblNewLabel = new JLabel(Integer.toString(a));
		lblNewLabel.setBounds(185, 118, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Jouer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dessiner(contentPane.getGraphics());
			}
		});
		btnNewButton.setBounds(104, 153, 85, 21);
		contentPane.add(btnNewButton);
		
		//appelle dessiner pour dessiner une case
		
		//this.fillRect (10, 10, 200, 200);  
		
	}
	
	// comment test

}
