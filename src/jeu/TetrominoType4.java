package jeu;

import java.awt.Graphics;


public class TetrominoType4 extends Tetromino{

	public TetrominoType4(int position,int tailleCase) {
		super(4, position);
		// TODO Auto-generated constructor stub
		int couleur =13;
		this.tab = new ObjetGraphique[4][4][4];
		//position 0
		
		this.tab[0][0][0]=new ObjetGraphique(0,0,tailleCase,0);
		this.tab[1][0][0]=new ObjetGraphique(1,0,tailleCase,couleur);
		this.tab[2][0][0]=new ObjetGraphique(2,0,tailleCase,couleur);
		this.tab[3][0][0]=new ObjetGraphique(3,0,tailleCase,0);
		
		this.tab[0][1][0]=new ObjetGraphique(0,1,tailleCase,0);
		this.tab[1][1][0]=new ObjetGraphique(1,1,tailleCase,couleur);
		this.tab[2][1][0]=new ObjetGraphique(2,1,tailleCase,couleur);
		this.tab[3][1][0]=new ObjetGraphique(3,1,tailleCase,0);
		
		this.tab[0][2][0]=new ObjetGraphique(0,2,tailleCase,0);
		this.tab[1][2][0]=new ObjetGraphique(1,2,tailleCase,0);
		this.tab[2][2][0]=new ObjetGraphique(2,2,tailleCase,0);
		this.tab[3][2][0]=new ObjetGraphique(3,2,tailleCase,0);
		
		this.tab[0][3][0]=new ObjetGraphique(0,3,tailleCase,0);
		this.tab[1][3][0]=new ObjetGraphique(1,3,tailleCase,0);
		this.tab[2][3][0]=new ObjetGraphique(2,3,tailleCase,0);
		this.tab[3][3][0]=new ObjetGraphique(3,3,tailleCase,0);

		// position 1
		
		this.tab[0][0][1]=new ObjetGraphique(0,0,tailleCase,0);
		this.tab[1][0][1]=new ObjetGraphique(1,0,tailleCase,couleur);
		this.tab[2][0][1]=new ObjetGraphique(2,0,tailleCase,couleur);
		this.tab[3][0][1]=new ObjetGraphique(3,0,tailleCase,0);
		
		this.tab[0][1][1]=new ObjetGraphique(0,1,tailleCase,0);
		this.tab[1][1][1]=new ObjetGraphique(1,1,tailleCase,couleur);
		this.tab[2][1][1]=new ObjetGraphique(2,1,tailleCase,couleur);
		this.tab[3][1][1]=new ObjetGraphique(3,1,tailleCase,0);
		
		this.tab[0][2][1]=new ObjetGraphique(0,2,tailleCase,0);
		this.tab[1][2][1]=new ObjetGraphique(1,2,tailleCase,0);
		this.tab[2][2][1]=new ObjetGraphique(2,2,tailleCase,0);
		this.tab[3][2][1]=new ObjetGraphique(3,2,tailleCase,0);
		
		this.tab[0][3][1]=new ObjetGraphique(0,3,tailleCase,0);
		this.tab[1][3][1]=new ObjetGraphique(1,3,tailleCase,0);
		this.tab[2][3][1]=new ObjetGraphique(2,3,tailleCase,0);
		this.tab[3][3][1]=new ObjetGraphique(3,3,tailleCase,0);
		
		//position 2
		
		this.tab[0][0][2]=new ObjetGraphique(0,0,tailleCase,0);
		this.tab[1][0][2]=new ObjetGraphique(1,0,tailleCase,couleur);
		this.tab[2][0][2]=new ObjetGraphique(2,0,tailleCase,couleur);
		this.tab[3][0][2]=new ObjetGraphique(3,0,tailleCase,0);
		
		this.tab[0][1][2]=new ObjetGraphique(0,1,tailleCase,0);
		this.tab[1][1][2]=new ObjetGraphique(1,1,tailleCase,couleur);
		this.tab[2][1][2]=new ObjetGraphique(2,1,tailleCase,couleur);
		this.tab[3][1][2]=new ObjetGraphique(3,1,tailleCase,0);
		
		this.tab[0][2][2]=new ObjetGraphique(0,2,tailleCase,0);
		this.tab[1][2][2]=new ObjetGraphique(1,2,tailleCase,0);
		this.tab[2][2][2]=new ObjetGraphique(2,2,tailleCase,0);
		this.tab[3][2][2]=new ObjetGraphique(3,2,tailleCase,0);
		
		this.tab[0][3][2]=new ObjetGraphique(0,3,tailleCase,0);
		this.tab[1][3][2]=new ObjetGraphique(1,3,tailleCase,0);
		this.tab[2][3][2]=new ObjetGraphique(2,3,tailleCase,0);
		this.tab[3][3][2]=new ObjetGraphique(3,3,tailleCase,0);

		// position 3
		
		this.tab[0][0][3]=new ObjetGraphique(0,0,tailleCase,0);
		this.tab[1][0][3]=new ObjetGraphique(1,0,tailleCase,couleur);
		this.tab[2][0][3]=new ObjetGraphique(2,0,tailleCase,couleur);
		this.tab[3][0][3]=new ObjetGraphique(3,0,tailleCase,0);
		
		this.tab[0][1][3]=new ObjetGraphique(0,1,tailleCase,0);
		this.tab[1][1][3]=new ObjetGraphique(1,1,tailleCase,couleur);
		this.tab[2][1][3]=new ObjetGraphique(2,1,tailleCase,couleur);
		this.tab[3][1][3]=new ObjetGraphique(3,1,tailleCase,0);
		
		this.tab[0][2][3]=new ObjetGraphique(0,2,tailleCase,0);
		this.tab[1][2][3]=new ObjetGraphique(1,2,tailleCase,0);
		this.tab[2][2][3]=new ObjetGraphique(2,2,tailleCase,0);
		this.tab[3][2][3]=new ObjetGraphique(3,2,tailleCase,0);
		
		this.tab[0][3][3]=new ObjetGraphique(0,3,tailleCase,0);
		this.tab[1][3][3]=new ObjetGraphique(1,3,tailleCase,0);
		this.tab[2][3][3]=new ObjetGraphique(2,3,tailleCase,0);
		this.tab[3][3][3]=new ObjetGraphique(3,3,tailleCase,0);
	}

	public void Afficher(Graphics g) {
		
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(this.tab[i][j][position].couleur!=0)
					this.tab[i][j][position].Afficher(g);
			}
		}
		
	}

}
