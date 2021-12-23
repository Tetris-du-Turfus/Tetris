package jeu;

import java.awt.Color;
import java.awt.Graphics;

public class Puit {
	
	protected ObjetGraphique[][] grille;
	protected int positionXGrille;
	protected int positionYGrille;
	
	protected int dimGrilleX=14;
	protected int dimGrilleY=24;
	
	protected int repereX;
	protected int repereY ;
	
	protected Tetromino TetromnoActuel;
	
	public Puit(int positionXGrille, int positionYGrille,int tailleCase) {
		super();
		this.positionXGrille = positionXGrille;
		this.positionYGrille = positionYGrille;
		this.repereX = 5;
		this.repereY = 0 ;
		
		this.grille = new ObjetGraphique[dimGrilleX][dimGrilleY];
		for (int i = 0; i <dimGrilleX; i++) {
			for (int j = 0; j < dimGrilleY; j++) {
				if(i==0 || i==1 || i==dimGrilleX-1 || i==dimGrilleX-2 || j==dimGrilleY-1 || j==dimGrilleY-2)
					this.grille[i][j]=new ObjetGraphique(i, j, tailleCase,9);
				else {
					this.grille[i][j]=new ObjetGraphique(i, j, tailleCase);
				}
			}
			
		}
		
	}
	
	public void AjouterTetromino(Tetromino t) {
		this.TetromnoActuel=t;
		this.TetromnoActuel.setRepere(this.repereX, this.repereY);
		for(int i=0;i<4;i++) {
			for (int j = 0; j < 4; j++) {
				this.grille[i+this.repereX][j+this.repereY].setCouleur(t.getObjetGraphique(i, j).getCouleur());
			}
		}
	}
	public void déplacementBas() {
		//tester avant si le déplacement est possible
		for(int i=0; i<4; i++) {
			for (int j = 3; j > -1; j--) {
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0) {
					grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].setCouleur(0);
					grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()+1].setCouleur(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()+
							grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()+1].getCouleur());
				}
			}
		}
		this.repereY ++ ;
		this.TetromnoActuel.Bas();
	}
	
	public void déplacementGauche() {
		//tester avant si le déplacement est possible
		for(int i=0; i<4; i++) {
			for (int j = 0; j < 4; j++) {
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0) {
					grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].setCouleur(0);
					grille[TetromnoActuel.getObjetGraphique(i, j).getX()-1][TetromnoActuel.getObjetGraphique(i, j).getY()].setCouleur(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()+
							grille[TetromnoActuel.getObjetGraphique(i, j).getX()-1][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur());
				}
			}
		}
		this.repereX -- ;
		this.TetromnoActuel.Gauche();
	}
	

	public void déplacementDroite() {
		
		for(int i=3; i>-1; i--) {
			for (int j = 0; j < 4; j++) {
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0) {
					grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].setCouleur(0);
					grille[TetromnoActuel.getObjetGraphique(i, j).getX()+1][TetromnoActuel.getObjetGraphique(i, j).getY()].setCouleur(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()+
							grille[TetromnoActuel.getObjetGraphique(i, j).getX()+1][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur());
				}
			}
		}
		this.repereX ++ ;
		this.TetromnoActuel.Droite();
	}
	
	public int déplacementBasPossible() {
		int sortie=1;
		
		for(int i=0; i<4; i++) {
			for (int j = 3; j > -1; j--) {
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0 && j<3) {
					
					int val =this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()-this.TetromnoActuel.getObjetGraphique(i, j+1).getCouleur()+
							grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()+1].getCouleur();
					
					if(val>18) {
						sortie=0;
					}
				}
			}
		}
		return sortie;
	}
	
	//retourne 1 si le déplacement est possible sinon 0
	public int déplacementGauchePossible() {
		int sortie=1;
		
		for(int i=0; i<4; i++) {
			for (int j = 0; j < 4; j++) {
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0 && i>0) {
					int val=this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()-this.TetromnoActuel.getObjetGraphique(i-1, j).getCouleur()+
							grille[TetromnoActuel.getObjetGraphique(i, j).getX()-1][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur();
					
					if(val>18) {
						sortie=0;
					}
				}
			}
		}
		return sortie;
	}
	
	//retourne 1 si le déplacement est possible sinon 0
	public int déplacementDroitePossible() {
		int sortie=1;
		
		for(int i=3; i>-1; i--) {
			for (int j = 0; j < 4; j++) {
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0 && i<3) {
					int val=this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()-this.TetromnoActuel.getObjetGraphique(i+1, j).getCouleur()+
							grille[TetromnoActuel.getObjetGraphique(i, j).getX()+1][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur();
					
					if(val>18) {
						sortie=0;
						
					}
				}
			}
		}
		return sortie;
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
	
	public void RotationTetromino() {
		int position = this.TetromnoActuel.getPosition();
		this.TetromnoActuel.setPosition((position+1)%4);
		
		//MAJ grille
		for(int i=0;i<4;i++) {
			for (int j = 0; j < 4; j++) {
				this.grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].setCouleur(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur());
			}
		}
		
		
		
	}


}
