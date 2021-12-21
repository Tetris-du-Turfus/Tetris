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
