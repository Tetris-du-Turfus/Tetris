package jeu;

import java.awt.Color;
import java.awt.Graphics;

public class Puit {
	
	private ObjetGraphique[][] grille;
	
	private int positionXGrille;
	private int positionYGrille;
	
	private int dimGrilleX=14;
	private int dimGrilleY=24;
	
	private int repereX;
	private int repereY ;
	
	private Tetromino TetromnoActuel;
	
	public Puit(int positionX, int positionY,int tailleCase) {
		super();
		this.setPositionXGrille(positionX);
		this.setPositionYGrille(positionY);
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
		this.TetromnoActuel.Droite();
	}
	
	public int déplacementBasPossible() {
		int sortie=1;
		
		for(int i=0; i<4; i++) {
			for (int j = 3; j > -1; j--) {
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0 ) {
					if(j<3) {
						int val =this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()-this.TetromnoActuel.getObjetGraphique(i, j+1).getCouleur()+
								grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()+1].getCouleur();
						
						if(val>18) {
							sortie=0;
						}
					}
					//j=3
					else {
						int val =this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()+
								grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()+1].getCouleur();
						
						if(val>18) {
							sortie=0;
						}
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
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0) {
					if(i>0) {
						int val=this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()-this.TetromnoActuel.getObjetGraphique(i-1, j).getCouleur()+
								grille[TetromnoActuel.getObjetGraphique(i, j).getX()-1][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur();
						
						if(val>18) {
							sortie=0;
						}
					}
					//i=0
					else {
						int val=this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()+
								grille[TetromnoActuel.getObjetGraphique(i, j).getX()-1][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur();
						
						if(val>18) {
							sortie=0;
						}
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
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0 ) {
					if(i<3) {
						int val=this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()-this.TetromnoActuel.getObjetGraphique(i+1, j).getCouleur()+
								grille[TetromnoActuel.getObjetGraphique(i, j).getX()+1][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur();
						
						if(val>18) {
							sortie=0;
							
						}
					}
					//i=3
					else {
						int val=this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()+
								grille[TetromnoActuel.getObjetGraphique(i, j).getX()+1][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur();
						
						if(val>18) {
							sortie=0;
						}
					}
					
				}
			}
		}
		return sortie;
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
	
	public void afficher() {
		for(int i=0;i<dimGrilleY;i++) {
			afficherLigne(i);
		}
		System.out.print("\n");
	}
	public void afficherLigne(int j) {
		for(int i=0;i<dimGrilleX;i++) {
			System.out.print(grille[i][j].getCouleur());
			System.out.print(" ");
		}
		System.out.print("\n");
	}
	
	public void RotationTetromino() {
		int position = this.TetromnoActuel.getPosition();
		this.TetromnoActuel.setPosition((position+1)%4);
		
		//MAJ grille
		for(int i=0;i<4;i++) {
			for (int j = 0; j < 4; j++) {
				if(this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()!=0 || this.grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur()!=0)
					this.grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].setCouleur(
							this.TetromnoActuel.getObjetGraphique(i, j).getCouleur()-this.TetromnoActuel.getObjetGraphique(i, j,position).getCouleur()+
							grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur());
			}
		}
		
		
		
	}
	
	//retourne 1 si le déplacement est possible sinon 0
		public int RotationPossible() {
			int sortie=1;
			int position = this.TetromnoActuel.getPosition();
			for(int i=0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if(this.grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur()!=0 ) {
						int val=this.grille[TetromnoActuel.getObjetGraphique(i, j).getX()][TetromnoActuel.getObjetGraphique(i, j).getY()].getCouleur()+
								this.TetromnoActuel.getObjetGraphique(i, j,(position+1)%4).getCouleur()-this.TetromnoActuel.getObjetGraphique(i, j).getCouleur();
						
						if(val>18) {
							sortie=0;
							
						}
					}
				}
			}
			return sortie;
		}
		
		/**
		 * Fonction qui nous donne si une ligne est complete
		 * @param i : entier qui contient la ligne à regarder 
		 * @return  true si si la ligne est complète, false sinon 
		 */
		public boolean LigneComplete(int i) {
			for (int j = 2; j < dimGrilleX-2; j++) {
				if(this.grille[j][i].getCouleur()==0 ||this.grille[j][i].getCouleur()==9)
					return false;
			}
			return true;
		}
		
		/**
		 * Supprime une ligne de la grille et décale vers le bas toutes les lignes du dessus
		 * @param Ligne : entier contenant l'indice de la ligne à supprimer
		 */
		public void SuppressionLigne(int Ligne) {
			if(Ligne!=0) {
				for (int i = Ligne; i > 1; i--) {
					for (int j = 2; j < dimGrilleX-2; j++) {
						this.grille[j][i].setCouleur(this.grille[j][i-1].getCouleur());
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
		
		/**
		 * Fonction qui indique si l'on peut continuer à jouer ousi la partie est perdu
		 * @return 0 si la partie est perdu
		 */
		public int partiePerdu()
		{
			for(int i=0;i<4;i++) {
				for (int j = 0; j < 4; j++) {
					if(this.grille[i+this.repereX][j+this.repereY].getCouleur()!=0)
						return 0;
				}
			}
			return 1;
		}

		public int getDimGrilleX() {
			return dimGrilleX;
		}

		public void setDimGrilleX(int dimGrilleX) {
			this.dimGrilleX = dimGrilleX;
		}

		public int getDimGrilleY() {
			return dimGrilleY;
		}

		public void setDimGrilleY(int dimGrilleY) {
			this.dimGrilleY = dimGrilleY;
		}


		public int getPositionYGrille() {
			return positionYGrille;
		}

		public void setPositionYGrille(int positionYGrille) {
			this.positionYGrille = positionYGrille;
		}

		public int getPositionXGrille() {
			return positionXGrille;
		}

		public void setPositionXGrille(int positionXGrille) {
			this.positionXGrille = positionXGrille;
		}
			

}
