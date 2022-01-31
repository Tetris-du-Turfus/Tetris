package jeu;

import java.awt.Color;
import java.awt.Graphics;

public class ObjetGraphique {
	protected int x;
	protected int y;
	protected int tailleCase;
	protected int couleur ;
	
	/**
	 * Constructeur d'un objetGraphique
	 * @param x : position en x
	 * @param y : position en y
	 * @param tailleCase : dimension des cases
	 * @param couleur : valeur de la couleur de l'objet
	 */
	public ObjetGraphique(int x, int y, int tailleCase,int couleur) {
		super();
		this.x = x;
		this.y = y;
		this.tailleCase = tailleCase;
		this.couleur=couleur;

	}
	
	/**
	 * Constructeur d'un objetGraphique pour une case vide 
	 * couleur = 0
	 * @param x : position en x
	 * @param y : position en y
	 * @param tailleCase : dimension des cases
	 */
	public ObjetGraphique(int x, int y, int tailleCase) {
		super();
		this.x = x;
		this.y = y;
		this.tailleCase = tailleCase;
		//paramètre par défault 0
		this.couleur=0;

	}

	/**
	 * getteur de x
	 * @return entier x
	 */
	public int getX() {
		return x;
	}


	/**
	 * setteur de x
	 * @param x : entier 
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * getteur de y
	 * @return entier y
	 */
	public int getY() {
		return y;
	}

	/**
	 * setteur de y
	 * @param y : entier 
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * getteur de la taille des cases
	 * @return entier taille des cases
	 */
	public int getTailleCase() {
		return tailleCase;
	}

	/**
	 * setteur de la taille des cases
	 * @param tailleCase : entier
	 */
	public void setTailleCase(int tailleCase) {
		this.tailleCase = tailleCase;
	};
	
	/**
	 * getteur de la couleur de la case
	 * @return entier couleur de la case
	 */
	public int getCouleur() {
		return couleur;
	}

	/**
	 * setteur de couleur
	 * @param c : entier
	 */
	public void setCouleur(int c) {
		this.couleur = c;
	}
	
	//@Override
	/**
	 * Affichage de l'objet graphique
	 * @param g : graphique dans lequel sera dessiner l'objet
	 */
	public void Afficher(Graphics g) {
		// On changer la couleur du pinceau
		switch (couleur) {
		case 10:
			g.setColor(Color.GREEN);
			break;
		case 11:
			g.setColor(Color.CYAN);
			break;
		case 12:
			g.setColor(Color.RED);
			break;
		case 13:
			g.setColor(Color.BLUE);
			break;
		case 14:
			g.setColor(Color.ORANGE);
			break;
		case 15:
			g.setColor(Color.MAGENTA);
			break;
		case 16:
			g.setColor(Color.WHITE);
			break;
			
		default:
			g.setColor(Color.GRAY);
			break;
		}

		 // On trace un rectangle dans l'objet de type Graphics passé en paramètre
		 g.fillRect(this.x*this.tailleCase+1,this.y*this.tailleCase+1, this.tailleCase-2,this.tailleCase-2);
	 }
	
}
