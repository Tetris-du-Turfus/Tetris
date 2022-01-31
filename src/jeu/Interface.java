package jeu;


import java.awt.BorderLayout;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Random;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.Font;


public class Interface extends JFrame {

	private JPanel contentPane;
	
	Puit p ;
	
	Tetromino tetrominoActuel;
	Tetromino tetrominoSuivant;
	
	private ImageIcon game_over = new ImageIcon("src/GameOver.png");
	private ImageIcon tetrisWord = new ImageIcon("src/Tetris.png");
	
	int Score;
	boolean partie_en_cours = false ;
	
	private Timer monTimer;
	private TimerTask task;
	int vitesse=1000;
	
	
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
	
	/**
	 * Fonction appelée lorsqu'une touche est pressée
	 * Elle sert également à déplacer et à exercer une rotation sur les tétromino
	 * @param evt : touche appelé
	 * @return true si c'est la touche entrée, false sinon
	 */
	private boolean KeyPressed(KeyEvent evt) {
		Boolean depFait;
		boolean flag = false ;
		if(partie_en_cours)
		{
			switch(evt.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				depFait=p.RotationPossible();
				if(depFait)
						p.RotationTetromino();
				 dessinerPuit(contentPane.getGraphics());
				 break;
			case KeyEvent.VK_DOWN:
				depFait=p.déplacementBasPossible();
				if(depFait)
					p.déplacementBas();
				dessinerPuit(contentPane.getGraphics());
				break;
			case KeyEvent.VK_LEFT:
				depFait=p.déplacementGauchePossible();
				if(depFait)
					p.déplacementGauche();
				dessinerPuit(contentPane.getGraphics());
				break;
			case KeyEvent.VK_RIGHT:
				depFait=p.déplacementDroitePossible();
				if(depFait)
					p.déplacementDroite();
				dessinerPuit(contentPane.getGraphics());
				break;
			}
		}
		else if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
			partie_en_cours=true;
			flag=true;
		}
			
		
		return flag;
		 
		 
	}
	/**
	 * Affiche le mot tétris
	 * @param graphics : graphique dans lequel sera affiché l'image tétris
	 */
	public void dessinerTetris(Graphics graphics) 
    {
		Image image;
		image = tetrisWord.getImage();
		graphics.drawImage(image, 5, 50,100,100,this);
    }
	
	/**
	 * Affiche l'image de fin
	 * @param graphics : graphique dans lequel sera affiché l'image de fin
	 */
	public void dessinerImage(Graphics graphics) 
    {
		Image image;
		image = game_over.getImage();
		graphics.drawImage(image, 0, 0,this.getContentPane().getWidth(),this.getContentPane().getHeight(),this);
    }
	
	/**
	 * affiche le puit
	 * @param g : graphique dans lequel sera affiché le puit
	 */
	public void dessinerPuit(Graphics g) {
		
		 Graphics bufferGraphics;
		 Image offscreen;

		 offscreen = createImage(260,480);
		 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
		 bufferGraphics = offscreen.getGraphics();
		 // On colore le fond de l'image en blanc
		 bufferGraphics.setColor(Color.LIGHT_GRAY);
		 bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight()); 
		 // on dessine notre objet au sein de notre image
		 p.Afficher(bufferGraphics);
		 // On afficher l'image mémoire à l'écran, on choisit où afficher l'image 
		 g.drawImage(offscreen,100,10,null);
	}
	
	
	/**
	 * Fonction pour afficher le prochain tétromino
	 * @param g : graphique dans lequel sera affiché le prochain tétromino
	 */
	public void dessinerTetrominoADroite(Graphics g)
	{
	 Graphics bufferGraphics;
	 Image offscreen;
	 
	 
	 // On crée une image en mémoire de la taille du ContentPane, on peut choisir la taille que l'on souhaite
	 offscreen = createImage(80,80);
	 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
	 bufferGraphics = offscreen.getGraphics();
	 // On colore le fond de l'image en blanc
	 bufferGraphics.setColor(Color.GRAY);
	 bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight()); 
	 
	 // on déssine le maillage 
	 for (int i = 0; i < 4; i++) {
			
		 bufferGraphics.setColor(Color.WHITE);
		 bufferGraphics.drawLine(i*20,0,i*20,80);
		 bufferGraphics.drawLine(0,i*20,80,i*20);
	 }
	 // on dessine notre objet au sein de notre image
	 tetrominoSuivant.Afficher(bufferGraphics);
	 // On afficher l'image mémoire à l'écran, on choisit où afficher l'image 
	 g.drawImage(offscreen,400,10,null);
	}
	
	
	public void dessinerScore(Graphics g)
	{
	 Graphics bufferGraphics;
	 Image offscreen;	 
	 // On crée une image en mémoire de la taille du ContentPane, on peut choisir la taille que l'on souhaite
	 offscreen = createImage(100,100);
	 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
	 bufferGraphics = offscreen.getGraphics();
	 // On colore le fond de l'image en blanc
	 bufferGraphics.setColor(Color.LIGHT_GRAY);
	 bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight()); 
	 bufferGraphics.setColor(Color.BLACK);
	 bufferGraphics.drawString("Score : " +String.valueOf(Score),20,20);	 
	 // On afficher l'image mémoire à l'écran, on choisit où afficher l'image 
	 g.drawImage(offscreen,350,200,null);
	}
	
	/**
	 * Fonction pour tirer un tétromino au hasards
	 * @return tétromino typé entre 1 et 7
	 */
	public Tetromino tirageTetromino() {
		Random random = new Random();
		int randomTetromino = random.nextInt(7) + 1;
		Tetromino prochainTetromino = null;
		 
		 switch (randomTetromino) {
		 	case 1 : prochainTetromino = new TetrominoType1(0,20);
		 			 break ;
		 	case 2 : prochainTetromino = new TetrominoType2(0,20);
			 		 break ;
		 	case 3 : prochainTetromino = new TetrominoType3(0,20);
			 		 break ;
		 	case 4 : prochainTetromino = new TetrominoType4(0,20);
			 		 break ;
		 	case 5 : prochainTetromino = new TetrominoType5(0,20);
			 		 break ;
		 	case 6 : prochainTetromino = new TetrominoType6(0,20);
			 		 break ;
		 	case 7 : prochainTetromino = new TetrominoType7(0,20);
			 		 break ;
		 	
		 }
		 return prochainTetromino;
	}
	
	/**
	 * Fonction qui change le tétromino actuel et qui supprime potenitiellement des lignes
	 * fonction qui intervien lorsque le tétromino actuel ne peut plus bouger
	 * @param g : graphique utilisé
	 */
	public void ChangementTetromino(Graphics g)
	{
		// on regarde si une ou plusieurs lignes n'ont pas été complété
		for (int i = tetrominoActuel.getObjetGraphique(0, 0).getY(); i <= tetrominoActuel.getObjetGraphique(3, 3).getY(); i++) {
			if(p.LigneComplete(i)) {
				p.SuppressionLigne(i);
				Score+=100;
				dessinerScore(g);
			}
		}
		//passage au tétromino suivant
		tetrominoActuel=tetrominoSuivant;
		p.AjouterTetromino(tetrominoActuel);
		tetrominoSuivant=tirageTetromino();
		Score+=20;
		dessinerScore(g);
		dessinerTetrominoADroite(contentPane.getGraphics());
	}
	
	/**
	 * Actions appelé à chaque tic de timer
	 * @param g : graphique utilisé
	 * @return
	 */
	private Boolean ticTimer(Graphics g) {
		Boolean depFait=p.déplacementBasPossible();
		//le déplacement vers le bas est possible 
		if(depFait)
			p.déplacementBas();
		else
			//la partie n'est pas perdu
			if(!p.partiePerdu())
				ChangementTetromino(g);
			else
				return false;
		
		dessinerPuit(contentPane.getGraphics());
		return true;
		}
	

	
	
	/**
	 * Create the frame.
	 *
	 */
	public Interface() {
		setTitle("T\u00E9tris C Euvrard & C. Faucheux");
	    
		
		contentPane = new JPanel();
		
		contentPane.setFocusable(true);
		contentPane.setBackground(Color.LIGHT_GRAY);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 525);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Interface.class.getResource("/jeu/tetris_image.jpg")));
		lblNewLabel.setBounds(0, 0, 552, 478);
		if(partie_en_cours)
			lblNewLabel.setVisible(false);
		else 
			lblNewLabel.setVisible(true);
		contentPane.add(lblNewLabel);

		contentPane.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				//on regarde si la touche entrée a été actionné
				if(KeyPressed(e)) {
					
					// On colore le fond de l'image en gris clair
					Image fond= createImage(getContentPane().getWidth(),getContentPane().getHeight());
					Graphics g=fond.getGraphics();
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(0,0,getContentPane().getWidth(),getContentPane().getHeight()); 
					//on applique cela à notre contentPane
					contentPane.getGraphics().drawImage(fond,0,0,null);

					Score=0;
					//initialisation du puit et des tétrominos
					tetrominoActuel=tirageTetromino();
					tetrominoSuivant=tirageTetromino();
					p = new Puit(10,10,20);
					p.AjouterTetromino(tetrominoActuel);
					
					//on déssine les éléments du l'image
					dessinerScore(contentPane.getGraphics());
					dessinerPuit(contentPane.getGraphics());
					dessinerTetrominoADroite(contentPane.getGraphics());
					dessinerTetris(contentPane.getGraphics());

					//initialisation du timmer
					monTimer = new Timer();
					//tache du timer
					task = new TimerTask() {
					 public void run() {
						 //Le joueur a perdu
						 //on appel la fonction ticTimer
						 if (!ticTimer(contentPane.getGraphics())) {
							 monTimer.cancel();
							 partie_en_cours = false ;
							 //affichage game over
							 dessinerImage(getGraphics());
						 }
						
					 }
					};
					//rythme d'appel de la fonction task 
					monTimer.schedule(task, new Date(), vitesse);
				}
			}
		});
	
		
	}
}