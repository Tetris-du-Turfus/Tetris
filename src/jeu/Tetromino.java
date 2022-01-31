package jeu;
import java.awt.Graphics;

/**
 * @author Camille et Clément
 *Classe Tétromino
 */
public abstract class Tetromino {
	
	protected ObjetGraphique[][][] tab;
	protected int position;
	protected int type;
	
	/**
	 * Constructeur d'un tétromino
	 */
	public Tetromino() {
		// TODO Auto-generated constructor stub
		this.tab = new ObjetGraphique[4][4][4];
	}

	/**
	 * Constructeur d'un tétromino
	 * @param type : entier représentant le type de tétromino
	 * @param position : entier repésentant la position du tétromino
	 */
	public Tetromino(int type, int position) {
		super();
		this.type = type;
		this.position = position;
		this.tab = new ObjetGraphique[4][4][4];
	}

	/**
	 *getteur de position
	 * @return entier : position du tétromino
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * setteur de position
	 * @param position : entier représentant la position du tétromino
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * getteur de type
	 * @return entier : type du tétromino
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * retourne l'objet graphique de la position (i,j)
	 * @param i : entier
	 * @param j : entier
	 * @return objetGraphique 
	 */
	public ObjetGraphique getObjetGraphique(int i, int j) {
		return tab[i][j][position];
	}
	
	
	/**
	 * retourne l'objet graphique de la position (i,j) à une position k
	 * @param i : entier
	 * @param j : entier
	 * @param k : entier représentant la position que l'on souhaite 
	 * @return objetGraphique 
	 */
	public ObjetGraphique getObjetGraphique(int i, int j,int k) {
		return tab[i][j][k];
	}
	
	
	/**
	 * Translate les coordonnées d'un tétromino 
	 * @param x : entier translation horizontale
	 * @param y : entier translation verticale
	 */
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
	
	
	/**
	 * Déplace le tétromino d'un pas à gauche
	 */
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
	
	/**
	 * Déplace le tétromino d'un pas à droite
	 */
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
	
	/**
	 * Déplace le tétromino d'un pas vers le bas
	 */
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
	
	/**
	 * Fonction abstraite pour afficher un tétromino
	 * @param g : graphique dans lequel sera dessiner le tétromino
	 */
	public abstract void Afficher(Graphics g);
}
