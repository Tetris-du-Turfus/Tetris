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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class Interface extends JFrame {


	private JPanel contentPane;
	int a;
	TetrominoType7 Objt;
	Puit p ;
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
	
	private void formMouseClicked(java.awt.event.MouseEvent evt) {
		 // On récupere les coordonnées du pointeur de la souris dans la fenêtre
		 int sourisX = evt.getPoint().x;
		 int sourisY = evt.getPoint().y;
		 
		 // On fait le changement de repère pour se ramener au ContentPane
		 sourisY-= (this.getHeight()-this.getContentPane().getHeight());
		 
		 System.out.println( sourisX );
		 System.out.println( sourisY );

		 // marche pas
		 if (sourisX <= 70 && sourisX >= 50 && sourisY <= 70 && sourisY >= 50 ) {
			 
			 Objt.setPosition(Objt.getPosition()+1); // gérer modulo
			 dessinerTetromino(contentPane.getGraphics());
		 }
		 
	}
	
	public void dessinerPuit(Graphics g) {
		
		 Graphics bufferGraphics;
		 Image offscreen;

		 offscreen = createImage(300,480);
		 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
		 bufferGraphics = offscreen.getGraphics();
		 // On colore le fond de l'image en blanc
		 bufferGraphics.setColor(Color.GRAY);
		 //bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight()); 
		 // on dessine notre objet au sein de notre image
		 //Puit p=new Puit(10,10,50)
		 p.Afficher(bufferGraphics);
		 // On afficher l'image mémoire à l'écran, on choisit où afficher l'image 
		 g.drawImage(offscreen,50,50,null);
	}
	
	public void dessinerTetromino(Graphics g)
	{
	 Graphics bufferGraphics;
	 Image offscreen;
	 // On crée une image en mémoire de la taille du ContentPane, on peut choisir la taille que l'on souhaite
	 offscreen = createImage(200,200);
	 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
	 bufferGraphics = offscreen.getGraphics();
	 // On colore le fond de l'image en blanc
	 bufferGraphics.setColor(Color.WHITE);
	 bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight()); 
	 // on dessine notre objet au sein de notre image
	 //TetrominoType1 Objt=new TetrominoType1(1, 50);
	 Objt.Afficher(bufferGraphics);
	 // On afficher l'image mémoire à l'écran, on choisit où afficher l'image 
	 g.drawImage(offscreen,50,50,null);
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
		Objt=new TetrominoType7(0, 20);
		p = new Puit(10,10,20);
		p.AjouterTetromino(Objt);
		contentPane = new JPanel();
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				formMouseClicked(e);
			}
		});
		
		this.getContentPane().setBackground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		//écriture 5
		a=5;
		JLabel lblNewLabel = new JLabel(Integer.toString(a));
		lblNewLabel.setBounds(185, 118, 45, 13);
		contentPane.add(lblNewLabel);
		*/
		
		JButton btnNewButton = new JButton("Jouer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dessiner(contentPane.getGraphics());
				//dessinerTetromino(contentPane.getGraphics());
				//Objt.Gauche();
				
				dessinerPuit(contentPane.getGraphics());
				/*int depFait=p.DeplacementDroitePossible();
				if(depFait==1)
					p.déplacementDroite();
					*/
				/*int depFait=p.DeplacementGauchePossible();
				if(depFait==1)
					p.déplacementGauche();
				*/
				int depFait=p.DeplacementBasPossible();
				if(depFait==1)
					p.déplacementBas();
				
			}
		});
		btnNewButton.setBounds(104, 153, 85, 21);
		contentPane.add(btnNewButton);
		
		
		
	}
	
	// comment test

}
