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
	private ImageIcon tetris_background = new ImageIcon("src/tetris_image.jpg");
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
					/*frame.setVisible(true);
					frame.setBackground(Color.LIGHT_GRAY);
					ImageIcon icon = new ImageIcon("src/tetris_image.jpg");
					JTextArea text = new JTextArea() 
				    {
				      Image img = icon.getImage();
				      // instance initializer
				      {setOpaque(false);}
				      public void paintComponent(Graphics graphics) 
				      {
				        graphics.drawImage(img, 0, 0,560,525, this);
				        super.paintComponent(graphics);
				      }
				    };
				    JScrollPane pane = new JScrollPane(text);
				    Container content = frame.getContentPane();
				    content.add(pane, BorderLayout.CENTER);
				    frame.setDefaultCloseOperation(3);
				    //frame.setSize(400, 300);*/
				    frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	//Fonction appelée lorsqu'une touche est pressée
	//Retourne true si c'est la touche entrée, false sinon
	//Elle sert également à déplacer et à exercer une rotation sur les tétromino
	private boolean KeyPressed(KeyEvent evt) {
		int depFait;
		boolean flag = false ;
		if(partie_en_cours)
		{
			switch(evt.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				depFait=p.RotationPossible();
				if(depFait==1)
						p.RotationTetromino();
				 dessinerPuit(contentPane.getGraphics());
				 break;
			case KeyEvent.VK_DOWN:
				depFait=p.déplacementBasPossible();
				if(depFait==1)
					p.déplacementBas();
				dessinerPuit(contentPane.getGraphics());
				break;
			case KeyEvent.VK_LEFT:
				depFait=p.déplacementGauchePossible();
				if(depFait==1)
					p.déplacementGauche();
				dessinerPuit(contentPane.getGraphics());
				break;
			case KeyEvent.VK_RIGHT:
				depFait=p.déplacementDroitePossible();
				if(depFait==1)
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
	public void dessinerTetris(Graphics graphics) 
    {
		Image image;
		image = tetrisWord.getImage();
		graphics.drawImage(image, 5, 50,100,120,this);
    }
	
	public void dessinerImage(Graphics graphics) 
    {
		Image image;
		image = game_over.getImage();
		graphics.drawImage(image, 0, 0,this.getContentPane().getWidth(),this.getContentPane().getHeight(),this);
    }
	
	@Override
	public void paintComponents(Graphics g) { // paint() method
		
		g.drawImage(tetris_background.getImage(),0,0,560,525, this);
		super.paintComponents(g);
	}
	
	public void dessinerPuit(Graphics g) {
		
		 Graphics bufferGraphics;
		 Image offscreen;

		 offscreen = createImage(260,480);
		 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
		 bufferGraphics = offscreen.getGraphics();
		 // On colore le fond de l'image en blanc
		 bufferGraphics.setColor(Color.LIGHT_GRAY);
		 bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight()); 
		 //bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight()); 
		 // on dessine notre objet au sein de notre image
		 p.Afficher(bufferGraphics);
		 // On afficher l'image mémoire à l'écran, on choisit où afficher l'image 
		 //offscreen.setOpaque(false);
		 g.drawImage(offscreen,100,10,null);
	}
	
	
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
	 bufferGraphics.setColor(Color.RED);
	 bufferGraphics.drawString(String.valueOf(Score),20,20);	 
	 // On afficher l'image mémoire à l'écran, on choisit où afficher l'image 
	 g.drawImage(offscreen,400,300,null);
	}
	
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
	
	public void ChangementTetromino(Graphics g)
	{
		//p.afficher();
		for (int i = tetrominoActuel.getObjetGraphique(0, 0).getY(); i <= tetrominoActuel.getObjetGraphique(3, 3).getY(); i++) {
			//p.afficherLigne(i);
			if(p.LigneComplete(i)) {
				//System.out.print(i+"\n");
				//p.afficherLigne(i);
				p.SuppressionLigne(i);
				Score+=100;
				dessinerScore(g);
			}
		}
		tetrominoActuel=tetrominoSuivant;
		p.AjouterTetromino(tetrominoActuel);
		tetrominoSuivant=tirageTetromino();
		Score+=20;
		dessinerScore(g);
		dessinerTetrominoADroite(contentPane.getGraphics());
	}
	
	private int ticTimer(Graphics g) {
		int depFait=p.déplacementBasPossible();
			if(depFait==1)
				p.déplacementBas();
			else
				if(p.partiePerdu()==1)
					ChangementTetromino(g);
				else
					return 0;
		
		dessinerPuit(contentPane.getGraphics());
		return 1;
		}
	

	
	
	/**
	 * Create the frame.
	 *
	 */
	public Interface() {
	    
		
		contentPane = new JPanel();
		
		contentPane.setFocusable(true);
		contentPane.setBackground(Color.LIGHT_GRAY);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 525);
		//BufferedImage img = ImageIO.read("src/game_over.png");
		//contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*
		JLabel lbtxt = new JLabel("Appuyer sur Entr\u00E9e pour jouer");
		lbtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbtxt.setForeground(Color.WHITE);
		lbtxt.setBounds(147, 313, 233, 36);
		if(partie_en_cours)
			lbtxt.setVisible(false);
		else 
			lbtxt.setVisible(true);
		//contentPane.add(lbtxt);
		*/
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Interface.class.getResource("/jeu/tetris_image.jpg")));
		lblNewLabel.setBounds(0, 0, 552, 478);
		if(partie_en_cours)
			lblNewLabel.setVisible(false);
		else 
			lblNewLabel.setVisible(true);
		contentPane.add(lblNewLabel);
		
		
		
		//contentPane.getGraphics().drawImage(game_over.getImage(),165,10,150,150,null);
		contentPane.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(KeyPressed(e)) {
					//contentPane.remove(lblNewLabel);
					//contentPane.remove(lbtxt);
					//TextEntree.setVisible(false);
					
					Image fond= createImage(getContentPane().getWidth(),getContentPane().getHeight());
					Graphics g=fond.getGraphics();
					 // On colore le fond de l'image en blanc
					 g.setColor(Color.LIGHT_GRAY);
					 g.fillRect(0,0,getContentPane().getWidth(),getContentPane().getHeight()); 
					 
					contentPane.getGraphics().drawImage(fond,0,0,null);
					//contentPane.getGraphics().fillRect(0,0,getContentPane().getWidth(),getContentPane().getHeight()); 
					 
					//contentPane.getGraphics().drawRect(game_over.getImage(),165,10,150,150,null);
					Score=0;
					tetrominoActuel=tirageTetromino();
					tetrominoSuivant=tirageTetromino();
					p = new Puit(10,10,20);
					p.AjouterTetromino(tetrominoActuel);
					
					//contentPane.setBackground(Color.LIGHT_GRAY);
					dessinerScore(contentPane.getGraphics());
					dessinerPuit(contentPane.getGraphics());
					dessinerTetrominoADroite(contentPane.getGraphics());
					dessinerTetris(contentPane.getGraphics());

					monTimer = new Timer();
					task = new TimerTask() {
					 public void run() {
						 //Le joueur a perdu
						 if (ticTimer(contentPane.getGraphics())==0) {
							 monTimer.cancel();
							 partie_en_cours = false ;
							 //affichage game over
							 dessinerImage(getGraphics());
							 //contentPane.getGraphics().drawImage(game_over.getImage(),165,10,150,150,null);
						 }
						
					 }
					};
					monTimer.schedule(task, new Date(), vitesse);
				}
			}
		});
	
		
	}
}