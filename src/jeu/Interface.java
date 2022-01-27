package jeu;

import java.awt.BorderLayout;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Random;


public class Interface extends JFrame {

	private JPanel contentPane;
	int vitesse=1000;
	int a;
	TetrominoType7 Objt;
	Puit p ;
	Tetromino tetrominoActuel;
	Tetromino tetrominoSuivant;
	private ImageIcon game_over;
	boolean partie_perdue = false ;
	int Score;
	
	private Timer monTimer;
	private TimerTask task;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
					frame.setBackground(Color.BLACK);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void KeyPressed(KeyEvent evt) {
		int depFait;
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
	
	public void paintComponent(Graphics graphics) 
    {
		Graphics bufferGraphics;
		Image offscreen;
		offscreen = game_over.getImage();
		bufferGraphics = offscreen.getGraphics();
		//bufferGraphics.setColor(Color.GRAY);
		//super.paintComponents(graphics);
		//bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight()); 
		graphics.drawImage(offscreen,0,0,500,500,null);
		//graphics.drawImage(game_over.getImage(), 350, 500,200,200, this);
      
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
		 g.drawImage(offscreen,100,10,null);
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
	 g.drawImage(offscreen,10,10,null);
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
		for (int i = tetrominoActuel.getObjetGraphique(0, 0).getY(); i < tetrominoActuel.getObjetGraphique(3, 3).getY(); i++) {
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
	
	/*
	public void dessinerImage( Graphics g ) {


		  // (x, y) coin superieur gauche de l'image
		  g.drawImage(
		    game_over.getImage(),
		    350, 500,
		    200, 200,
		    null
		  );
		}
	*/
	
	
	
	/**
	 * Create the frame.
	 */
	public Interface() {
	    
		Score=0;
		tetrominoActuel=tirageTetromino();
		tetrominoSuivant=tirageTetromino();
		p = new Puit(10,10,20);
		p.AjouterTetromino(tetrominoActuel);
		contentPane = new JPanel();
		
		contentPane.setFocusable(true);
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				KeyPressed(e);
			}
		});
		contentPane.setBackground(Color.BLACK);
		this.getContentPane().setBackground(Color.BLACK);
		//this.setVisible(true);
		
		//this.getContentPane().setBackground(Color.RED);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 525);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		game_over = new ImageIcon("src/game_over.png");
		
		
		/*
		//écriture 5
		a=5;
		JLabel lblNewLabel = new JLabel(Integer.toString(a));
		lblNewLabel.setBounds(185, 118, 45, 13);
		contentPane.add(lblNewLabel);
		*/
		
		JButton btnNewButton = new JButton("Jouer");
		btnNewButton.setFocusable(false);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dessinerScore(contentPane.getGraphics());
				dessinerPuit(contentPane.getGraphics());
				dessinerTetrominoADroite(contentPane.getGraphics());
				monTimer = new Timer();
				task = new TimerTask() {
				 public void run() {
					 if(Score>40) {
						 vitesse=200;
					 }
						
					 if (ticTimer(contentPane.getGraphics())==0) {
						 monTimer.cancel();
					     // afficher un message pour dire que la partie est perdu
						 //repaint();
						 paintComponent(contentPane.getGraphics());
						 //contentPane.getGraphics().drawImage(game_over.getImage(),165,10,500,150,null);
					 }
					
				 }
				};
				monTimer.schedule(task, new Date(), vitesse);
			}
		});
		
		/*
		if (partie_perdue) {
			contentPane.getGraphics().drawImage(game_over.getImage(),0,0,40,30,null);
		}
		*/
		
		btnNewButton.setBounds(104, 153, 85, 21);
		contentPane.add(btnNewButton);
		
		
		
	}
}
