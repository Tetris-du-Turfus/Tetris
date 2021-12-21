package jeu;

import java.awt.Graphics;

public class Puit {
	
	protected ObjetGraphique[][] grille;
	protected int positionXGrille;
	protected int positionYGrille;
	
	protected int dimGrilleX=14;
	protected int dimGrilleY=25;
	
	public Puit(int positionXGrille, int positionYGrille,int tailleCase) {
		super();
		this.positionXGrille = positionXGrille;
		this.positionYGrille = positionYGrille;
		
		ObjetGraphique[][] grille = new ObjetGraphique[dimGrilleX][dimGrilleY];
		for (int i = 0; i <dimGrilleX; i++) {
			for (int j = 0; j < dimGrilleY; j++) {
				grille[i][j]=new ObjetGraphique(i+positionXGrille, j+positionYGrille, tailleCase);
			}
			
		}
	}

	public Puit() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void Afficher(Graphics g) {
		 g.fillRect(this.positionXGrille,this.positionYGrille, this.dimGrilleX,this.dimGrilleY);
	}


}
