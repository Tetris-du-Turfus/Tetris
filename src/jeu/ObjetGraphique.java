package jeu;

import java.awt.Color;
import java.awt.Graphics;

public class ObjetGraphique {
	protected int x;
	protected int y;
	protected int tailleCase;
	protected int couleur ;
	
	public ObjetGraphique(int x, int y, int tailleCase,int couleur) {
		super();
		this.x = x;
		this.y = y;
		this.tailleCase = tailleCase;
		this.couleur=couleur;

	}
	
	public ObjetGraphique(int x, int y, int tailleCase) {
		super();
		this.x = x;
		this.y = y;
		this.tailleCase = tailleCase;
		//paramètre par défault 0
		this.couleur=0;

	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTailleCase() {
		return tailleCase;
	}

	public void setTailleCase(int tailleCase) {
		this.tailleCase = tailleCase;
	};
	
	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int c) {
		this.couleur = c;
	}
	
	//@Override
	public void Afficher(Graphics g) {
		// On changer la couleur du pinceau
		if (couleur==0) {
			g.setColor(Color.GRAY);
		}
		else {
			 g.setColor(Color.RED);
		}


		 // On trace un rectangle dans l'objet de type Graphics passé en paramètre
		 g.fillRect(this.x*this.tailleCase+1,this.y*this.tailleCase+1, this.tailleCase-2,this.tailleCase-2);
	 }
	
	// test ici
	// comment
}
