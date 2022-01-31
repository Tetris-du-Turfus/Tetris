package jeu;
import java.awt.Graphics;

public abstract class Tetromino {
	
	protected ObjetGraphique[][][] tab;
	protected int position;
	protected int type;
	
	public Tetromino() {
		// TODO Auto-generated constructor stub
		this.tab = new ObjetGraphique[4][4][4];
	}

	public Tetromino(int type, int position) {
		super();
		this.type = type;
		this.position = position;
		this.tab = new ObjetGraphique[4][4][4];
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public ObjetGraphique getObjetGraphique(int i, int j) {
		return tab[i][j][position];
	}
	
	
	public ObjetGraphique getObjetGraphique(int i, int j,int k) {
		return tab[i][j][k];
	}
	
	
	public void setRepere(int x,int y) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					this.tab[i][j][k].setX(this.tab[i][j][k].getX()+x);
					this.tab[i][j][k].setY(this.tab[i][j][k].getY()+y);
				}
			}
		}
	}
	public void Gauche() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					int val=this.tab[i][j][k].getX();
					this.tab[i][j][k].setX(val-1);
				}
			}
		}
	}
	
	public void Droite() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					int val=this.tab[i][j][k].getX();
					this.tab[i][j][k].setX(val+1);
				}
			}
		}
	}
	
	public void Bas() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					int val=this.tab[i][j][k].getY();
					this.tab[i][j][k].setY(val+1);
				}
			}
		}
	}
	
	public abstract void Afficher(Graphics g);
}
