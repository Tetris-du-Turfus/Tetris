package jeu;

import java.awt.Color;
import java.awt.Graphics;

public class Puit {
	
	protected ObjetGraphique[][] grille;
	protected int positionXGrille;
	protected int positionYGrille;
	
	protected int dimGrilleX=14;
	protected int dimGrilleY=24;
	
	protected Tetromino TetromnoActuel;
	
	public Puit(int positionXGrille, int positionYGrille,int tailleCase) {
		super();
		this.positionXGrille = positionXGrille;
		this.positionYGrille = positionYGrille;
		
		this.grille = new ObjetGraphique[dimGrilleX][dimGrilleY];
		for (int i = 0; i <dimGrilleX; i++) {
			for (int j = 0; j < dimGrilleY; j++) {
				this.grille[i][j]=new ObjetGraphique(i, j, tailleCase);
			}
			
		}
	}
	
	public void AjouterTetromino(Tetromino t) {
		this.TetromnoActuel=t;
		this.TetromnoActuel.setRepere(5, 0);
		for(int i=0;i<4;i++) {
			for (int j = 0; j < 4; j++) {
				this.grille[i+5][j]=this.TetromnoActuel.getObjetGraphique(i, j);
			}
		}
	}
	public void déplacementBas() {
		//tester si le déplacement est possible
		for(int i=0; i<4; i++) {
			for (int j = 3; j > 0; j--) {
				/*if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0) {
					grille[TetromnoActuel.getObjetGraphique(0, 0).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].setCouleur(0);
					grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()+1].setCouleur(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur());
				}*/	
			}
		}
		this.TetromnoActuel.Bas();
		
	}
	
	
	public Puit() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void Afficher(Graphics g) {
		for (int i = 2; i < dimGrilleX-2; i++) {
			for (int j = 0; j < dimGrilleY-2; j++) {
				this.grille[i][j].Afficher(g);
			}
			g.setColor(Color.WHITE);
			g.drawLine(i*this.grille[0][0].tailleCase,0,i*this.grille[0][0].tailleCase,(dimGrilleY-2)*this.grille[0][0].tailleCase);
		}
		g.setColor(Color.WHITE);
		g.drawLine((dimGrilleX-2)*this.grille[0][0].tailleCase,0,(dimGrilleX-2)*this.grille[0][0].tailleCase,(dimGrilleY-2)*this.grille[0][0].tailleCase);
		for (int j = 0; j < dimGrilleY-1; j++) {
			g.setColor(Color.WHITE);
			g.drawLine(2*this.grille[0][0].tailleCase,j*this.grille[0][0].tailleCase,(dimGrilleX-2)*this.grille[0][0].tailleCase,j*this.grille[0][0].tailleCase);
		}
		 
	}


}
